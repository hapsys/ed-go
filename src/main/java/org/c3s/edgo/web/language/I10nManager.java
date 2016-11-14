package org.c3s.edgo.web.language;

import org.c3s.annotations.Parameter;
import org.c3s.exceptions.XMLException;
import org.c3s.xml.XMLManager;

public class I10nManager {
	
	private static I10nHolder holder = null;
	
	public void init(@Parameter("content") String filename) throws XMLException {
		synchronized (this.getClass()) {
			if (filename != null && holder == null) {
				holder = I10nHolder.getInstance();
				holder.load(XMLManager.getDocument(filename));
			}
		}
	}
}
