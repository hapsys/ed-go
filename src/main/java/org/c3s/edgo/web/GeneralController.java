/**
 * 
 */
package org.c3s.edgo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.c3s.db.jpa.ManagerJPA;
import org.c3s.edgo.common.entity.User;
import org.c3s.edgo.web.auth.AuthRoles;
import org.c3s.edgo.web.language.I10nHolder;
import org.c3s.edgo.web.validator.Result;
import org.c3s.site.SiteLoader;
import org.c3s.storage.StorageFactory;
import org.c3s.storage.StorageInterface;
import org.c3s.storage.StorageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author admin
 *
 */
public class GeneralController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(GeneralController.class);
	
	public static final String STORED_USER = "____user";
	
	private String language_id = "";

	
	//protected User user = null; 
	protected List<AuthRoles> roles = new ArrayList<AuthRoles>();
	
	
	/**
	 * 
	 */
	public GeneralController() {
		language_id = SiteLoader.getSite().getCurrentLanguage().getName();
	}

	protected String getLanguageId() {
		return language_id;
	}
	
	protected String i10n(String source) {
		return I10nHolder.getInstance().get(source, getLanguageId());
	}
	
	protected Map<String, Object> wrapError(Map<?,?> errors) {
		return wrapError(errors, "Not found", 404);	
	}
	
	protected Map<String, Object> wrapError(Map<?,?> errors, String status_text, int status) {
		Result result = new Result();
		result.put("status", status);
		result.put("status_text",  status_text);
		result.put("error",  errors != null? errors:"error");
		return result.get();
	}
	
	public static synchronized User getUser() {
		synchronized (GeneralController.class) {
			StorageInterface storage = StorageFactory.getStorage(StorageType.SESSION);
			return (User)storage.get(STORED_USER); 
		}
	}
	
	public static EntityManager getEntityManager() {
		return ManagerJPA.get("edgo");
	}
}
