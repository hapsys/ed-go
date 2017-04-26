package org.c3s.edgo.web.utilites;

import java.sql.SQLException;
import java.util.List;

import org.c3s.annotations.Parameter;
import org.c3s.annotations.ParameterRequest;
import org.c3s.content.ContentObject;
import org.c3s.dispatcher.RedirectControlerInterface;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBSystemsInBoxBean;
import org.c3s.edgo.common.beans.DBSystemsSearchBean;
import org.c3s.edgo.web.validator.Result;
import org.c3s.web.redirect.DropRedirect;

public class Systems {

	public void getSystemsNearCoordiantes(@ParameterRequest("showdate") Float x, @ParameterRequest("showdate") Float y, @ParameterRequest("showdate") Float z, 
			@ParameterRequest("showdate") Float scale, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		x = x == null?0f:x;
		y = y == null?0f:y;
		z = z == null?0f:z;
		scale = scale == null?0f:scale;
		
		List<DBSystemsInBoxBean> systems = DbAccess.systemsAccess.getSystemsInBox(x - scale, x + scale, y - scale, y + scale, z - scale, z + scale);

		ContentObject.getInstance().setData(tag, new Result().put("systems", systems).get());
		redirect.setRedirect(new DropRedirect());
		
	}
	
	
	public void getSystemByPatiallyName(@ParameterRequest("system") String str, @Parameter("tag") String tag, RedirectControlerInterface redirect) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		//System.out.println("HERE");
		List<DBSystemsSearchBean> systems = null;
		if (str != null && str.length() > 0) {
			str = str.toLowerCase() + '%';
			systems = DbAccess.systemsAccess.getSystemsSearch(str);
		}
		ContentObject.getInstance().setData(tag, new Result().put("systems", systems).get());
		redirect.setRedirect(new DropRedirect());
	}
}
