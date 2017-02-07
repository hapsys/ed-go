package org.c3s.edgo.utils;

import org.c3s.utils.RegexpUtils;

public class EDUtils {
	
	public static String cutFull(String source) {
		return RegexpUtils.preg_replace("~[^0-9a-z]~isu", source.toLowerCase(), "");
	}

	public static String cutSpaces(String source) {
		return RegexpUtils.preg_replace("~[\\s]~isu", source.toLowerCase(), "");
	}
	
	
	public static String getSystemUniq(String system) {
		return RegexpUtils.preg_replace("~[^0-9a-z]~isu", system.toLowerCase(), "");
	}
	
	public static String getStationUniq(String station) {
		return RegexpUtils.preg_replace("~[\\s]~isu", station.toLowerCase(), "");
	}
	
	public static String getBodyUniq(String station) {
		return RegexpUtils.preg_replace("~[\\s]+~isu", station.toLowerCase(), "_");
	}
	
	public static String getFactionUniq(String faction) {
		return RegexpUtils.preg_replace("~[^a-z0-9\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)_\\+\\=\\|\\/\\'\\\"`\\.\\,\\?-]~isu", faction.toLowerCase(), "");
	}
	
	public static String getPowerUniq(String power) {
		return RegexpUtils.preg_replace("~[\\s]~isu", power.toLowerCase(), "");
	}
	
	public static String getModuleUniq(String module) {
		String result = module.toLowerCase();
		result = RegexpUtils.preg_replace("~^[^a-z]*([a-z].+[a-z0-9])[^a-z]*$~isu", result, "$1");
		if (result.endsWith("_name")) {
			result = result.substring(0, result.length() - 5);
		}
		return result;
	}
}
