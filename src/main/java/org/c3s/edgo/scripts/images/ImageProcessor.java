package org.c3s.edgo.scripts.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Properties;

import org.c3s.db.DBManager;
import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBImageConfigsBean;
import org.c3s.edgo.common.beans.DBImagesBean;
import org.c3s.edgo.event.impl.Screenshot;
import org.c3s.edgo.utils.image.ImageTransformer;
import org.c3s.edgo.utils.image.ImageUtils;

public class ImageProcessor {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.put("user", "hapsys");
		props.put("password", "123467890");
		DBManager.getConnection("edgo", "com.mysql.cj.jdbc.Driver", "jdbc:mysql://192.168.0.10:3306/ed-go", props);
		
		List<DBImagesBean> images = DbAccess.imagesAccess.getActiveImages();
		
		if (images != null) {
			for (DBImagesBean image: images) {
				
				String pilotDir = "pilot" + String.format("%10s", "" + image.getPilotId()).replace(' ', '0'); 
				String fileName = String.format("%10s", "" + image.getImageId()).replace(' ', '0'); 
				String imageName = fileName + "." + Screenshot.DEFAULT_FORMAT.toLowerCase(); 
				File pilotDirFile = new File(Screenshot.SCREENSHOT_DIRECTORY + "/" + pilotDir);
				if (!pilotDirFile.exists()) {
					pilotDirFile.mkdirs();
				}

				try {
					BufferedImage img = ImageTransformer.load(new File(pilotDirFile, imageName)).getImage();
					
					// Get auto configuration
					List<DBImageConfigsBean> configs = DbAccess.imageConfigsAccess.getActiveAutoConfigurations();
					if (configs != null) {
						for (DBImageConfigsBean config: configs) {
							File configDirFile = new File(Screenshot.SCREENSHOT_DIRECTORY + "/" + pilotDir + "/" + config.getConfigName());
							if (!configDirFile.exists()) {
								configDirFile.mkdirs();
							}
							
							ImageTransformer it = new ImageTransformer(img);
							
							if (config.getCanCrop().intValue() > 0) {
								it.crop(config.getMaxWidth().intValue(), config.getMaxHeight().intValue());
							} else {
								it.resize(config.getMaxWidth().intValue(), config.getMaxHeight().intValue(), config.getCanScale().intValue() > 0);
							}
							
							/*
							DBImageTumbnailsBean tbn = new DBImageTumbnailsBean()
								.setConfigId(config.getConfigId())
								.setImageId(image.getImageId())
								.setWidth((long)it.getImage().getWidth())
								.setHeight((long)it.getImage().getHeight());
							
							DbAccess.imageTumbnailsAccess.insert(tbn);
							*/
							
							ImageUtils.imageSave(it.getImage(), config.getType(), configDirFile.getPath() + "/" + fileName + "." + config.getType().toLowerCase());
						}
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
