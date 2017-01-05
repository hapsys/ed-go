package org.c3s.edgo.web.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.c3s.annotations.Controller;
import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.db.injectors.EmptySqlInjector;
import org.c3s.dispatcher.PatternerInterface;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.dispatcher.UrlPart;
import org.c3s.dispatcher.exceptions.SkipSubLevelsExeption;
import org.c3s.dispatcher.exceptions.StopDispatchException;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBActivityBean;
import org.c3s.edgo.common.beans.DBEventMaxMinDateForPilotBean;
import org.c3s.edgo.common.beans.DBMaxMinDateSystemHistoryForPilotBean;
import org.c3s.edgo.common.beans.DBMissionsComplitedListByPilotsBean;
import org.c3s.edgo.common.beans.DBPilotShipsBean;
import org.c3s.edgo.common.beans.DBPilotShipsListBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBPilotsPowerWeeksBean;
import org.c3s.edgo.common.beans.DBPowerCortageBean;
import org.c3s.edgo.common.beans.DBSystemPathBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.edgo.common.intruders.EventHistoryInjector;
import org.c3s.edgo.common.intruders.InInjector;
import org.c3s.edgo.common.intruders.SystemPathInjector;
import org.c3s.edgo.web.GeneralController;
import org.c3s.edgo.web.auth.AuthRoles;
import org.c3s.edgo.web.validator.Result;
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
	
	// ============================================================== +INFORMATION ==============================================================================
	
	public void getInformation(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
	
		if (current != null) {
			
			current.setRank(DbAccess.ranksAccess.getByPrimaryKey(current.getPilotId()));
			current.setProgress(DbAccess.progressAccess.getByPrimaryKey(current.getPilotId()));
			current.setLocation(DbAccess.locationHistoryAccess.getLastLocationForPilot(current.getPilotId()));
			
			Document xml = new XMLReflectionObj(current, true).toXML();	
			
			DBEventMaxMinDateForPilotBean minmax = DbAccess.eventsHistoryAccess.getEventMaxMinDateForPilot(current.getPilotId());
			
			if (minmax.getMinDate().length() > 0) {
				xml.getDocumentElement().setAttribute("mindate", minmax.getMinDate());
				xml.getDocumentElement().setAttribute("maxdate", minmax.getMaxDate());
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat monthFormat = new SimpleDateFormat("LLLL yyyy", Locale.US);
				String monthYear = monthFormat.format(dateFormat.parse(minmax.getMaxDate()));
				xml.getDocumentElement().setAttribute("currentdate", monthYear);
			}
			
			//logger.debug(XMLUtils.xml2out(xml));
			//logger.debug("template {}", template);
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:info"});
		} else {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}
	
	public void getActivity(@ParameterRequest("showdate") String showdate, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		if (current != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
			Date date;
			try {
				date = dateFormat.parse(showdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				date = new Date();
				//e.printStackTrace();
			}
			String dateStr = dateFormat.format(date);
			String from = dateStr + "-01 00:00:00";
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			String to = dateStr + "-" + calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + " 23:59:59";
			//System.out.println(from);
			//System.out.println(to);
			
			List<DBActivityBean> activity = DbAccess.eventsHistoryAccess.getActivity(current.getPilotId(), new EventHistoryInjector(from, to));
			//System.out.println(activity.size());
			ContentObject.getInstance().setData(tag, new Result().put("days", activity).get());
			redirect.setRedirect(new DropRedirect());
		}
	}
	
	// ============================================================== -INFORMATION ==============================================================================
	
	// ============================================================== +SHIPS AND MODULES ==============================================================================
	
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
	// ============================================================== -SHIPS AND MODULES ==============================================================================
	

	// ============================================================== +POWERS ==============================================================================
	
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
			//logger.debug(XMLUtils.saveXML(xml));
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:view_power"});
			redirect.setRedirect(new DropRedirect());
		} else {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}
	// ============================================================== -POWERS ==============================================================================
	
	// ============================================================== +MISSIONS ==============================================================================
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
	// ============================================================== -MISSIONS ==============================================================================
	
	// ============================================================== +SYSTEMS PATH ==============================================================================
	
	public void getSystemsPath(@Parameter("tag") String tag, @Parameter("template") String template, UrlPart url, RedirectControlerInterface redirect, PatternerInterface patterner) throws Exception {
		
		if (current != null) {
			Document xml = new XMLReflectionObj(current, true).toXML();
			
			DBMaxMinDateSystemHistoryForPilotBean minmax = DbAccess.locationSystemHistoryAccess.getMaxMinDateSystemHistoryForPilot(current.getPilotId());
			
			if (minmax.getMinDate().length() > 0) {
				xml.getDocumentElement().setAttribute("mindate", minmax.getMinDate());
				xml.getDocumentElement().setAttribute("maxdate", minmax.getMaxDate());
			}
			
			//logger.debug(XMLUtils.xml2out(xml));
			//logger.debug("template {}", template);
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:locations"});
			
		} else {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
	}
	
	public void getSystems(@ParameterRequest("startdate") String startdate, @ParameterRequest("enddate") String enddate, @ParameterRequest("page") Integer page, @ParameterRequest("per_page") Integer per_page, 
		@Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		if (current != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date sdate, edate;
			try {
				sdate = dateFormat.parse(startdate);
			} catch (Exception e) {
				sdate = null;
			}
			try {
				edate = dateFormat.parse(enddate);
			} catch (Exception e) {
				edate = null;
			}
			String from = sdate == null? null: dateFormat.format(sdate) + " 00:00:00";
			String to = edate == null? null: dateFormat.format(edate) + " 23:59:59";
			
			/*
			*/
			//System.out.println(activity.size());
			if (page == null || page < 1) {
				page = 1;
			}
			if (per_page == null || per_page < 50) {
				per_page = 50;
			}
			
			SystemPathInjector injector = new SystemPathInjector(page - 1, per_page, from, to);
			List<DBSystemPathBean> systems = DbAccess.locationSystemHistoryAccess.getSystemPath(current.getPilotId(), injector); 
			System.out.println(systems.size());
				
			DBMaxMinDateSystemHistoryForPilotBean minmax = DbAccess.locationSystemHistoryAccess.getMaxMinDateSystemHistoryForPilot(current.getPilotId());
			
			Result result = new Result().put("systems", systems).put("total", DbAccess.locationSystemHistoryAccess.getSystemPathCount(current.getPilotId(), injector));
			if (minmax.getMinDate().length() > 0) {
				result.put("mindate", minmax.getMinDate());
				result.put("maxdate", minmax.getMaxDate());
			}
			
			ContentObject.getInstance().setData(tag, result.get());
			redirect.setRedirect(new DropRedirect());
		}
	}
	
	public void getSystemsTest(@ParameterRequest("startdate") String startdate, @ParameterRequest("enddate") String enddate, @ParameterRequest("page") Integer page, @ParameterRequest("per_page") Integer per_page, 
		@Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		current = DbAccess.pilotsAccess.getByPrimaryKey(1L);
		getSystems(startdate, enddate, page, per_page, tag, redirect);
	}
	// ============================================================== -SYSTEMS PATH ==============================================================================
	public void checkCommander(UrlPart url, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException, UnsupportedEncodingException {
		
		//String actionUrl = url.getPattern().substring(0, url.getPattern().length() - 1).toLowerCase();
		String actionUrl = URLDecoder.decode(url.getPattern().substring(0, url.getPattern().length() - 1), "utf-8");
		
		//String actionUrl = URLDecoder.decode(url.getPattern().substring(0, url.getPattern().length() - 1), "utf-8");
		//logger.debug("1 dencoding: {}", url.getPattern().substring(0, url.getPattern().length() - 1).toLowerCase());
		//logger.debug("2 dencoding: {}", URLDecoder.decode(url.getPattern().substring(0, url.getPattern().length() - 1), "utf-8"));
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println(dateFormat.format(new Date()));
		DBUsersBean user = getUser();
		DBPilotsBean pilot = null;

		if (user != null) {
			pilot = DbAccess.pilotsAccess.getByName(actionUrl);
			if (pilot != null && (pilot.getUserId().equals(user.getUserId()) || hasRole(AuthRoles.ROLE_ADMINISTRATOR))) {
				current = pilot;
				ContentObject.getInstance().setFixedParameters("pilot", pilot.getPilotName());
			}
		}
	}
	
}
