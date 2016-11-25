package org.c3s.edgo.web.servlets;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.c3s.db.DBManager;
import org.c3s.edgo.event.EventDispatcher;
import org.c3s.edgo.event.EventProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class EventServlet extends HttpServlet {

	private static Logger logger = LoggerFactory.getLogger(EventServlet.class);
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		logger.info("Event servlet starting");
		
		boolean init = false;
		try {
			while(!init) {
				try {
					if (DBManager.getConnection("edgo") != null) {
						init = true;
						break;
					}
					logger.info("Waiting for database init...");
					Thread.sleep(5000);
				} catch (SQLException e) {
					Thread.sleep(5000);
				}
			}
		} catch (InterruptedException e1) {
			throw new ServletException(e1);
		}
		
		EventDispatcher.registerEventPackage("org.c3s.edgo.event.impl");
		new Thread(new EventProcessor()).start();
		
		logger.info("Event servlet stopping");
	}
}
