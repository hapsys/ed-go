package org.c3s.edgo.event.impl;
	
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBImageConfigsBean;
import org.c3s.edgo.common.beans.DBImageTumbnailsBean;
import org.c3s.edgo.common.beans.DBImagesBean;
import org.c3s.edgo.common.beans.DBLocationHistoryBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBStationHistoryBean;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ScreenshotBean;
import org.c3s.edgo.utils.image.ImageTransformer;
import org.c3s.edgo.utils.image.ImageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Screenshot extends AbstractJournalEvent<ScreenshotBean> {

	public static String SCREENSHOT_DIRECTORY = "/var/lib/www/screenshot";
	public static String DEFAULT_FORMAT = "PNG";
	public static String DEFAULT_TYPE = "screenshot";
	
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Screenshot.class);
	
	{
		beanClass = ScreenshotBean.class;
	}
	
	protected void processBean(ScreenshotBean bean) {
		
		try {
			/**
			 * Set current pilot ship
			 */
			DBPilotsBean current = getCurrent();
			if (current != null && bean.getSrc() != null && !bean.getSrc().isEmpty()) {

				DBLocationHistoryBean prevLocation = DbAccess.locationHistoryAccess.getLastLocation(current.getPilotId(), new Timestamp(bean.getTimestamp().getTime()));
				DBStationHistoryBean prevStation = DbAccess.stationHistoryAccess.getLastStation(current.getPilotId(), new Timestamp(bean.getTimestamp().getTime()));

				if (prevLocation != null && prevStation != null && prevStation.getStationTime().compareTo(prevLocation.getLocationTime()) < 0) {
					prevStation = null;
				}
				
				final DBStationHistoryBean station = prevStation; 
				// Create new image
				DBImagesBean image = new DBImagesBean()
					.setCreateTime(new Timestamp(bean.getTimestamp().getTime()))
					.setPilotId(current.getPilotId())
					.setWidth(bean.getWidth())
					.setHeight(bean.getHeight())
					.setType(DEFAULT_TYPE)
					.setIsActive(0)
					.setLocationId(prevLocation == null? null:prevLocation.getLocationId())
					.setStationHistoryId(station == null? null:station.getStationHistoryId());
				
				DbAccess.imagesAccess.insert(image);
				
				// Create ditectory
				String pilotDir = "pilot" + String.format("%10s", "" + current.getPilotId()).replace(' ', '0'); 
				String fileName = String.format("%10s", "" + image.getImageId()).replace(' ', '0'); 
				String imageName = fileName + "." + DEFAULT_FORMAT.toLowerCase(); 
				File pilotDirFile = new File(SCREENSHOT_DIRECTORY + "/" + pilotDir);
				if (!pilotDirFile.exists()) {
					pilotDirFile.mkdirs();
				}
				
				BufferedImage img = ImageUtils.byteArrayToImage(Base64.getDecoder().decode(bean.getSrc())); 
				ImageUtils.imageSave(img , DEFAULT_FORMAT, SCREENSHOT_DIRECTORY + "/" + pilotDir + "/" + imageName); 
				
				// Get auto configuration
				List<DBImageConfigsBean> configs = DbAccess.imageConfigsAccess.getActiveAutoConfigurations();
				if (configs != null) {
					for (DBImageConfigsBean config: configs) {
						File configDirFile = new File(SCREENSHOT_DIRECTORY + "/" + pilotDir + "/" + config.getConfigName());
						if (!configDirFile.exists()) {
							configDirFile.mkdirs();
						}
						
						ImageTransformer it = new ImageTransformer(img);
						
						if (config.getCanCrop().intValue() > 0) {
							it.crop(config.getMaxWidth().intValue(), config.getMaxHeight().intValue());
						} else {
							it.resize(config.getMaxWidth().intValue(), config.getMaxHeight().intValue(), config.getCanScale().intValue() > 0);
						}
						
						DBImageTumbnailsBean tbn = new DBImageTumbnailsBean()
							.setCreateTime(new Timestamp(new Date().getTime()))
							.setConfigId(config.getConfigId())
							.setImageId(image.getImageId())
							.setWidth((long)it.getImage().getWidth())
							.setHeight((long)it.getImage().getHeight());
						
						DbAccess.imageTumbnailsAccess.insert(tbn);
						
						ImageUtils.imageSave(it.getImage(), config.getType(), configDirFile.getPath() + "/" + fileName + "." + config.getType().toLowerCase());
					}
				}
				// Set image active
				DbAccess.imagesAccess.updateActivate(image.getImageId());
			}
		} catch (Exception e) {
			//e.printStackTrace();
			//System.exit(0);
			throw new RuntimeException(e);
		} 
		
		
	}

}
	