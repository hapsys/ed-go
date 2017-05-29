package org.c3s.edgo.web.validator;

import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;

public class UserExists implements Validator {

	private String text = "required";
	
	public UserExists() {
	}
	
	public UserExists(String text) {
		this.text = text;
	}

	@Override
	public String validate(Object value) {
		//return (value != null)?text:null;
		String result = "";
		try {
			result = DbAccess.usersAccess.getByEmail(value.toString()) == null?text:null;
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			result = e.getMessage();
		}
		
		return result;
	}

}
