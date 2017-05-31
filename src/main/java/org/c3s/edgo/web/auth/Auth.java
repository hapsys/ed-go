package org.c3s.edgo.web.auth;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.c3s.annotations.Controller;
import org.c3s.annotations.Parameter;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.PatternerInterface;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.dispatcher.exceptions.SkipSubLevelsExeption;
import org.c3s.dispatcher.exceptions.StopDispatchException;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBRolesBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.edgo.web.GeneralController;
import org.c3s.utils.HTTPUtils;
import org.c3s.web.redirect.RelativeRedirect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class Auth extends GeneralController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Auth.class);
	
	public void getRoles(HttpServletRequest request, HttpServletResponse responce) {
		
		DBUsersBean user = GeneralController.getUser();
		
		if (user == null) {
			// try cookie
			Cookie[] cookies = request.getCookies();
				if (cookies != null) {
				Cookie cookie = null; 
				for (Cookie c: cookies) {
					if (cookieName.equals(c.getName())) {
						cookie = c;
						break;
					}
				}
				if (cookie != null) {
					try {
						user = DbAccess.usersAccess.getByCookie(cookie.getValue());
						if (user != null) {
							cookie.setMaxAge(cookieAge);
							cookie.setPath("/");
							responce.addCookie(cookie);
							setUser(user);
						}
					} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
						// Shit
					}
				}
			}
		}
		 
		if (user != null) {
			try {
				// Append user email
				ContentObject.getInstance().setFixedParameters("user", user.getEmail());
				//System.out.println(user);
				//System.out.println(user.getIsVerify());
				if (user.getIsVerify() == 0) {
					roles.add(AuthRoles.ROLE_REGISTERED);
				} else {
					roles.add(AuthRoles.ROLE_LOGGED);
					List<DBRolesBean> userRoles = user.getUserRoles();
					if (userRoles != null) {
					AuthRoles role = null;
						for (DBRolesBean userRole : userRoles) {
							try {
								if ((role = AuthRoles.valueOf(userRole.getRole())) != null) {
									roles.add(role);
								}
							} catch (IllegalArgumentException e) {}
						}
					}
				}
			} catch (NullPointerException e) {
				user = null;
				GeneralController.setUser(null);
				logger.error(e.getMessage(), e);
				
			}
		} 
		
		if (user == null) {
			roles.add(AuthRoles.ROLE_NOT_LOGGED);
			ContentObject.getInstance().setFixedParameters("user", "");
		}
		setUserRoles(roles);
		
		StringBuffer sb = new StringBuffer();
		for (AuthRoles role : roles) {
			sb.append('|');
			sb.append(role.name());
		}
		sb.append('|');
		
		//System.out.println(sb.toString());
		
		ContentObject.getInstance().setFixedParameters("roles", sb.toString());
	}
	
	
	private boolean inArray(String[] source, String value, boolean defaultVal) {
		
		boolean result = defaultVal;
		
		boolean inarr =  false;
		if (source != null && source.length > 0) {
			for (String r : source) {
				if (value.equals(r)) {
					inarr = true;
					break;
				}
			}
		}
		
		result = inarr?true:result;
		
		return result;
		
	}
	
	public void checkRoles(@Parameter("allow") String[] allow, @Parameter("deny") String[] deny, @Parameter("order") String order, 
			ServletRequest request, RedirectControlerInterface redirect, PatternerInterface patterner) throws StopDispatchException, SkipSubLevelsExeption {
		
		boolean allowDeny = !"deny,allow".equals(order); 
		
		boolean passAllow = false;
		boolean passDeny = false;		
		for(AuthRoles role: roles) {
			if (inArray(allow, role.name(), false)) {
				passAllow = true;
				break;
			}
		}
		for(AuthRoles role: roles) {
			if (inArray(deny, role.name(), false)) {
				passDeny = true;
			}
		}
		
		boolean success = allowDeny?(passDeny?false:true):(passAllow?true:false);
		
		if (!success) {
			if (!HTTPUtils.isAjax(request)) {
				redirect.setRedirect(new RelativeRedirect("../", patterner));
			}
			throw new SkipSubLevelsExeption();
		}
	}
}
