package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.util.List;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CommanderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Commander extends AbstractJournalEvent<CommanderBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Commander.class);
	
	{
		beanClass = CommanderBean.class;
	}
	
	protected void processBean(CommanderBean bean) {

			try {
				/**
				 * Set current pilot for user
				 */
				DBPilotsBean current = null;
				
				List<DBPilotsBean> pilots = DbAccess.pilotsAccess.getByUserId(user.getUserId());
				if (pilots != null && pilots.size() > 0) {
					for(DBPilotsBean pilot: pilots) {
						if (pilot.getPilotName().toLowerCase().equals(bean.getName().toLowerCase())) {
							pilot.setIsCurrent(1);
							current = pilot;
						} else {
							pilot.setIsCurrent(0);
						}
						DbAccess.pilotsAccess.updateByPrimaryKey(pilot, pilot.getPilotId());
					}
				}
				
				if (current == null) {
					current = new DBPilotsBean();
					current.setUserId(user.getUserId());
					current.setPilotName(bean.getName());
					current.setIsCurrent(1);
					current.setIsIgnored(DbAccess.pilotsAccess.getCheckPilotName(bean.getName()).getNameOther() == 0L?0:1);
					DbAccess.pilotsAccess.insert(current);
				}
				
			} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
				throw new RuntimeException(e);
			}
		}

}
	