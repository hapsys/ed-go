package org.c3s.edgo.scripts.events;

import java.sql.SQLException;
import java.util.Properties;

import org.c3s.db.DBManager;
import org.c3s.edgo.event.EventDispatcher;
import org.c3s.edgo.event.EventProcessor;
import org.c3s.storage.ApplicationStorage;
import org.c3s.storage.StorageFactory;
import org.c3s.storage.StorageType;

public class ProcessEvents {

	public static void main(String[] args) throws SQLException {
		
		Properties props = new Properties();
		props.put("user", "root");
		props.put("password", "root");
		DBManager.getConnection("edgo", "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ed-go", props);
		
		
		EventDispatcher.registerEventPackage("org.c3s.edgo.event.impl");
		
		StorageFactory.register(StorageType.APPLICATION, new ApplicationStorage());
		
		new Thread(new EventProcessor()).start();
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
