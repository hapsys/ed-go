package org.c3s.edgo.web.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBSearchPilotsBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.edgo.relations.Relation;
import org.c3s.edgo.web.GeneralController;
import org.c3s.edgo.web.validator.Result;
import org.c3s.utils.RegexpUtils;
import org.c3s.web.redirect.DropRedirect;
import org.c3s.xml.utils.XMLUtils;
import org.w3c.dom.Document;

public class Searcher extends GeneralController {

	public void pilotSearchCanvas(@Parameter("tag") String tag, @Parameter("template") String template) throws Exception {
		
		Document xml = XMLUtils.createXML("data");
		ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:canvas"});
		
	}
	
	
	public void pilotSearch(@ParameterRequest("search") String search, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		DBUsersBean user = getUser();
		
		Map<String, Long> current = new HashMap<>();
		
		Long user_id = user != null?user.getUserId():0;
		current.put("level", user != null?Relation.LOGGED.getMask():Relation.UNKNOWN.getMask());
		current.put("userId", user_id);
		
		search = (search == null)?"":search;
		search = RegexpUtils.preg_replace("~[%_]~", search, "") + "%";

		//System.out.println("|" + search + "|");
		
		List<DBSearchPilotsBean> pilots = DbAccess.pilotsAccess.getSearchPilots(user_id, search);
		
		ContentObject.getInstance().setData(tag, new Result().put("relations", Relation.getList()).put("pilots", pilots).put("user", current).get());
		
		redirect.setRedirect(new DropRedirect());
	}
}
