package org.c3s.edgo.web.validator;

public class Required implements Validator {

	private String text = "required";
	
	public Required() {
	}
	
	public Required(String text) {
		this.text = text;
	}

	@Override
	public String validate(String value) {
		return (value == null || value.length() == 0)?text:null;
	}

}
