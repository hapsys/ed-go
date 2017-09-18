/**
 * 
 */
package org.c3s.edgo.web.utilites;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBFactionDateMinMaxBean;
import org.c3s.edgo.common.beans.DBFactionInfluenceBean;
import org.c3s.edgo.common.beans.DBFactionInfluenceNamesBean;
import org.c3s.edgo.common.beans.DBFactionsBean;
import org.c3s.edgo.common.beans.DBFactionsSearchBean;
import org.c3s.edgo.common.beans.DBSystemFactionInfluenceBean;
import org.c3s.edgo.common.beans.DBSystemsFactionHistoryBean;
import org.c3s.edgo.common.beans.DBSystemsFactionsInfluenceBean;
import org.c3s.edgo.common.intruders.InInjector;
import org.c3s.edgo.common.intruders.SystemFactionHistoryInjector;
import org.c3s.edgo.web.validator.Result;
import org.c3s.exceptions.XMLException;
import org.c3s.reflection.XMLList;
import org.c3s.utils.RegexpUtils;
import org.c3s.utils.Utils;
import org.c3s.web.redirect.DropRedirect;
import org.c3s.xml.utils.XMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * @author admin
 *
 */
public class Factions {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Factions.class);
	
	
	public void getFactionsByPatiallyName(@ParameterRequest("faction") String str, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		//SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println("HERE");
		List<DBFactionsSearchBean> factions = null;
		if (str != null && str.length() > 0) {
			str = str.toLowerCase() + '%';
			factions = DbAccess.factionsAccess.getFactionsSearch(str);
		}
		
		// Compare date
		/*
		if (factions != null) {
			Long date = (new Date().getTime() - 31 * 24 * 3600 * 1000) ;
			System.out.println(dateTimeFormat.format(new Date()));
			System.out.println(dateTimeFormat.format(new Date(new Date().getTime())));
			factions.forEach((x) -> {if (x.getMinDate() < date) { x.setMinDate(date);}});
		}
		*/
		//
		ContentObject.getInstance().setData(tag, new Result().put("factions", factions).get());
		redirect.setRedirect(new DropRedirect());
	}
	
	
	public void getCanvas(@Parameter("tag") String tag, @Parameter("template") String template) throws XMLException {
		
		Document xml = XMLUtils.createXML("data"); 
		for (int i = 0; i < 24; i++) {
			String time = (i < 10?"0":"") + i + ":00";
			Element elm = xml.createElement("time");
			elm.setAttribute("value", time);
			xml.getDocumentElement().appendChild(elm);
		}
		ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:canvas"});
		
		//System.out.println(XMLUtils.saveXML(xml));
	}


	public void getFactionInformation(@ParameterRequest("faction") String factionIdStr, @ParameterRequest("update") String updateDate, @ParameterRequest("from") String from, @ParameterRequest("to") String to,
			@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException, ParseException, XMLException, DOMException, ParserConfigurationException, SAXException, IOException {

		Long factionId = new Long(factionIdStr);
		
		//System.out.println(factionId);
		//System.out.println(from);
		//System.out.println(to);
		DBFactionDateMinMaxBean factionMinMax = DbAccess.factionsAccess.getFactionDateMinMax(factionId);
		if (factionMinMax == null) {
			return;
		}
		
		long min_date = Long.MAX_VALUE, max_date = 0;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (updateDate == null || !RegexpUtils.preg_match("~^\\d{2}:\\d{2}:\\d{2}$~", updateDate, new ArrayList<>())) {
			updateDate = "16:00:00";
		}
		
		Date fromDate, toDate;
		
		if (from == null || !RegexpUtils.preg_match("~^\\d{4}-\\d{2}-\\d{2}$~", from, new ArrayList<>())) {
			//System.out.println("Min>" + factionMinMax.getMinDate());
			from = dateFormat.format(new Date(factionMinMax.getMinDate() * 1000L));
		}
		
		if (to == null || !RegexpUtils.preg_match("~^\\d{4}-\\d{2}-\\d{2}$~", to, new ArrayList<>())) {
			//System.out.println("Max>" + factionMinMax.getMaxDate());
			to = dateFormat.format(new Date(factionMinMax.getMaxDate() * 1000L));
		}
		
		fromDate = dateTimeFormat.parse(from + " " + updateDate);
		toDate = dateTimeFormat.parse(to + " " + updateDate);
		
		
		//System.out.println(from + " " + updateDate);
		//System.out.println(to + " " + updateDate);
		
		
		List<DBSystemsFactionHistoryBean> listBeans = DbAccess.systemFactionsHistoryAccess.getSystemsFactionHistory(factionId);
		
		for (DBSystemsFactionHistoryBean lb: listBeans) {
			String sql = "SELECT GetFactionHistoryInfo(" + lb.getSystemId() +", " + lb.getFactionId() +", '" + from + " " + updateDate + "') as create_date LIMIT 1";
			List<Map<String, Object>> createDate =  DbAccess.systemFactionsHistoryAccess.getCon().fetchRows(sql);
			lb.setCreateDate(createDate.get(0).get("create_date").toString());
		}
		
		/*
		List<DBSystemFactionInfluenceBean> info = DbAccess.systemFactionsHistoryAccess.getSystemFactionInfluence(factionId, 
				to + " " + updateDate, 	from + " " + updateDate, from + " " + updateDate);
		*/
		List<DBSystemFactionInfluenceBean> info = DbAccess.systemFactionsHistoryAccess.getSystemFactionInfluence( 
				to + " " + updateDate, new SystemFactionHistoryInjector(listBeans));
		
		for (DBSystemFactionInfluenceBean inf: info) {
			if (inf.getCreateDate().getTime() > max_date) {
				max_date = inf.getCreateDate().getTime();
			}
			if (inf.getCreateDate().getTime() < min_date) {
				min_date = inf.getCreateDate().getTime();
			}
		}
		
		
		//String startDateString = dateFormat.format(new Date(min_date)) + " " + updateDate;
		
		//System.out.println(startDateString);
		
		//Date startDate = dateTimeFormat.parse(startDateString);
		//Date endDate = startDate; 
		
		
		Map<BigInteger, Map<Long, List<DBFactionInfluenceBean>>> chkSystems = new ConcurrentHashMap<>();
		Map<BigInteger, Map<Long, List<DBSystemFactionInfluenceBean>>> fillSystems = new ConcurrentHashMap<>();
		Map<BigInteger, String> systemNames = new ConcurrentHashMap<>();
		Map<Long, String> factionNames = new ConcurrentHashMap<>();
		
		for (DBSystemFactionInfluenceBean val: info) {
			
			if (!systemNames.containsKey(val.getSystemId())) {
				systemNames.put(val.getSystemId(), val.getSystemName());
			}
			if (!factionNames.containsKey(val.getFactionName())) {
				factionNames.put(val.getFactionId(), val.getFactionName());
			}
			
			// chkSystems
			if (!chkSystems.containsKey(val.getSystemId())) {
				chkSystems.put(val.getSystemId(), new ConcurrentHashMap<>());
			}
			if (!chkSystems.get(val.getSystemId()).containsKey(val.getFactionId())) {
				chkSystems.get(val.getSystemId()).put(val.getFactionId(), new ArrayList<>());
			}
			
			/*
			chkSystems.get(val.getSystemId()).get(val.getFactionId()).add(new DBFactionInfluenceBean()
					.setState(val.getStateName())
					.setTimestamp(new Date(val.getCreateDate().getTime()))
					.setInfluence(val.getInfluence())
			);
			*/
			
			// fillSystems
			
			if (!fillSystems.containsKey(val.getSystemId())) {
				fillSystems.put(val.getSystemId(), new ConcurrentHashMap<>());
			}
			if (!fillSystems.get(val.getSystemId()).containsKey(val.getFactionId())) {
				fillSystems.get(val.getSystemId()).put(val.getFactionId(), new ArrayList<>());
			}
			
			fillSystems.get(val.getSystemId()).get(val.getFactionId()).add(val);		
		}
		
		
		max_date = toDate.getTime();
		min_date = fromDate.getTime();
		
		
		for (BigInteger systemId: fillSystems.keySet()) {
			for (Long factId: fillSystems.get(systemId).keySet()) {
				Long iter = min_date;
				int idx = 0;
				List<DBSystemFactionInfluenceBean> sar = fillSystems.get(systemId).get(factId); 
				int cnt = sar.size();
				
				while (iter <= max_date) {
					
		            while (idx < (cnt-1) && iter > sar.get(idx + 1).getCreateDate().getTime()) {
		                idx++;
		            }
					
		            DBSystemFactionInfluenceBean sib = sar.get(idx);
		            
		            DBFactionInfluenceBean fib = new DBFactionInfluenceBean()
		            		.setInfluence(sib.getInfluence())
		            		.setState(sib.getStateName())
		            		.setTimestamp(new Date(sib.getCreateDate().getTime()))
		            		.setDate(dateFormat.format(new Date(iter)))
		            		.setInherited((iter - sib.getCreateDate().getTime()) > 24 * 3600 * 1000L)
		            ;
		            
		            chkSystems.get(systemId).get(factId).add(fib);
		            
		            iter += 24 * 3600 * 1000L;
				}
			}
		}
		
		
		
		List<DBFactionsBean> factionsInfo = DbAccess.factionsAccess.getFactionInformation(new InInjector("faction_id", new ArrayList<>(factionNames.keySet())));
		Map<Object, List<DBFactionsBean>> factionsInfoMap = Utils.getArrayGrouped(factionsInfo, "factionId");
		//
		//
		//
		List<DBSystemsFactionsInfluenceBean> systems = new ArrayList<>();
		for (BigInteger systemId: chkSystems.keySet()) {
			DBSystemsFactionsInfluenceBean system = new DBSystemsFactionsInfluenceBean().setSystemId(systemId).setSystemName(systemNames.get(systemId)).setInfluenceFactions(new ArrayList<>());
			systems.add(system);
			for (Long factId: chkSystems.get(systemId).keySet()) {
				List<DBFactionInfluenceBean> list = chkSystems.get(systemId).get(factId);
				Collections.reverse(list);
				DBFactionInfluenceNamesBean faction = new DBFactionInfluenceNamesBean()
						.setFactionId(factId)
						.setFactionName(factionNames.get(factId))
						.setInfluenceDates(list)
						.setFactionInfo(factionsInfoMap.get(factId).size() > 0? factionsInfoMap.get(factId).get(0): null);
				system.getInfluenceFactions().add(faction);
			}
			
			List<DBFactionInfluenceNamesBean> sortedFaction = system.getInfluenceFactions(); 
			Collections.sort(sortedFaction, new Comparator<DBFactionInfluenceNamesBean>() {
				@Override
				public int compare(DBFactionInfluenceNamesBean o1, DBFactionInfluenceNamesBean o2) {
					if (o1.getFactionId().equals(factionId)) {
						return -1;
					} else if (o2.getFactionId().equals(factionId)) {
						return 1;
					} else if (o1.getInfluenceDates().get(0).getInfluence() == null && o2.getInfluenceDates().get(0).getInfluence() == null) {
						return 0; 
					} else if (o1.getInfluenceDates().get(0).getInfluence() == null) {
						return 1; 
					} else if (o2.getInfluenceDates().get(0).getInfluence() == null) {
						return -1; 
					} else {
						return o2.getInfluenceDates().get(0).getInfluence().compareTo(o1.getInfluenceDates().get(0).getInfluence());
					}
				}
			});
			system.setInfluenceFactions(sortedFaction);
		}
		
		Collections.sort(systems, new Comparator<DBSystemsFactionsInfluenceBean>() {
			@Override
			public int compare(DBSystemsFactionsInfluenceBean o1, DBSystemsFactionsInfluenceBean o2) {
				return o1.getSystemName().compareToIgnoreCase(o2.getSystemName());
			}
		});
		
		//Document xml = new XMLReflectionObj(systems, true).toXML();
		Document xml = new XMLList(systems, true).toXML("data");
		xml.getDocumentElement().setAttribute("faction_id", factionIdStr);
		
		xml.getDocumentElement().setAttribute("minDate", factionMinMax.getMinDate().toString());
		xml.getDocumentElement().setAttribute("maxDate", factionMinMax.getMaxDate().toString());
		
		ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:faction_list"});
		redirect.setRedirect(new DropRedirect());
		
		//System.out.println(XMLUtils.saveXML(xml));
	}
}
