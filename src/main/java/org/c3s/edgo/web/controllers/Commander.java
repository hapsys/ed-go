package org.c3s.edgo.web.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
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
import org.c3s.edgo.common.beans.DBMissionsComplitedListByPilotsBean;
import org.c3s.edgo.common.beans.DBPilotShipsBean;
import org.c3s.edgo.common.beans.DBPilotShipsListBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBPilotsPowerWeeksBean;
import org.c3s.edgo.common.beans.DBPowerCortageBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.edgo.common.intruders.InInjector;
import org.c3s.edgo.web.GeneralController;
import org.c3s.reflection.XMLReflectionObj;
import org.c3s.web.redirect.DirectRedirect;
import org.c3s.web.redirect.DropRedirect;
import org.c3s.web.redirect.RelativeRedirect;
import org.c3s.xml.utils.XMLUtils;
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
		} else {
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
		} else {
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
		} else {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}

	public void getPowers(@Parameter("tag") String tag, @Parameter("template") String template, UrlPart url, RedirectControlerInterface redirect) throws Exception {
		
		if (current != null) {
			
			DBPowerCortageBean cortage = new DBPowerCortageBean();
			current.setPowers(cortage);
			
			
			List<Object> in = new ArrayList<>();
			in.add(current.getPilotId());
			InInjector injector = new InInjector("pilot_id", in);
			List<DBPilotsPowerWeeksBean> weeks = DbAccess.pilotPowerAccess.getPilotsPowerWeeks(injector);
			cortage.setWeeks(weeks);
			
			cortage.setMeritsKill(DbAccess.pilotKillMeritsAccess.getListForPilots(injector));
			cortage.setMeritsDeliver(DbAccess.pilotDeliverAccess.getListForPilots(injector));
			cortage.setMeritsWar(DbAccess.pilotWarMeritsAccess.getListForPilots(injector));
			cortage.setCreditsSpend(DbAccess.pilotPowerSpendAccess.getListForPilots(injector));
			
			Document xml = new XMLReflectionObj(current).toXML();
			logger.debug(XMLUtils.xml2out(xml));
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:view_power"});
			redirect.setRedirect(new DropRedirect());
		} else {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}
	
	public void getMissions(@Parameter("tag") String tag, @Parameter("template") String template, UrlPart url, RedirectControlerInterface redirect, PatternerInterface patterner) throws Exception {
		
		if (current != null) {

			List<Object> in = new ArrayList<>();
			in.add(current.getPilotId());
			InInjector injector = new InInjector("m.pilot_id", in);
			
			List<Object> mat_in = new ArrayList<>();
			List<Object> com_in = new ArrayList<>();
			List<DBMissionsComplitedListByPilotsBean> missions = DbAccess.missionsAccess.getMissionsComplitedListByPilots(injector);
			if (missions != null) {
				for (DBMissionsComplitedListByPilotsBean mission: missions) {
					if (mission.getCommodityIdx() != null) {
						String[] cidxs = mission.getCommodityIdx().split(",");
						mission.setCommodityId(new Integer[cidxs.length]);
						int i = 0;
						for (String cid: cidxs) {
							Integer val = new Integer(cid);
							mission.getCommodityId()[i] = val;
							com_in.add(val);
							i++;
						}
					}
					if (mission.getMaterialIdx() != null) {
						String[] cidxs = mission.getMaterialIdx().split(",");
						mission.setMaterialId(new Integer[cidxs.length]);
						int i = 0;
						for (String cid: cidxs) {
							Integer val = new Integer(cid);
							mission.getMaterialId()[i] = val;
							mat_in.add(val);
							i++;
						}
					}
				}
				current.setChilds(missions);
			}
			if (com_in.size() > 0) {
				InInjector injectorCom = new InInjector("commodity_id", com_in);
				current.setAdditionOne(DbAccess.commoditiesAccess.getCommoditiesList(injectorCom));
			}
			if (mat_in.size() > 0) {
				InInjector injectorCom = new InInjector("material_id", mat_in);
				current.setAdditionTwo(DbAccess.materialsAccess.getMaterialsList(injectorCom));
			}
			Document xml = new XMLReflectionObj(current).toXML();
			logger.debug(XMLUtils.xml2out(xml));
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:view_missions"});
		} else {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
	}
	
	public void checkCommander(UrlPart url, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException, UnsupportedEncodingException {
		
		String actionUrl = url.getPattern().substring(0, url.getPattern().length() - 1).toLowerCase();
		
		//String actionUrl = URLDecoder.decode(url.getPattern().substring(0, url.getPattern().length() - 1), "utf-8");
		//logger.debug("1 dencoding: {}", url.getPattern().substring(0, url.getPattern().length() - 1).toLowerCase());
		//logger.debug("2 dencoding: {}", URLDecoder.decode(url.getPattern().substring(0, url.getPattern().length() - 1), "utf-8"));
		DBUsersBean user = getUser();
		DBPilotsBean pilot = null;

		if (user != null) {
			pilot = DbAccess.pilotsAccess.getByName(actionUrl);
			if (pilot != null && pilot.getUserId().equals(user.getUserId())) {
				current = pilot;
				ContentObject.getInstance().setFixedParameters("pilot", pilot.getPilotName());
			}
		}
	}
	
}
