package org.c3s.edgo.web.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletRequest;

import org.c3s.annotations.Controller;
import org.c3s.annotations.CurrentUrl;
import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.PatternerInterface;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.dispatcher.UrlPart;
import org.c3s.dispatcher.exceptions.SkipSubLevelsExeption;
import org.c3s.dispatcher.exceptions.StopDispatchException;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBActivityBean;
import org.c3s.edgo.common.beans.DBEngTypeBean;
import org.c3s.edgo.common.beans.DBEventMaxMinDateForPilotBean;
import org.c3s.edgo.common.beans.DBFullLastInfoBean;
import org.c3s.edgo.common.beans.DBGradesByTypeUniqBean;
import org.c3s.edgo.common.beans.DBLocationsPathBean;
import org.c3s.edgo.common.beans.DBMaterialUnsingInfoBean;
import org.c3s.edgo.common.beans.DBMaterialsBean;
import org.c3s.edgo.common.beans.DBMaterialsByBlueprintAndGradeBean;
import org.c3s.edgo.common.beans.DBMaterialsByTypeUniqBean;
import org.c3s.edgo.common.beans.DBMaxMinDateLocationHistoryForPilotBean;
import org.c3s.edgo.common.beans.DBMissionsComplitedListByPilotsBean;
import org.c3s.edgo.common.beans.DBPilotInfoLinkWithDefaultsBean;
import org.c3s.edgo.common.beans.DBPilotInfoWithDefaultsBean;
import org.c3s.edgo.common.beans.DBPilotMaterialsBean;
import org.c3s.edgo.common.beans.DBPilotMaterialsListBean;
import org.c3s.edgo.common.beans.DBPilotShipsBean;
import org.c3s.edgo.common.beans.DBPilotShipsListBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBPilotsImagesBean;
import org.c3s.edgo.common.beans.DBPilotsInfoBean;
import org.c3s.edgo.common.beans.DBPilotsPowerWeeksBean;
import org.c3s.edgo.common.beans.DBPilotsRelationsBean;
import org.c3s.edgo.common.beans.DBPowerCortageBean;
import org.c3s.edgo.common.beans.DBTumbnailsForImageBean;
import org.c3s.edgo.common.beans.DBUserLevelsBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.edgo.common.intruders.ActivityInjector;
import org.c3s.edgo.common.intruders.InInjector;
import org.c3s.edgo.common.intruders.SystemPathInjector;
import org.c3s.edgo.relations.Relation;
import org.c3s.edgo.utils.I10N;
import org.c3s.edgo.web.GeneralController;
import org.c3s.edgo.web.auth.AuthRoles;
import org.c3s.edgo.web.validator.Result;
import org.c3s.edgo.web.validator.ValueChecker;
import org.c3s.query.ParametersHolder;
import org.c3s.query.RequestType;
import org.c3s.reflection.XMLList;
import org.c3s.reflection.XMLReflectionObj;
import org.c3s.storage.StorageFactory;
import org.c3s.storage.StorageType;
import org.c3s.utils.HTTPUtils;
import org.c3s.utils.RegexpUtils;
import org.c3s.utils.Utils;
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
	private List<Long> linkedPilots = null;
	
	// ============================================================== +INFORMATION ==============================================================================
	
	private String getDiff(Long time) {
		
		StringBuilder sb = new StringBuilder();
		
		long sec = time % 60;
		long min = (time - sec)/60 % 60;
		long hour = (time - min*60 - sec)/3600 % 24;
		long day = Double.valueOf(Math.floor(Double.valueOf(time)/(3600*24))).longValue();
		long mon = 0;
		long year = 0;
		
		
		String lang = (String)ContentObject.getInstance().getFixedParameter("language_id");
		if ("ru".equals(lang)) {
			if (year > 0) {
				sb.append(year);
				sb.append(" г ");
			}
			if (mon > 0) {
				sb.append(mon);
				sb.append(" мес ");
			}
			if (day > 0) {
				sb.append(day);
				sb.append(" дн ");
			}
			if (hour > 0) {
				sb.append(hour);
				sb.append(" час ");
			}
			if (min > 0) {
				sb.append(min);
				sb.append(" мин ");
			}
			if (sec > 0) {
				sb.append(sec);
				sb.append(" сек ");
			}
		} else {
			if (year > 0) {
				sb.append(year);
				sb.append(" y ");
			}
			if (mon > 0) {
				sb.append(mon);
				sb.append(" mon ");
			}
			if (day > 0) {
				sb.append(day);
				sb.append(" d ");
			}
			if (hour > 0) {
				sb.append(hour);
				sb.append(" h ");
			}
			if (min > 0) {
				sb.append(min);
				sb.append(" min ");
			}
			if (sec > 0) {
				sb.append(sec);
				sb.append(" sec ");
			}
		}
		
		return sb.toString();
		
	}
	
	private String getFlyMode(int flyMode) {
		String result = "";
		switch (flyMode) {
		case 0:
			result = "Normal Space";
			break;
		case 1:
			result = "Supercruise";
			break;
		case 2:
			result = "Landing";
			break;
		case 3:
			result = "Docked";
			break;
		}
		
		return result;
	}
	
	public void getInformation(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
	
		if (current != null) {
			
			/*
			current.setRank(DbAccess.ranksAccess.getByPrimaryKey(current.getPilotId()));
			current.setProgress(DbAccess.progressAccess.getByPrimaryKey(current.getPilotId()));
			current.setLocation(DbAccess.locationHistoryAccess.getLastLocationForPilot(current.getPilotId()));
			current.setLastInfo(DbAccess.pilotLastInfoAccess.getLastPilotInfo(current.getPilotId()));
			current.setLastActivityTime(DbAccess.eventsHistoryAccess.getLastActivityTime(current.getPilotId()));
			*/
			DBFullLastInfoBean li = DbAccess.pilotLastInfoAccess.getFullLastInfo(current.getPilotId());
			li.setFlyMode(i10n(getFlyMode(li.getIsSupercruise())));
			li.setGameMode(i10n(li.getGameMode()));
			li.setLastSeen(this.getDiff(li.getLastEvent()));
			li.setQueredEvents(DbAccess.eventsAccess.getQueriedEvents(current.getUserId()).getQueredEvents());
			current.setLastInfo(li);
			
			Document xml = new XMLReflectionObj(current, true).toXML();	
			
			DBEventMaxMinDateForPilotBean minmax = DbAccess.eventsHistoryAccess.getEventMaxMinDateForPilot(new InInjector("p.pilot_id", linkedPilots));
			
			if (minmax != null && minmax.getMinDate() != null && minmax.getMinDate().length() > 0) {
				xml.getDocumentElement().setAttribute("mindate", minmax.getMinDate());
				xml.getDocumentElement().setAttribute("maxdate", minmax.getMaxDate());
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat monthFormat = new SimpleDateFormat("LLLL yyyy", Locale.US);
				String monthYear = monthFormat.format(dateFormat.parse(minmax.getMaxDate()));
				xml.getDocumentElement().setAttribute("currentdate", monthYear);
			}
			
			//logger.debug(XMLUtils.xml2out(xml));
			//logger.debug("template {}", template);
			//logger.debug(XMLUtils.saveXML(xml));
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:info"});
		} else {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}
	
	public void updateUserInfo(@Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		if (current != null) {
			
			DBFullLastInfoBean li = DbAccess.pilotLastInfoAccess.getFullLastInfo(current.getPilotId());
			li.setFlyMode(i10n(getFlyMode(li.getIsSupercruise())));
			li.setGameMode(i10n(li.getGameMode()));
			li.setLastSeen(this.getDiff(li.getLastEvent()));
			li.setQueredEvents(DbAccess.eventsAccess.getQueriedEvents(current.getUserId()).getQueredEvents());
			current.setLastInfo(li);
			
			ContentObject.getInstance().setData(tag, new Result().put("info", current).get());
			redirect.setRedirect(new DropRedirect());
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
			
			List<DBActivityBean> activity = DbAccess.pilotGameModesAccess.getActivity(new ActivityInjector(from, to, linkedPilots));
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
				Double x = current.getLocation().getX();
				Double y = current.getLocation().getY();
				Double z = current.getLocation().getZ();
				for (DBPilotShipsListBean ship: pilotShips) {
					Double distance = Math.sqrt(Math.pow(x - ship.getX(), 2) + Math.pow(y - ship.getY(), 2) + Math.pow(z - ship.getZ(), 2));
					ship.setDistance(distance);
				}
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
			
			
			//List<Object> in = new ArrayList<>();
			//in.add(current.getPilotId());
			InInjector injector = new InInjector("pilot_id", linkedPilots);
			System.out.println(injector.getWhereQuery());
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

			//List<Object> in = new ArrayList<>();
			//in.add(current.getPilotId());
			InInjector injector = new InInjector("m.pilot_id", linkedPilots);
			
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
			//logger.debug(XMLUtils.xml2out(xml));
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
			
			DBMaxMinDateLocationHistoryForPilotBean minmax = DbAccess.locationHistoryAccess.getMaxMinDateLocationHistoryForPilot(new InInjector("l.pilot_id", linkedPilots));
			
			if (minmax != null && minmax.getMinDate().length() > 0) {
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				Date sdate, edate;
				try {
					sdate = dateFormat.parse(minmax.getMinDate());
				} catch (Exception e) {
					sdate = null;
				}
				try {
					edate = dateFormat.parse(minmax.getMaxDate());
				} catch (Exception e) {
					edate = null;
				}
				if (sdate != null) {
					Date findate = new Date(edate.getTime() - 30L * 24L * 3600L * 1000L);
					if (findate.compareTo(sdate) < 0) {
						findate = sdate;
					}
					xml.getDocumentElement().setAttribute("start_date", dateFormat.format(findate));
					xml.getDocumentElement().setAttribute("end_date", dateFormat.format(edate));
				}
				
				xml.getDocumentElement().setAttribute("mindate", minmax.getMinDate());
				xml.getDocumentElement().setAttribute("maxdate", minmax.getMaxDate());
			}
			
			//logger.debug(XMLUtils.saveXML(xml));
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
			SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			boolean longFormat = false;
			Date sdate = null, edate = null;
			try {
				if (startdate != null && startdate.length() > 12) {
					longFormat =  true;
					sdate = new Date(dateTimeFormat.parse(startdate).getTime() + 1000L);
				} else {
					sdate = dateFormat.parse(startdate);
				}
			} catch (Exception e) {
				sdate = null;
			}
			try {
				edate = dateFormat.parse(enddate);
			} catch (Exception e) {
				edate = null;
			}
			
			String from = sdate == null? null: (longFormat? dateTimeFormat.format(sdate) : dateFormat.format(sdate) + " 00:00:00");
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
			
			SystemPathInjector injector = new SystemPathInjector(page - 1, per_page, from, to, linkedPilots);
			List<DBLocationsPathBean> systems = DbAccess.locationHistoryAccess.getLocationsPath(current.getPilotId(), injector); 
			//System.out.println(systems.size());
				
			DBMaxMinDateLocationHistoryForPilotBean minmax = DbAccess.locationHistoryAccess.getMaxMinDateLocationHistoryForPilot(new InInjector("l.pilot_id", linkedPilots));
			
			Result result = new Result().put("systems", systems).put("total", DbAccess.locationHistoryAccess.getLocationsPathCount(current.getPilotId(), injector));
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

	
	// ============================================================== +MATERIALS ==============================================================================
	private static String sortedParameterName = "__storedSortedParameter";
	
	public void getMaterials(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
		
		if (current != null) {
			
			String __sort = (String)StorageFactory.getStorage(StorageType.SESSION).get(sortedParameterName);
			if (__sort == null) {
				__sort = "alphabetical";
			}
			final String sort = __sort;
			
			List<DBPilotMaterialsListBean> pilotMaterials = DbAccess.pilotMaterialsAccess.getPilotMaterialsList(current.getPilotId());
			if (pilotMaterials != null) {
				/*
				for (DBPilotMaterialsListBean m: pilotMaterials) {
					m.setLocalized(I10N.tr(m.getMaterialUniq()));
				}
				*/
				pilotMaterials = pilotMaterials.stream().peek(m -> m.setLocalized(I10N.tr(m.getMaterialUniq()))).sorted(new Comparator<DBPilotMaterialsListBean>() {
					@Override
					public int compare(DBPilotMaterialsListBean o1, DBPilotMaterialsListBean o2) {
						if ("updated".equals(sort)) {
							if (o1.getUpdateTime().equals(o2.getUpdateTime())) {
								return o1.getLocalized().compareToIgnoreCase(o2.getLocalized());
							} else {
								return o1.getUpdateTime() > o2.getUpdateTime() ? 1:-1;
							}
						} else if ("quantity".equals(sort)) {
							return (int)(o2.getQuantity() - o1.getQuantity());
						} else {
							return o1.getLocalized().compareToIgnoreCase(o2.getLocalized());
						}
					}
				}).collect(Collectors.toList());
				
				current.setChilds(pilotMaterials);
			}
			Document xml = new XMLReflectionObj(current).toXML();
			xml.getDocumentElement().setAttribute("sort", sort);
			
			// Add engeneers
			List<DBEngTypeBean> types = DbAccess.engTypeAccess.getSortedList();
			types = types.stream().peek(m -> m.setLocalized(I10N.tr(m.getEngTypeName()))).sorted(new Comparator<DBEngTypeBean>() {
				@Override
				public int compare(DBEngTypeBean o1, DBEngTypeBean o2) {
					return o1.getLocalized().compareTo(o2.getLocalized());
				}
			}).collect(Collectors.toList());
			Document exml = new XMLList(types, true).toXML("eng_types");
			XMLUtils.appendClonedNode(xml, exml);
			
			
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:materials"});
			//logger.debug(XMLUtils.saveXML(xml));
		} else {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void updateMaterials(@Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		if (current != null) {
			
			String __sort = "alphabetical";
			
			ParametersHolder<String> post = (ParametersHolder<String>)StorageFactory.getStorage(StorageType.REQUEST).get(RequestType.REQUEST);
			//System.out.println(post.size());
			for (String key: post.getParameterMap().keySet()) {
				
				if ("material_sorting".equals(key)) {
					__sort = post.getStringParameter(key);
				} else {
					int value = Integer.valueOf(post.getStringParameter(key));
					DBMaterialsBean mat = DbAccess.materialsAccess.getByUniq(key);
					if (mat != null) {
						if (value == 0) {
							DbAccess.pilotMaterialsAccess.deleteByPrimaryKey(current.getPilotId(), mat.getMaterialId());
						} else {
							DBPilotMaterialsBean pm = DbAccess.pilotMaterialsAccess.getByPrimaryKey(current.getPilotId(), mat.getMaterialId());
							if (pm == null) {
								pm = new DBPilotMaterialsBean();
								pm.setPilotId(current.getPilotId()).setMaterialId(mat.getMaterialId()).setQuantity(value).setUpdateTime(new Timestamp(new Date().getTime()));
								DbAccess.pilotMaterialsAccess.insert(pm);
							} else {
								pm.setQuantity(value).setUpdateTime(new Timestamp(new Date().getTime()));
								DbAccess.pilotMaterialsAccess.updateByPrimaryKey(pm, current.getPilotId(), mat.getMaterialId());
							}
						}
					}
				}
			}
			final String sort = __sort;
			//System.out.println(sort);
			StorageFactory.getStorage(StorageType.SESSION).put(sortedParameterName, sort);
			List<DBPilotMaterialsListBean> pilotMaterials = DbAccess.pilotMaterialsAccess.getPilotMaterialsList(current.getPilotId());
			pilotMaterials = pilotMaterials.stream().peek(m -> m.setLocalized(I10N.tr(m.getMaterialUniq()))).sorted(new Comparator<DBPilotMaterialsListBean>() {
				@Override
				public int compare(DBPilotMaterialsListBean o1, DBPilotMaterialsListBean o2) {
					if ("updated".equals(sort)) {
						if (o1.getUpdateTime().equals(o2.getUpdateTime())) {
							return o1.getLocalized().compareToIgnoreCase(o2.getLocalized());
						} else {
							return o1.getUpdateTime() > o2.getUpdateTime() ? 1:-1;
						}
					} else if ("quantity".equals(sort)) {
						return (int)(o2.getQuantity() - o1.getQuantity());
					} else {
						return o1.getLocalized().compareToIgnoreCase(o2.getLocalized());
					}
				}
			}).collect(Collectors.toList());
			
			
			ContentObject.getInstance().setData(tag, new Result().put("materials", pilotMaterials).get());
			redirect.setRedirect(new DropRedirect());
		}
	}
	
	public void getBlueprintsMaterials(@ParameterRequest("eng-category") String category, 
			@ParameterRequest("eng-blueprint") String blueprint, @ParameterRequest("eng-grade") String grade, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		Result result = new Result();
		
		if (blueprint != null && grade != null) {
			List<DBMaterialsByBlueprintAndGradeBean> materials = DbAccess.engBlueprintMaterialsAccess.getMaterialsByBlueprintAndGrade(blueprint, grade);
			result.put("materials", materials);
		} else {
			List<DBGradesByTypeUniqBean> grades = DbAccess.engGradeAccess.getGradesByTypeUniq(category);
			grades = grades.stream().peek(m -> m.setLocalized(I10N.tr(m.getEngBlueprintName()))).sorted(new Comparator<DBGradesByTypeUniqBean>() {
				@Override
				public int compare(DBGradesByTypeUniqBean o1, DBGradesByTypeUniqBean o2) {
					return o1.getLocalized().compareTo(o2.getLocalized());
				}
			}).collect(Collectors.toList());

			List<DBMaterialsByTypeUniqBean> materials = DbAccess.engBlueprintMaterialsAccess.getMaterialsByTypeUniq(category);
			result.put("materials", materials).put("grades", grades);
		}
		
		ContentObject.getInstance().setData(tag, result.get());
		redirect.setRedirect(new DropRedirect());
	}
		
	public void getMaterialInfo(@ParameterRequest("material") String material, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		Result result = new Result();

		List<DBMaterialUnsingInfoBean> info = DbAccess.engBlueprintMaterialsAccess.getMaterialUnsingInfo(material);
		if (info != null) {
			info = info.stream().peek(m -> {
				m.setMaterialLoc(I10N.tr(m.getMaterialUniq()));
				m.setEngBlueprintName(I10N.tr(m.getEngBlueprintName()));
				m.setEngTypeName(I10N.tr(m.getEngTypeName()));
			}).collect(Collectors.toList());
			result.put("material", info);
		}
		
		ContentObject.getInstance().setData(tag, result.get());
		redirect.setRedirect(new DropRedirect());
	}
	
	// ============================================================== -MATERIALS ==============================================================================
	
	// ============================================================== +GALLERY ==============================================================================
	
	
	public void getPilotGallety(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
		if (current != null) {
			
			List<DBPilotsImagesBean> images = DbAccess.imagesAccess.getPilotsImages(new InInjector("l.pilot_id", linkedPilots));
			
			Map<Object, List<DBPilotsImagesBean>> grouped = Utils.getArrayGrouped(images, "image_id");
			
			List<DBTumbnailsForImageBean> tumbnails = DbAccess.imageTumbnailsAccess.getTumbnailsForImage(new InInjector("t.image_id", new ArrayList<>(grouped.keySet())));

			Map<Object, List<DBTumbnailsForImageBean>> tmb_grouped = Utils.getArrayGrouped(tumbnails, "image_id");
			for (Object key: tmb_grouped.keySet()) {
				if (grouped.containsKey(key)) {
					grouped.get(key).get(0).setTumbnails(tmb_grouped.get(key));
				}
			}
			
			Document xml = new XMLList(images, true).toXML("data");
			
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:gallery"});
			
		} else {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
	}
	
	
	// ============================================================== +GALLERY ==============================================================================
	
	
	
	// ============================================================== +ACCESS SETTINGS ==============================================================================
	
	public void getAccessSettings(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
		if (current != null) {
			//System.out.println(">>>>");
			Document xml = XMLUtils.createXML("item");
			List<DBUserLevelsBean> levels = new ArrayList<>();
			List<DBPilotInfoWithDefaultsBean> info = DbAccess.pilotsInfoAccess.getPilotInfoWithDefaults(current.getPilotId());
			for (DBPilotInfoWithDefaultsBean i: info) {
				for (Relation rel: Relation.values()) {
					DBUserLevelsBean level = new DBUserLevelsBean();
					level.setInfoId(i.getInfoId()).setRelateTo(rel.name()).setMask(i.getLevel().longValue() & rel.getMask());
					levels.add(level);
				}
			}
			XMLUtils.appendClonedNode(xml, new XMLList(levels, true).toXML("levels"));
			XMLUtils.appendClonedNode(xml, new XMLList(info, true).toXML("info"));
			XMLUtils.appendClonedNode(xml, new XMLList(Relation.getList(), true).toXML("relations"));
			//logger.debug(XMLUtils.saveXML(xml));
			//
			ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:view"});
			//redirect.setRedirect(new DropRedirect());
		} else {
			redirect.setRedirect(new DirectRedirect("/"));
			throw new SkipSubLevelsExeption();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void updateAccess(@ParameterRequest("level") Map<?,?> level, @Parameter("tag") String tag, RedirectControlerInterface redirect, ServletRequest request) {
		if (current != null) {
			Result result = null;
			Map<?,?> errors = null;
			try {
				for (Object infoId: level.keySet()) {
					//System.out.println(infoId.toString());
					Long mask = 0L;
					for (Object relName: ((Map<Object, Object>)level.get(infoId)).keySet()) {
						//System.out.println("\t" + relName.toString());
						mask |= Relation.valueOf(relName.toString()).getMask();
					}
					DBPilotsInfoBean bean = DbAccess.pilotsInfoAccess.getByPrimaryKey(current.getPilotId(), Long.valueOf(infoId.toString()));
					if (bean == null) {
						bean = new DBPilotsInfoBean().setPilotId(current.getPilotId()).setInfoId(Long.valueOf(infoId.toString())).setLevel(mask);
						DbAccess.pilotsInfoAccess.insert(bean);
					} else {
						bean.setLevel(mask);
						DbAccess.pilotsInfoAccess.updateByPrimaryKey(bean, current.getPilotId(), bean.getInfoId());
					}
				}
				
				result = new Result();
				
			} catch (Exception e) {
				e.printStackTrace();
				errors = ValueChecker.addError("__common", i10n(e.getMessage()), null);
			}
			
			Map<?, ?> data = (errors != null)?wrapError(errors):result.get();
			ContentObject.getInstance().setData(tag, data);
			redirect.setRedirect(new DropRedirect());
		}
	}
	
	// ============================================================== -ACCESS SETTINGS ==============================================================================
	
	public void checkCommander(UrlPart url, RedirectControlerInterface redirect, @CurrentUrl String currentUrl, ServletRequest request) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException, UnsupportedEncodingException, SkipSubLevelsExeption {
		
		String actionUrl = URLDecoder.decode(url.getPattern().substring(0, url.getPattern().length() - 1), "utf-8");
		
		DBUsersBean user = getUser();
		DBPilotsBean pilot = DbAccess.pilotsAccess.getByName(actionUrl);

		if (pilot != null && (long)pilot.getIsIgnored() == 0L) {
			
			if (pilot.getParentPilotId() != null) {
				DBPilotsBean parent = DbAccess.pilotsAccess.getByPrimaryKey(pilot.getParentPilotId());
				// Redirect
				String name = parent.getPilotName();
				ContentObject cms = ContentObject.getInstance();

				String lang_id = cms.getFixedParameter("language_id").toString();
				String isDefault = cms.getFixedParameter("default").toString();
				
				String redir = ("true".equals(isDefault)?"":"/" + lang_id) + url.getUrlParsed() + URLEncoder.encode(name, "utf-8") + "/" + url.getUrlReminder();
				//System.out.println(redir);
				redirect.setRedirect(new DirectRedirect(redir));
				//
				throw new SkipSubLevelsExeption();
			} else {
			
				List<DBPilotsRelationsBean> relations = new ArrayList<>();
				
				boolean passed = false;
				
				if (user == null) {
					relations = new ArrayList<>();
					relations.add(new DBPilotsRelationsBean().setRelation(Relation.UNKNOWN.getMask()).setIsMe(0L));
				} else if (user.getUserId().equals(pilot.getUserId())) {
					passed = true;
				} else {
					relations = DbAccess.pilotRelationsAccess.getPilotsRelations(user.getUserId(), pilot.getPilotId());
					if (relations == null) {
						relations = new ArrayList<>();
						relations.add(new DBPilotsRelationsBean().setRelation(Relation.LOGGED.getMask()).setIsMe(0L));
					}
				}
				
				//System.out.println(passed);
				
				passed = passed || hasRole(AuthRoles.ROLE_ADMINISTRATOR) || ((relations == null)?false: (relations.stream().filter(m -> (long)m.getIsMe() > 0).findFirst().orElse(null) != null));
				
				//System.out.println(passed);
				
				if (!passed && relations != null) {
					//System.out.println(url.getUrlReminder());
					String action = RegexpUtils.preg_replace("~^([^\\/]+)\\/.*$~", url.getUrlReminder(), "$1");
					//System.out.println(action);
					
					DBPilotInfoLinkWithDefaultsBean link = null;
					if (HTTPUtils.isAjax(request)) {
						link = DbAccess.pilotRelationsAccess.getAjaxPilotInfoLinkWithDefaults(pilot.getPilotId(), action);
					} else {
						link = DbAccess.pilotRelationsAccess.getPilotInfoLinkWithDefaults(pilot.getPilotId(), action);
					}
					//
					//System.out.println(">>>>" + link.getLevel());
					
					if (link != null) {
						for (DBPilotsRelationsBean rel: relations) {
							//System.out.println(rel.getRelation());
							passed = (link.getLevel().intValue() & rel.getRelation()) != 0;
							if (passed) {
								break;
							}
						}
					}
					
					//System.out.println(action);
				}
				
				if (passed) {
					current = pilot;
					
					List<DBPilotsBean> linked = DbAccess.pilotsAccess.getLinkedPilots(pilot.getPilotId());
					if (linked != null) {
						linkedPilots = linked.stream().map(x -> x.getPilotId()).collect(Collectors.toList());
					}
					
					if (linkedPilots == null) {
						linkedPilots = new ArrayList<>();
					}
					
					linkedPilots.add(current.getPilotId());
					
					ContentObject.getInstance().setFixedParameters("pilot", pilot.getPilotName().replace("'", "\\'"));
					ContentObject.getInstance().setFixedParameters("pilotEncoded", pilot.getPilotName().replace(" ", "%20"));
					ContentObject.getInstance().setFixedParameters("pilotReal", pilot.getPilotName());
				}
			}
		}
		//System.out.println(current);
	}
	
	public void checkCommander1(UrlPart url, RedirectControlerInterface redirect, @CurrentUrl String currentUrl) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException, UnsupportedEncodingException {
		
		//String actionUrl = url.getPattern().substring(0, url.getPattern().length() - 1).toLowerCase();
		String actionUrl = URLDecoder.decode(url.getPattern().substring(0, url.getPattern().length() - 1), "utf-8");
		
		//String actionUrl = URLDecoder.decode(url.getPattern().substring(0, url.getPattern().length() - 1), "utf-8");
		//logger.debug("1 dencoding: {}", url.getPattern().substring(0, url.getPattern().length() - 1).toLowerCase());
		//logger.debug("2 dencoding: {}", URLDecoder.decode(url.getPattern().substring(0, url.getPattern().length() - 1), "utf-8"));
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println(currentUrl);
		DBUsersBean user = getUser();
		DBPilotsBean pilot = null;
		
		if (user != null) {
			pilot = DbAccess.pilotsAccess.getByName(actionUrl);
			if (pilot != null && (long)pilot.getIsIgnored() == 0 && pilot.getParentPilotId() == null && (pilot.getUserId().equals(user.getUserId()) || hasRole(AuthRoles.ROLE_ADMINISTRATOR))) {
				current = pilot;
				
				List<DBPilotsBean> linked = DbAccess.pilotsAccess.getLinkedPilots(pilot.getPilotId());
				if (linked != null) {
					linkedPilots = linked.stream().map(x -> x.getPilotId()).collect(Collectors.toList());
				}
				
				if (linkedPilots == null) {
					linkedPilots = new ArrayList<>();
				}
				
				linkedPilots.add(current.getPilotId());
				
				ContentObject.getInstance().setFixedParameters("pilot", pilot.getPilotName().replace("'", "\\'"));
				ContentObject.getInstance().setFixedParameters("pilotEncoded", pilot.getPilotName().replace(" ", "%20"));
				ContentObject.getInstance().setFixedParameters("pilotReal", pilot.getPilotName());
			}
		}
	}
	
}
