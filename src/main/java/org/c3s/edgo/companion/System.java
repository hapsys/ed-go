package org.c3s.edgo.companion;

import org.c3s.utils.RegexpUtils;

public class System {
	public String name;
	
	public String getName() {
		if (name != null) {
			return RegexpUtils.preg_replace("~[^0-9a-z]~isu", name.toLowerCase(), "");
			//name.toLowerCase().replace("", ""); 
		}
		return null;
	}
}
