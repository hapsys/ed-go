package org.c3s.edgo.web.common;

import org.c3s.annotations.Controller;
import org.c3s.annotations.CurrentUrl;
import org.c3s.content.ContentObject;

@Controller
public class CurrentURL {

	public void getCurrentURL(@CurrentUrl String curentUrl) {
		ContentObject.getInstance().setFixedParameters("current_url", curentUrl);
	}
	
}
