package org.c3s.edgo.web.language;

import java.util.HashMap;
import java.util.Map;

import org.c3s.xml.NodeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class I10nHolder {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(I10nHolder.class);
	
	private static I10nHolder instance = new I10nHolder();
	
	public static I10nHolder getInstance() {
		return instance;
	}
	
	private Map<String, Map<String, String>> holder = new HashMap<>();
	private Map<String, Map<String, String>> holder_nc = new HashMap<>();
	
	public void clear() {
		holder.clear();
		holder_nc.clear();
	}
	
	public void load(Document xml) {
		
		NodeSet list = new NodeSet(xml.getDocumentElement().getChildNodes());
		
		for (Node match : list) {
			if (!"match".equals(match.getNodeName())) {
				continue;
			}
			String name = ((Element)match).getAttribute("name");
			//logger.debug("Find match {}", name);
			if (!name.isEmpty()) {
				NodeSet matches = new NodeSet(match.getChildNodes());
				for (Node select : matches) {
					if (!"select".equals(select.getNodeName())) {
						continue;
					}
					String lang = ((Element)select).getAttribute("lang");
					//logger.debug("Find language {}", lang);
					if (!lang.isEmpty()) {
						if (!holder.containsKey(name)) {
							holder.put(name, new HashMap<String, String>());
							holder_nc.put(name.toLowerCase(), new HashMap<String, String>());
						}
						holder.get(name).put(lang, select.getTextContent());
						holder_nc.get(name.toLowerCase()).put(lang, select.getTextContent());
						//logger.debug("Append translate [{},{}]={}", name, lang, select.getTextContent());
					}
				}
			}
		}
	}
	
	public String get(String name, String lang) {
		return this.get(name, lang, true);
	}
	
	public String get(String name, String lang, boolean caseSensitive) {
		String result = name;
		Map<String, Map<String, String>> hld = caseSensitive?holder:holder_nc;
		String key = caseSensitive?name:name.toLowerCase();
		if (hld.get(key) != null && hld.get(key).get(lang) != null) {
			result = hld.get(name).get(lang);
		}
		return result;
	}
}
