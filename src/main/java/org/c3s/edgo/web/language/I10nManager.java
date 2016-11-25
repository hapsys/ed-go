package org.c3s.edgo.web.language;

import org.c3s.annotations.Parameter;
import org.c3s.exceptions.XMLException;
import org.c3s.xml.XMLManager;

public class I10nManager {
	
	private static I10nHolder holder = I10nHolder.getInstance();
	
	public void init(@Parameter("content") String[] filename) throws XMLException {
		synchronized (this.getClass()) {
			if (filename != null) {
				boolean reload = false;
				for (String fn: filename) {
					if (!XMLManager.isDocumentLoaded(fn)) {
						reload = true;
						break;
					}
				}
				if (reload) {
					holder.clear();
					for (String fn: filename) {
						holder.load(XMLManager.getDocument(fn));
					}
				}
			}
		}
	}
}
