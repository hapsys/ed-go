/**
 * 
 */
package org.c3s.edgo.scripts.check;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Properties;

import org.c3s.db.DBManager;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBEventsBean;
import org.c3s.edgo.event.EventDispatcherThreaded;
import org.c3s.edgo.event.EventMd5Transform;
import org.c3s.edgo.event.EventsRegister;
import org.c3s.edgo.event.JournalEvent;
import org.c3s.storage.ApplicationStorage;
import org.c3s.storage.StorageFactory;
import org.c3s.storage.StorageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author admin
 *
 */
public class ProcessSingleEvent {

	private static Logger logger = LoggerFactory.getLogger(EventDispatcherThreaded.class);
	
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		// TODO Auto-generated method stub

		Properties props = new Properties();
		//props.put("user", "root");
		//props.put("password", "root");
		//props.put("retainStatementAfterResultSetClose", true);
		//DBManager.getConnection("edgo", "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ed-go", props);
		props.put("user", "hapsys");
		props.put("password", "123467890");
		DBManager.getConnection("edgo", "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.0.10:3306/ed-go", props);
		
		// Register events
		EventsRegister.registerEventPackage("org.c3s.edgo.event.impl");
		
		StorageFactory.register(StorageType.APPLICATION, new ApplicationStorage());
		
		// Process event
		DBEventsBean evt = DbAccess.eventsAccess.getByPrimaryKey(new BigInteger("1177492943656284"));
		
		EventMd5Transform.eventTransformMD5(evt);
		String eventTime = evt.getEventJson().substring(15, 35);
		
		Class<? extends JournalEvent> eventClass = EventsRegister.getEventClass(evt.getEventName(), eventTime);
		
		if (eventClass != null) {
			JournalEvent event = null;
			try {
				event = eventClass.newInstance();
				event.process(evt);
			} catch (InstantiationException | IllegalAccessException e) {
				logger.warn("Create instance fail for class \"{}\"", eventClass.getName(), e);
			}
		} else {
			logger.warn("No class found for event \"{}\"", evt.getEventName());
		}
		
	}

}
