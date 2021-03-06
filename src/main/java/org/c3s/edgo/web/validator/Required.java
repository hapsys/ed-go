package org.c3s.edgo.web.validator;

public class Required implements Validator {

	private String text = "required";
	
	public Required() {
	}
	
	public Required(String text) {
		this.text = text;
	}

	@Override
	public String validate(Object value) {
		return (value == null || value.toString().length() == 0)?text:null;
	}

}
