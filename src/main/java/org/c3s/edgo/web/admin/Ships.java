package org.c3s.edgo.web.admin;

import java.sql.SQLException;
import java.util.List;

import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBShipSlotsByShipUniqBean;
import org.c3s.edgo.web.validator.Result;
import org.c3s.reflection.XMLList;
import org.c3s.web.redirect.DropRedirect;
import org.c3s.xml.utils.XMLUtils;
import org.w3c.dom.Document;

public class Ships {
	
	public void getCanvas(@Parameter("tag") String tag, @Parameter("template") String template, RedirectControlerInterface redirect) throws Exception {
		
		Document xml = new XMLList(DbAccess.shipsAccess.getActualShipsList(), true).toXML("data");
		
		ContentObject.getInstance().setData(tag, xml, template, new String[]{"mode:info"});

		//System.out.println(XMLUtils.saveXML(xml));
	}
	
	
	public void getSlots(@ParameterRequest("ship_uniq") String ship_uniq, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		List<DBShipSlotsByShipUniqBean> slots = DbAccess.slotsAccess.getShipSlotsByShipUniq(ship_uniq);
		
		ContentObject.getInstance().setData(tag, new Result().put("slots", slots).get());
		
		redirect.setRedirect(new DropRedirect());
	}
	
	public void deleteSlotFromShip(@ParameterRequest("ship_uniq") String ship_uniq, @ParameterRequest("slot_id") String slot_id, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		DbAccess.shipSlotsAccess.deleteSlotFromShip(ship_uniq, slot_id);
		
		ContentObject.getInstance().setData(tag, new Result().get());
		
		redirect.setRedirect(new DropRedirect());
	}
	
	
	public void updateSlotForShip(@ParameterRequest("ship_uniq") String ship_uniq, @ParameterRequest("slot_id") String slot_id, @ParameterRequest("size") String size, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		DbAccess.shipSlotsAccess.updateSlotForShip(size, ship_uniq, slot_id);
		
		ContentObject.getInstance().setData(tag, new Result().get());
		
		redirect.setRedirect(new DropRedirect());
	}
	
}
