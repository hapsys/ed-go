package org.c3s.edgo.web.controllers;

import java.sql.SQLException;
import java.util.List;

import org.c3s.annotations.Controller;
import org.c3s.annotations.Parameter;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.PatternerInterface;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.dispatcher.UrlPart;
import org.c3s.dispatcher.exceptions.SkipSubLevelsExeption;
import org.c3s.dispatcher.exceptions.StopDispatchException;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotShipsBean;
import org.c3s.edgo.common.beans.DBPilotShipsListBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.edgo.web.GeneralController;
import org.c3s.reflection.XMLReflectionObj;
import org.c3s.web.redirect.DirectRedirect;
import org.c3s.web.redirect.DropRedirect;
import org.c3s.web.redirect.RelativeRedirect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

@Controller
public class Commander extends GeneralController {
	
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Commander.class);
	
	private DBPilotsBean current = null;
	
	public void getInformation(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
	
		if (current != null) {
			
			current.setRank(DbAccess.ranksAccess.getByPrimaryKey(current.getPilotId()));
			current.setProgress(DbAccess.progressAccess.getByPrimaryKey(current.getPilotId()));
			current.setLocation(DbAccess.locationHistoryAccess.getLastLocationForPilot(current.getPilotId()));
			
			Document xml = new XMLReflectionObj(current, true).toXML();	
			
			//logger.debug(XMLUtils.xml2out(xml));
			//logger.debug("template {}", template);
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:info"});
		}
	
		if (current == null) {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}
	
	public void getShips(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
	
		if (current != null) {
			current.setLocation(DbAccess.locationHistoryAccess.getLastLocationForPilot(current.getPilotId()));
			List<DBPilotShipsListBean> pilotShips = DbAccess.pilotShipsAccess.getPilotShipsList(current.getPilotId());
			if (pilotShips != null) {
				current.setChilds(pilotShips);
			}
			Document xml = new XMLReflectionObj(current).toXML();
			//logger.debug(XMLUtils.xml2out(xml));
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:ships"});
		}
	
		if (current == null) {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}

	
	public void getShip(@Parameter("tag") String tag, @Parameter("template") String template, UrlPart url, RedirectControlerInterface redirect, PatternerInterface patterner) throws Exception {
	
		if (current != null) {
			DBPilotShipsBean ship = DbAccess.pilotShipsAccess.getByPilotIdAndLinkShipId(current.getPilotId(), Long.valueOf(url.getPattern().substring(0, url.getPattern().length() - 1)));
			//PilotShip ship = current.getPilotShip(Integer.valueOf(url.getPattern().substring(0, url.getPattern().length() - 1)));  
			current.setCurrentShip(ship);
			if (ship != null) {
				ship.setShip(DbAccess.shipsAccess.getByPrimaryKey(ship.getShipId()));
				ship.setModules(DbAccess.pilotModulesAccess.getPilotShipModulesList(ship.getPilotShipId()));
				Document xml = new XMLReflectionObj(current).toXML();
				//logger.debug(XMLUtils.xml2out(xml));
				ContentObject.getInstance().addPath("/", ship.getShip().getShipName());
				ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:view_ship"});
				redirect.setRedirect(new DropRedirect());
			} else {
				redirect.setRedirect(new RelativeRedirect("../", patterner));
				throw new StopDispatchException();
			}
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
