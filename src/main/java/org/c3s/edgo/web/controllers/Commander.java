package org.c3s.edgo.web.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.c3s.annotations.ActionUrl;
import org.c3s.annotations.Controller;
import org.c3s.annotations.Parameter;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.PatternerInterface;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.dispatcher.UrlPart;
import org.c3s.dispatcher.exceptions.SkipSubLevelsExeption;
import org.c3s.dispatcher.exceptions.StopDispatchException;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.edgo.utils.DomSerializer;
import org.c3s.edgo.web.GeneralController;
import org.c3s.reflection.XMLReflectionObj;
import org.c3s.web.redirect.DirectRedirect;
import org.c3s.web.redirect.DropRedirect;
import org.c3s.web.redirect.RelativeRedirect;
import org.c3s.xml.utils.XMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Controller
public class Commander extends GeneralController {
	
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Commander.class);
	
	private DBPilotsBean current = null;
	
	public void getInformation(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
	
		if (current != null) {
			
			Document xml = new XMLReflectionObj(current, true).toXML();	
			
			logger.debug(XMLUtils.xml2out(xml));
			//XMLUtils.save(xml, "/out.xml");
			logger.debug("template {}", template);
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:info"});
		}
	
		if (current == null) {
			//redirect.setRedirect(new DirectRedirect("/"));
			//throw new SkipSubLevelsExeption();
		}
		
	}
	
	public void getShips(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
	
		if (current != null) {
			/**
			Map<Object, Object> tree = new HashMap<Object, Object>() {{
				put(Pilot.class, new HashMap<Object, Object>() {{
					put(PilotShip.class, new HashMap<Object, Object>() {{
						put(StarSystem.class, new HashMap<Object, Object>() {{
							
						}});
						put(Ship.class, new HashMap<Object, Object>() {{
							
						}});
					}});
				}});
			}};
			
			Document xml = XMLUtils.createXML("data");
			new DomSerializer(current).__toXML(xml.getDocumentElement(), tree);
			//logger.debug(XMLUtils.xml2out(xml));
			//XMLUtils.save(xml, "/out.xml");
			logger.debug("template {}", template);
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:ships"});
			*/
		}
	
		if (current == null) {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}

	
	public void getShip(@Parameter("tag") String tag, @Parameter("template") String template, UrlPart url, RedirectControlerInterface redirect, PatternerInterface patterner) throws Exception {
	
		if (current != null) {
			/*
			PilotShip ship = current.getPilotShip(Integer.valueOf(url.getPattern().substring(0, url.getPattern().length() - 1)));  
			
			if (ship != null) {
				Document xml = XMLUtils.createXML("data");
				new DomSerializer(ship).__toXML(xml.getDocumentElement(), tree);
				//logger.debug(XMLUtils.xml2out(xml));
				//XMLUtils.save(xml, "/out1.xml");
				//logger.debug("template {}", template);
				ContentObject.getInstance().addPath("/", ship.getShip().getName());
				
				ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:view_ship"});
				redirect.setRedirect(new DropRedirect());
			} else {
				redirect.setRedirect(new RelativeRedirect("../", patterner));
				throw new StopDispatchException();
			}
			*/
		}
	
		if (current == null) {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}
	
	//@SuppressWarnings("serial")
	public void checkCommander(UrlPart url, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		String actionUrl = url.getPattern().substring(0, url.getPattern().length() - 1).toLowerCase();
		DBUsersBean user = getUser();
		DBPilotsBean pilot = null;

		if (user != null) {
			pilot = DbAccess.pilotsAccess.getByName(actionUrl);
			//logger.debug("user {}", user.getUserId());
			//logger.debug("pilot user {}", pilot.getUserId());
			if (pilot != null && (long)pilot.getUserId() == (long)user.getUserId()) {
				//logger.debug("Current {}", actionUrl);
				current = pilot;
				ContentObject.getInstance().setFixedParameters("pilot", pilot.getPilotName());
			}
		}
		//logger.debug("Current {}", url.getClass().getName());
		//logger.debug("Current {}", actionUrl);
		//redirect.setRedirect(new DropRedirect());
	}
	
}
