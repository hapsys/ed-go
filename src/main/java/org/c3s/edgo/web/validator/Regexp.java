package org.c3s.edgo.web.validator;

import org.c3s.utils.RegexpUtils;

public class Regexp implements Validator {

	private String text = "regexp";
	private String regexp = null;
	
	public Regexp(String regexp) {
		this.regexp = regexp;
	}
	
	public Regexp(String regexp, String text) {
		this(regexp);
		this.text = text;
	}

	@Override
	public String validate(Object value) {
		return value != null && !RegexpUtils.preg_match(regexp, value.toString(), null)?text:null;
	}

}
