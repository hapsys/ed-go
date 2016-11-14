package org.c3s.edgo.web.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueChecker {
	
	Map<String, List<String>> errors = null;
	
	public boolean hasErrors() {
		return errors != null && errors.size() > 0;
	}

	public Map<String, List<String>> getErrors() {
		return errors;
	}

	public void validate(String name, String value, Validator... validators) {
		if (validators != null) {
			for (Validator validator: validators) {
				String text = validator.validate(value);
				if (text != null) {
					errors = addError(name, text, errors);
				}
			}
		}
	}
	
	public static Map<String, List<String>> addError(String name, String text) {
		return addError(name, text, null);
	}
	
	public static Map<String, List<String>> addError(String name, String text, Map<String, List<String>> errors) {
		Map<String, List<String>> result;
		if (errors != null) {
			result = new HashMap<String, List<String>>(errors);
		} else {
			result = new HashMap<String, List<String>>();
		}
		
		if (!result.containsKey(name)) {
			result.put(name, new ArrayList<String>());
		}
		
		result.get(name).add(text);
		
		return result;
	}
	
}
