package org.c3s.edgo.web.client;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.c3s.annotations.Controller;
import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.data.mapers.GeneralDataMapper;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBLastEventForUserBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.edgo.event.impl.ShipyardNew;
import org.c3s.edgo.utils.SimpleJsonParser;
import org.c3s.edgo.web.GeneralController;
import org.c3s.edgo.web.validator.Result;
import org.c3s.web.redirect.DropRedirect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class RemoteClient extends GeneralController {
	
	private static Logger logger = LoggerFactory.getLogger(RemoteClient.class);
	
	private SimpleJsonParser parser = new SimpleJsonParser();
	

	public void getRequest(@ParameterRequest("userID") String userId, @ParameterRequest("data") String data, @Parameter("tag") String tag, RedirectControlerInterface redirect) 
			throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
		
		DBUsersBean user =  DbAccess.usersAccess.getByUuid(userId);
		if (user != null) {
			try {
				KeyFactory keyFactory = KeyFactory.getInstance("RSA");
				PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(user.getUserKey().getPrivateKey()));
				PrivateKey privateKey = (PrivateKey) keyFactory.generatePrivate(privSpec);
				
				
				//System.out.println("Here");
				byte[] dataDecoded = Base64.getDecoder().decode(data);
				//System.out.println(dataDecoded.length);
				Cipher cipher = Cipher.getInstance( "RSA" );
				cipher.init(Cipher.DECRYPT_MODE, privateKey);
				
				//int chunkSize = cipher.getOutputSize(dataDecoded.length);
				int chunkSize = cipher.getOutputSize(dataDecoded.length);
				int idx = 0;
				ByteBuffer buf = ByteBuffer.allocate(dataDecoded.length);
				while(idx < dataDecoded.length) {
				    int len = Math.min(dataDecoded.length-idx, chunkSize);
				    //System.out.println(idx);
				    //System.out.println(len);
				    byte[] buffer = Arrays.copyOfRange(dataDecoded, idx, idx + chunkSize);
				    //System.out.println(buffer.length);
				    //byte[] chunk = cipher.doFinal(dataDecoded, idx, len);
				    byte[] chunk = cipher.doFinal(buffer);
				    buf.put(chunk);
				    idx += len;
				}				
				
				//byte[] result = cipher.doFinal(dataDecoded);
				byte[] result = buf.array(); 
	
				String resultStr = new String(result, "UTF-8").trim(); 
				
				//Map<?,?> res = null;
				Result ret = new Result().put("result", "OK");
				if ("HELLO".equals(resultStr)) {
					// Do nothing
				} else if ("RESUME".equals(resultStr)) {
					DBLastEventForUserBean event = DbAccess.eventsHistoryAccess.getLastEventForUser(user.getUserId());
					if (event == null) {
						event = new DBLastEventForUserBean();
					}
					ret.put("data", new GeneralDataMapper().mapToRow(event));
				} else {
					//System.out.println("|" + resultStr + "|");
					logger.debug(resultStr);
					parser.setUserId(user.getUserId());
					parser.process(resultStr);
				}
				
				ContentObject.getInstance().setData(tag, ret.get());
				
				
				redirect.setRedirect(new DropRedirect());
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} 
		
	}
}
