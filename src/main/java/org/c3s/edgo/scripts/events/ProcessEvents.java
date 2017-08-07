package org.c3s.edgo.scripts.events;

import java.sql.SQLException;
import java.util.Properties;

import org.c3s.db.DBManager;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.event.EventDispatcherThreaded;
import org.c3s.edgo.event.EventProcessorThreaded;
import org.c3s.storage.ApplicationStorage;
import org.c3s.storage.StorageFactory;
import org.c3s.storage.StorageType;

public class ProcessEvents {

	public static void main(String[] args) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		
		Properties props = new Properties();
		//props.put("user", "root");
		//props.put("password", "root");
		//props.put("retainStatementAfterResultSetClose", true);
		//DBManager.getConnection("edgo", "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ed-go", props);
		props.put("user", "hapsys");
		props.put("password", "123467890");
		DBManager.getConnection("edgo", "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.0.10:3306/ed-go", props);
		
		// Clear events
		DbAccess.eventsAccess.updateClearEvents();
		// Register events
		EventDispatcherThreaded.registerEventPackage("org.c3s.edgo.event.impl");
		
		StorageFactory.register(StorageType.APPLICATION, new ApplicationStorage());
		
		new Thread(new EventProcessorThreaded()).start();
		/**
		while(true) {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				System.exit(-1);
			}
		}
		*/
	}

}
