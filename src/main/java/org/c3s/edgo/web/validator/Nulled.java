package org.c3s.edgo.web.validator;

public class Nulled implements Validator {

	private String text = "required";
	
	public Nulled() {
	}
	
	public Nulled(String text) {
		this.text = text;
	}

	@Override
	public String validate(Object value) {
		return (value != null)?text:null;
	}

}
