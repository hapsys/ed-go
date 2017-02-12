package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBMaterialsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PilotDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SynthesisBean;
import org.c3s.edgo.utils.EDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Synthesis extends AbstractJournalEvent<SynthesisBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Synthesis.class);
	
	{
		beanClass = SynthesisBean.class;
	}
	
	protected void processBean(SynthesisBean bean) {
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				
				for(String name: bean.getMaterials().keySet()) {
					String uniq = EDUtils.cutFull(name);
					DBMaterialsBean mat = DbAccess.materialsAccess.getByUniq(uniq);
					if (mat != null) {
						PilotDAO.insertUpdateMaterial(pilot.getPilotId(), mat.getMaterialId(), -bean.getMaterials().get(name));
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	