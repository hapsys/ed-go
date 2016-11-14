package org.c3s.edgo.web;

import javax.servlet.ServletRequest;

import org.c3s.annotations.Parameter;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.exceptions.SkipSubLevelsExeption;
import org.c3s.utils.HTTPUtils;

public class AjaxCheker extends GeneralController {

	public void isAjax(@Parameter("tag") String tag, ServletRequest request) throws SkipSubLevelsExeption {
		if (!HTTPUtils.isAjax(request)) {
			throw new SkipSubLevelsExeption();
		}
		
		if (tag != null) {
			ContentObject.getInstance().setData(tag, wrapError(null, "Forbidden", 403));
		}
	}

	public void isNotAjax(ServletRequest request) throws SkipSubLevelsExeption {
		if (HTTPUtils.isAjax(request)) {
			throw new SkipSubLevelsExeption();
		}
	}
}
