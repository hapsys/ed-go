package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.collections.map.HashedMap;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBStoredModulesListBean;
import org.c3s.edgo.common.dao.ShipsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.StoredModulesBean;
import org.c3s.edgo.event.impl.beans.intl.StoredModule;
import org.c3s.edgo.utils.EDUtils;
import org.c3s.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoredModules extends AbstractJournalEvent<StoredModulesBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(StoredModules.class);
	
	{
		beanClass = StoredModulesBean.class;
	}
	
	protected void processBean(StoredModulesBean bean) {
		
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				
				List<StoredModule> modules = (bean.getItems() != null)? Arrays.asList(bean.getItems()): new ArrayList<>();
				
				for (StoredModule module: modules) {
					if (module.getStarSystem() != null) {
						module.setStrHash(module.getStarSystem().toLowerCase() + module.getMarketID() + EDUtils.getModuleUniq(module.getName()));
					} else {
						module.setStrHash("transit_" + EDUtils.getModuleUniq(module.getName()));
					}
				}
				
				Map<StoredModule, Boolean> insert = modules.stream().collect(Collectors.toMap(x -> x, x -> true));
				Map<DBStoredModulesListBean, Boolean> delete = new HashMap<>();
				
				Map<Object, List<StoredModule>> mg = Utils.getArrayGrouped(modules, "strHash");
				
				List<DBStoredModulesListBean> dbModules = DbAccess.storedModulesAccess.getStoredModulesList(pilot.getPilotId());
				
				if (dbModules != null) {
					for (DBStoredModulesListBean dbModule: dbModules) {
						delete.put(dbModule, false);
						if (mg.containsKey(dbModule.getStrHash())) {
							StoredModule found = null;
							for (StoredModule sm: mg.get(dbModule.getStrHash())) {
								if (dbModule.getRecipieName() == null && sm.getEngineerModifications() == null ||  
										dbModule.getRecipieName() != null && sm.getEngineerModifications() != null && sm.getEngineerModifications().equalsIgnoreCase(dbModule.getRecipieName())) {
									delete.remove(dbModule);
									insert.remove(sm);
									found = sm;
									break;
								}
							}
							
							if (found != null) {
								mg.get(dbModule.getStrHash()).remove(found);
							}
							
						}
					}
				}
				
				for(DBStoredModulesListBean x: delete.keySet()) {
					DbAccess.storedModulesAccess.deleteByPrimaryKey(x.getStoredModuleId());
				}
				
				for(StoredModule x: insert.keySet()) {
					if (x.getStarSystem() != null) {
						ShipsDAO.insertStoredModule(pilot, x.getName(), x.getStarSystem(), x.getMarketID(), x.getEngineerModifications(), x.getLevel());
					}
				}
				//throw new RuntimeException();
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}

}
	