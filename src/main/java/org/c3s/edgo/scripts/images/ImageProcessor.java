package org.c3s.edgo.scripts.images;

import java.util.Properties;

import org.c3s.db.DBManager;
import org.c3s.edgo.utils.image.ImageTransformer;
import org.c3s.edgo.utils.image.ImageUtils;

public class ImageProcessor {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.put("user", "hapsys");
		props.put("password", "123467890");
		DBManager.getConnection("edgo", "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.0.10:3306/ed-go", props);
		
		String dir = "/var/lib/www/screenshot/pilot0000000001";
		ImageTransformer it = ImageTransformer.load(dir + "/0000000001.png");
	
		Long w = 200L, h = 200L;
		it.crop(w.intValue(), h.intValue());
		
		ImageUtils.imageSave(it.getImage(), "PNG", dir + "/test.png");
	}

}
