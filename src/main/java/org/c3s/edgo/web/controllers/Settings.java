package org.c3s.edgo.web.controllers;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBEventsHistoryBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBPilotsLinkedInfoBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.edgo.common.intruders.EventHistoryPilotsInjector;
import org.c3s.edgo.common.intruders.InInjector;
import org.c3s.edgo.web.GeneralController;
import org.c3s.reflection.XMLList;
import org.c3s.web.redirect.DropRedirect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

public class Settings extends GeneralController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Settings.class);

	public void pilotLinkSettings(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect, String mode) throws Exception {
		
		List<DBPilotsLinkedInfoBean> pilots = DbAccess.pilotsAccess.getPilotsLinkedInfo(getUser().getUserId());
		
		Document xml = new XMLList(pilots, true).toXML("data");	
		
		//logger.debug(XMLUtils.saveXML(xml));
		//System.out.println(template);
		//System.out.println(templates.length);
		if (mode == null) {
			mode = "mode:pilots_control";
		}
		ContentObject.getInstance().setData(tag, xml, template, new String[]{mode});
		
	}
	
	public void pilotLinkSettingsUpdate(@Parameter("tag") String tag, @Parameter("template") String template, 
			@ParameterRequest("link") Map<String, Object> links, @ParameterRequest("unlink") Map<String, Object> unlinks, @ParameterRequest("hide") Map<String, Object> hidden, RedirectControlerInterface redirect) throws Exception {
		
		DBUsersBean user = GeneralController.getUser();
		if (user != null) {
			List<DBPilotsBean> pilots = DbAccess.pilotsAccess.getByUserId(user.getUserId());
			if (pilots != null) {
				List<Long> pilotsId = pilots.stream().map(x -> x.getPilotId()).collect(Collectors.toList());
				List<DBEventsHistoryBean> history = DbAccess.eventsHistoryAccess.getPilotsLastEvents(new EventHistoryPilotsInjector(pilotsId));
				Map<Long, DBEventsHistoryBean> pilotsHistory = history.stream().collect(Collectors.toMap(x -> x.getPilotId(), x -> x));  
				Map<Long, DBPilotsBean> pilotsMap = pilots.stream().collect(Collectors.toMap(x -> x.getPilotId(), x -> x));
				
				/*
				 * Set/Unset hidden
				 */
				if (hidden != null) {
					for (String key: hidden.keySet()) {
						Integer set = "1".equals(hidden.get(key))?1:0;
						//System.out.println(set);
						Long id = Long.parseLong(key);
						if (!pilotsMap.get(id).getIsIgnored().equals(set)) {
							if ((int)set == 1) {
								//pilots.stream().filter(x -> id.equals(x.getParentPilotId())).forEach(x -> System.out.println(x.getPilotId()));
								pilots.stream().filter(x -> id.equals(x.getParentPilotId())).forEach(x -> {
									try {
										DbAccess.pilotsAccess.updateByPrimaryKey(x.setParentPilotId(null), x.getPilotId());
									} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
									}
								});
							}
							DbAccess.pilotsAccess.updateByPrimaryKey(pilotsMap.get(id).setIsIgnored(set), pilotsMap.get(id).getPilotId());
						}
					}
				}
				/*
				 * Unlink pilots
				 */
				if (unlinks != null) {
					for (String key: unlinks.keySet()) {
						Long id = Long.parseLong(key);
						DbAccess.pilotsAccess.updateByPrimaryKey(pilotsMap.get(id).setParentPilotId(null), pilotsMap.get(id).getPilotId());
					}
				}
				/*
				 * link pilots
				 */
				if (links != null && links.size() > 1) {
					Long linkToId = null;
					long maxtime = 0;
					for (String key: links.keySet()) {
						Long id = Long.parseLong(key);
						if (pilotsHistory.containsKey(id)) {
							if (pilotsHistory.get(id).getEventTimestamp() != null) {
								if (pilotsHistory.get(id).getEventTimestamp().getTime() - maxtime > 0) {
									maxtime = pilotsHistory.get(id).getEventTimestamp().getTime();
									linkToId = pilotsHistory.get(id).getPilotId();
								}
							}
						}
					}
					if (linkToId != null) {
						for (String key: links.keySet()) {
							Long id = Long.parseLong(key);
							if (!linkToId.equals(id)) {
								DbAccess.pilotsAccess.updateByPrimaryKey(pilotsMap.get(id).setParentPilotId(linkToId), pilotsMap.get(id).getPilotId());
							}
						}
					}
				}
			}
			redirect.setRedirect(new DropRedirect());
			pilotLinkSettings(tag, template, redirect, "mode:pilots_control_update");
		}
	}
}
