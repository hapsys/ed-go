package org.c3s.edgo.web.menu;

import java.sql.SQLException;
import java.util.List;

import org.c3s.annotations.Controller;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBUsersBean;
import org.c3s.edgo.web.GeneralController;
import org.c3s.web.nodes.menu.MenuModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Controller
public class CommanderMenu extends MenuModule {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(CommanderMenu.class); 
	
	private List<DBPilotsBean> pilots = null;
	
	public void getPilotList() throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBUsersBean user = GeneralController.getUser();
		if (user != null) {
			//pilots = GeneralController.getEntityManager().createNamedQuery("Pilot.findByUserId", Pilot.class).setParameter("user_id", user.getUserId()).getResultList().stream().collect(Collectors.toList());
			pilots = DbAccess.pilotsAccess.getByUserId(user.getUserId());
		}
	}
	
	protected void presaveXML(Document doc) {
		if (pilots != null && pilots.size() > 0) {
			Element elm = doc.createElement("pilots");
			doc.getDocumentElement().appendChild(elm);
			for (DBPilotsBean pilot: pilots) {
				Element pelm = doc.createElement("pilot");
				pelm.setAttribute("name", pilot.getPilotName());
				elm.appendChild(pelm);
			}
			/*
			try {
				logger.debug(XMLUtils.xml2out(doc));
			} catch (XMLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
	}
}
