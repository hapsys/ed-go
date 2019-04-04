package org.c3s.edgo.scripts.check;

import org.c3s.edgo.event.impl.beans.LocationBean;
import org.c3s.exceptions.FileSystemException;
import org.c3s.utils.FileSystem;
import org.c3s.utils.JSONUtils;

public class JsonTest {

	public static void main(String[] args) throws FileSystemException {
		// TODO Auto-generated method stub
		String json = FileSystem.fileGetContents("/error2.json");
		
		Class<LocationBean> clazz = LocationBean.class; 
		
		LocationBean bean = JSONUtils.fromJSON(json, clazz);
		
		System.out.println(bean.getSystemFaction().getName());
	}

}
