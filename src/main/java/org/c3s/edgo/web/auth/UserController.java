/**
 * 
 */
package org.c3s.edgo.web.auth;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.c3s.annotations.Controller;
import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.db.jpa.ManagerJPA;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBUserKeysBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.edgo.web.GeneralController;
import org.c3s.edgo.web.validator.Required;
import org.c3s.edgo.web.validator.Result;
import org.c3s.edgo.web.validator.ValueChecker;
import org.c3s.reflection.XMLReflectionObj;
import org.c3s.storage.StorageFactory;
import org.c3s.storage.StorageInterface;
import org.c3s.storage.StorageType;
import org.c3s.utils.Utils;
import org.c3s.web.redirect.DirectRedirect;
import org.c3s.web.redirect.DropRedirect;
import org.c3s.xml.utils.XMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

/**
 * @author admin
 *
 */
@Controller
public class UserController extends GeneralController {

	//@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(UserController.class); 
	
	/**
	 * @param email
	 * @param password
	 * @param tag
	 * @param redirect
	 * @throws SQLException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public void login(@ParameterRequest("email") String email, @ParameterRequest("password") String password, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {

		StorageInterface storage = StorageFactory.getStorage(StorageType.SESSION);
		//User user = null;
		Result result = null;
		Map<?,?> errors = null;
		
		if (storage.containsKey(STORED_USER)) {
			errors = ValueChecker.addError("__common", i10n("already logged"), null);
		} else {
		
			ValueChecker chk = new ValueChecker();
			
			chk.validate("email", email, new Required(i10n("Field must have value")));
	
			chk.validate("password", password, new Required(i10n("Field must have value")));
			
			errors = chk.getErrors();
			
			if (!chk.hasErrors()) {
				try {
					logger.debug("User/password: {}/{}", email, password);
					//final User user = manager.createNamedQuery("User.findByEmailAndPassword", User.class).setParameter("email", email).setParameter("password", Utils.MD5(password)).getSingleResult();
					DBUsersBean user = DbAccess.usersAccess.getByEmailAndPassword(email, Utils.MD5(password)); 
					(result = new Result()).get().put("user_id", user.getUserUuid());
					//logger.debug("Users roles is: {}", user.getRoles());
					storage.put(STORED_USER, user);
					user.setPrevLoginTime(user.getLastLoginTime());
					user.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
					//manager.merge(user);
					DbAccess.usersAccess.updateByPrimaryKey(user, user.getUserId());
				} catch (NoResultException e) {
					errors = ValueChecker.addError("__common", i10n("no login"), null);
				}
			}
		}
		
		Map<?, ?> data = (errors != null)?wrapError(errors):result.get();
		ContentObject.getInstance().setData(tag, data);
		redirect.setRedirect(new DropRedirect());
		
	}
	
	public void logout(@Parameter("tag") String tag, RedirectControlerInterface redirect) {
		StorageFactory.getStorage(StorageType.SESSION).remove(STORED_USER);
		ContentObject.getInstance().setData(tag, new Result().get());
		redirect.setRedirect(new DropRedirect());
	}
	
	
	public void getProfile(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
		DBUsersBean user;
		if ((user = getUser()) != null) {
			Document xml = new XMLReflectionObj(user, true).toXML();
			logger.debug(XMLUtils.xml2out(xml));
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:view"});
		} else {
			redirect.setRedirect(new DirectRedirect("/"));
		}
	}
	
	public void generateNewKeys(@Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, SQLException {
		DBUsersBean user = getUser();
		if (user != null) {
			String privateK = null;
			try {
				KeyPairGenerator keyGen = KeyPairGenerator.getInstance( "RSA" );
		        keyGen.initialize(2048);
		        KeyPair kp = keyGen.genKeyPair();
		        PublicKey publicKey = kp.getPublic();
		        PrivateKey privateKey = kp.getPrivate();
		        String publicK = Base64.getEncoder().encodeToString(publicKey.getEncoded());
		        privateK = Base64.getEncoder().encodeToString(privateKey.getEncoded());
		        
		        DBUserKeysBean key = user.getUserKey();
		        if (key == null || key.getUserKeyId() == 0) {
		        	key = new DBUserKeysBean();
			        //manager.persist(key);
			        //manager.getTransaction().commit();
			        //manager.getTransaction().begin();
		        	//user.setUserKey(key);
		        	DbAccess.userKeysAccess.insert(key);
		        } else {
		        	key.setUpdateTime(new Timestamp(new Date().getTime()));
		        }
		        key.setPublicKey(publicK);
		        key.setPrivateKey(privateK);
		        DbAccess.userKeysAccess.updateByPrimaryKey(key, key.getUserKeyId());
		        
		        user.setUserKey(key);
		        user.setUserKeyId(key.getUserKeyId());
		        DbAccess.usersAccess.updateByPrimaryKey(user, user.getUserId());
		        
			} catch (NoSuchAlgorithmException e) {
				logger.error("{}", e.getMessage(), e);
			}
			
			if (privateK == null) {
				Map<String, List<String>> errors = ValueChecker.addError("accessKey", i10n("Generate key error"), null);
				ContentObject.getInstance().setData(tag, wrapError(errors));
			} else {
				ContentObject.getInstance().setData(tag, new Result().put("accessKey", privateK).get());
			}
			
			redirect.setRedirect(new DropRedirect());
		}
	}
}
