package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBMaterialsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PilotDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.EngineerCraftBean;
import org.c3s.edgo.event.impl.beans.intl.NameCount;
import org.c3s.edgo.utils.EDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineerCraft extends AbstractJournalEvent<EngineerCraftBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(EngineerCraft.class);
	
	{
		beanClass = EngineerCraftBean.class;
	}
	
	protected void processBean(EngineerCraftBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				if (bean.getIngredients() != null) {
					for(NameCount ing: bean.getIngredients()) {
						String uniq = EDUtils.cutFull(ing.getName());
						DBMaterialsBean mat = DbAccess.materialsAccess.getByUniq(uniq);
						if (mat != null) {
							System.out.println(pilot.getPilotName());
							System.out.println(mat.getMaterialId());
							System.out.println(ing.getCount());
							PilotDAO.insertUpdateMaterial(pilot.getPilotId(), mat.getMaterialId(), -ing.getCount());
						}
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
	