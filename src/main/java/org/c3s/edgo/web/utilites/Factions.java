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
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;

import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBFactionInfluenceBean;
import org.c3s.edgo.common.beans.DBFactionInfluenceNamesBean;
import org.c3s.edgo.common.beans.DBFactionsSearchBean;
import org.c3s.edgo.common.beans.DBSystemFactionInfluenceBean;
import org.c3s.edgo.common.beans.DBSystemsFactionsInfluenceBean;
import org.c3s.edgo.web.validator.Result;
import org.c3s.exceptions.XMLException;
import org.c3s.reflection.XMLList;
import org.c3s.web.redirect.DropRedirect;
import org.c3s.xml.utils.XMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author admin
 *
 */
public class Factions {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Factions.class);
	
	
	public void getFactionsByPatiallyName(@ParameterRequest("faction") String str, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		//System.out.println("HERE");
		List<DBFactionsSearchBean> factions = null;
		if (str != null && str.length() > 0) {
			str = str.toLowerCase() + '%';
			factions = DbAccess.factionsAccess.getFactionsSearch(str);
		}
		ContentObject.getInstance().setData(tag, new Result().put("factions", factions).get());
		redirect.setRedirect(new DropRedirect());
	}
	
	
	public void getCanvas(@Parameter("tag") String tag, @Parameter("template") String template) throws XMLException {
		
		Document xml = XMLUtils.createXML("data"); 
		ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:canvas"});
		
	}

	
	public void getFactionInformation(@ParameterRequest("faction") String factionIdStr, @Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException, ParseException, XMLException, DOMException, ParserConfigurationException, SAXException, IOException {

		Long factionId = new Long(factionIdStr);
		
		//System.out.println(factionId);
		
		long min_date = Long.MAX_VALUE, max_date = 0;
		
		List<DBSystemFactionInfluenceBean> info = DbAccess.systemFactionsHistoryAccess.getSystemFactionInfluence(factionId);
		
		for (DBSystemFactionInfluenceBean inf: info) {
			if (inf.getCreateDate().getTime() > max_date) {
				max_date = inf.getCreateDate().getTime();
			}
			if (inf.getCreateDate().getTime() < min_date) {
				min_date = inf.getCreateDate().getTime();
			}
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String startDateString = dateFormat.format(new Date(min_date)) + " 16:00:00";
		
		Date startDate = dateTimeFormat.parse(startDateString);
		Date endDate = startDate; 
		
		
		Map<BigInteger, Map<Long, List<DBFactionInfluenceBean>>> chkSystems = new ConcurrentHashMap<>();
		Map<BigInteger, String> systemNames = new ConcurrentHashMap<>();
		Map<Long, String> factionNames = new ConcurrentHashMap<>();
		
		for (DBSystemFactionInfluenceBean val: info) {
			
			if (!systemNames.containsKey(val.getSystemId())) {
				systemNames.put(val.getSystemId(), val.getSystemName());
			}
			if (!factionNames.containsKey(val.getFactionName())) {
				factionNames.put(val.getFactionId(), val.getFactionName());
			}
			
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
		}
		
		if (startDate.getTime() < min_date) {
			endDate = new Date(startDate.getTime() + 1000L * 24 * 3600);  
		} else {
			startDate = new Date(startDate.getTime() - 1000L * 24 * 3600);
		}
		
		
		while (startDate.getTime() < max_date) {
			
			//System.out.println(">>>");
			//System.out.println(dateTimeFormat.format(startDate));
			//System.out.println(endDate.getTime());
			
			
			String startDateStr = dateFormat.format(startDate);
			
			final Date sd = startDate, ed = endDate;
			
			List<DBSystemFactionInfluenceBean> list = info.stream().filter(x -> x.getCreateDate().getTime() > sd.getTime() && x.getCreateDate().getTime() <= ed.getTime()).collect(Collectors.toList());
			//System.out.println(list.size());
			
			for (DBSystemFactionInfluenceBean val: list) {
				chkSystems.get(val.getSystemId()).get(val.getFactionId()).add(new DBFactionInfluenceBean()
					.setState(val.getStateName())
					.setTimestamp(new Date(val.getCreateDate().getTime()))
					.setInfluence(val.getInfluence())
					.setSeeFlag(false)
					.setInherited(false)
				);
			}
			
			for (BigInteger systemId: chkSystems.keySet()) {
				for (Long factId: chkSystems.get(systemId).keySet()) {
					List<DBFactionInfluenceBean> infl = chkSystems.get(systemId).get(factId);
					if (infl.size() == 0) {
						infl.add(new DBFactionInfluenceBean()
							.setDate(startDateStr)
							.setSeeFlag(true)
							.setInherited(false)
						);
					} else {
						DBFactionInfluenceBean val = infl.get(infl.size() - 1);
						if (val.getSeeFlag()) {
							infl.add(new DBFactionInfluenceBean()
									.setInfluence(val.getInfluence())
									.setState(val.getState())
									.setDate(startDateStr)
									.setSeeFlag(true)
									.setInherited(true)
								);
						} else {
							val.setDate(startDateStr).setSeeFlag(true);
						}
					}
				}
			}
			//
			startDate = endDate;
			endDate = new Date(endDate.getTime() + 1000L * 24 * 3600);
		}
		
		List<DBSystemsFactionsInfluenceBean> systems = new ArrayList<>();
		for (BigInteger systemId: chkSystems.keySet()) {
			DBSystemsFactionsInfluenceBean system = new DBSystemsFactionsInfluenceBean().setSystemId(systemId).setSystemName(systemNames.get(systemId)).setInfluenceFactions(new ArrayList<>());
			systems.add(system);
			for (Long factId: chkSystems.get(systemId).keySet()) {
				List<DBFactionInfluenceBean> list = chkSystems.get(systemId).get(factId);
				Collections.reverse(list);
				DBFactionInfluenceNamesBean faction = new DBFactionInfluenceNamesBean().setFactionId(factId).setFactionName(factionNames.get(factId)).setInfluenceDates(list);
				system.getInfluenceFactions().add(faction);
			}
			Collections.sort(system.getInfluenceFactions(), new Comparator<DBFactionInfluenceNamesBean>() {
				@Override
				public int compare(DBFactionInfluenceNamesBean o1, DBFactionInfluenceNamesBean o2) {
					if (o1.getFactionId().equals(factionId)) {
						return -1;
					} else {
						return o2.getInfluenceDates().get(0).getInfluence().compareTo(o1.getInfluenceDates().get(0).getInfluence());
					}
				}
			});
		}
		
		//Document xml = new XMLReflectionObj(systems, true).toXML();
		Document xml = new XMLList(systems, true).toXML("data");
		
		xml.getDocumentElement().setAttribute("faction_id", factionIdStr);
		
		ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:faction_list"});
		redirect.setRedirect(new DropRedirect());
		
		//System.out.println(XMLUtils.saveXML(xml));
	}
}
