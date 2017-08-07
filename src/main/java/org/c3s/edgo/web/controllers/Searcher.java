package org.c3s.edgo.web.controllers;

import java.sql.SQLException;
import java.util.List;

import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBSearchPilotsBean;
import org.c3s.edgo.web.validator.Result;
import org.c3s.utils.RegexpUtils;
import org.c3s.web.redirect.DropRedirect;
import org.c3s.xml.utils.XMLUtils;
import org.w3c.dom.Document;

public class Searcher {

	public void pilotSearchCanvas(@Parameter("tag") String tag, @Parameter("template") String template) throws Exception {
		
		Document xml = XMLUtils.createXML("data");
		ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:canvas"});
		
	}
	
	
	public void pilotSearch(@ParameterRequest("search") String search, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		search = search == null?"":search;
		search = RegexpUtils.preg_replace("~[%_\\]~", search, "\\$0") + "%";
		
		List<DBSearchPilotsBean> pilots = DbAccess.pilotsAccess.getSearchPilots(search);
		
		ContentObject.getInstance().setData(tag, new Result().put("factions", pilots).get());
		redirect.setRedirect(new DropRedirect());
	}
}
