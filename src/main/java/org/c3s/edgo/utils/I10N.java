package org.c3s.edgo.utils;

import org.c3s.content.ContentObject;
import org.c3s.edgo.web.language.I10nHolder;

public class I10N {
	
	public static String tr(String source, String lang, boolean caseSensitive) {
		if (lang == null) {
			lang = (String)ContentObject.getInstance().getFixedParameter("language_id");
		}
		return I10nHolder.getInstance().get(source, lang, caseSensitive);
	}
	
	public static String tr(String source, boolean caseSensitive) {
		return tr(source, null, caseSensitive);
	}
	
	public static String tr(String source, String lang) {
		return tr(source, lang, true);
	}
	
	public static String tr(String source) {
		return tr(source, null, true);
	}
}
