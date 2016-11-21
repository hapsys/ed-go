package org.c3s.edgo.companion;

import org.c3s.utils.RegexpUtils;

public class StarPort {
	public String name;
	
	public String getName() {
		if (name != null) {
			//return name.toLowerCase().replace("[\\s]", "");
			return RegexpUtils.preg_replace("~[\\s]~isu", name.toLowerCase(), "");
		}
		return null;
	}
}
