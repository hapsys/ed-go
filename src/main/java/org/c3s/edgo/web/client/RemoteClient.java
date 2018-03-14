package org.c3s.edgo.web.client;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.SQLException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
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
import org.c3s.edgo.utils.SimpleJsonParser;
import org.c3s.edgo.utils.crypto.DESAlgorithm;
import org.c3s.edgo.utils.crypto.RSAAlgorithm;
import org.c3s.edgo.web.GeneralController;
import org.c3s.edgo.web.validator.Result;
import org.c3s.web.redirect.DropRedirect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class RemoteClient extends GeneralController {
	
	private static Logger logger = LoggerFactory.getLogger(RemoteClient.class);
	
	private SimpleJsonParser parser = new SimpleJsonParser();
	

	public void getRequest(@ParameterRequest("userID") String userId, @ParameterRequest("data") String data,  @ParameterRequest("secretKey") String securityKey, @Parameter("tag") String tag, RedirectControlerInterface redirect) 
			throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
		
		DBUsersBean user =  DbAccess.usersAccess.getByUuid(userId);
		if (user != null) {
			try {
				
				Result ret = new Result().put("result", "OK");
				
				if (securityKey != null) {
				
					KeyFactory keyFactory = KeyFactory.getInstance("RSA");
					PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(user.getUserKey().getPrivateKey()));
					PrivateKey privateKey = (PrivateKey) keyFactory.generatePrivate(privSpec);
					
					RSAAlgorithm rsa = new RSAAlgorithm(privateKey);
					//System.out.println(securityKey);
					String resultStr = rsa.decode(securityKey);
					
					//Result ret = new Result().put("result", "OK");
					if ("HELLO".equals(resultStr)) {
						// Do nothing
					} else if ("RESUME".equals(resultStr)) {
						
						DBLastEventForUserBean event = DbAccess.eventsHistoryAccess.getLastEventForUser(user.getUserId());
						if (event == null) {
							event = new DBLastEventForUserBean();
						}
						ret.put("data", new GeneralDataMapper().mapToRow(event));
						//List events
						ret.put("events", DbAccess.eventsListAccess.getFullEventsList().getList());
						// Genetrate session key
						String sessionKey = DESAlgorithm.generateKey();
						ret.put("secretKey", rsa.encode(sessionKey));
						DbAccess.userKeysAccess.updateSessionKey(sessionKey, user.getUserKey().getUserKeyId());
						
					} else {
						throw new Exception("Error security key");
					}
					
				} else {
					
					//System.out.println(data);
					DESAlgorithm des = new DESAlgorithm(user.getUserKey().getSessionKey());
					String resultStr = des.decode(data); 
					//System.out.println(resultStr);
					
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
