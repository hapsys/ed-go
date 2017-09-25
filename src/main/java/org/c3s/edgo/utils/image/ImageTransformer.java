package org.c3s.edgo.utils.image;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageTransformer {

	private BufferedImage image = null; 
	
	public static ImageTransformer load(String filename) throws IOException {
		return load(new File(filename));
	}
	
	public static ImageTransformer load(File file) throws IOException {
		BufferedImage img = ImageIO.read(file);
		return new ImageTransformer(img);
	}

	public ImageTransformer(BufferedImage image) {
		this.image = image;
	}


	public BufferedImage getImage() {
		return image;
	}
	
	
	public void resize(int width, int height, boolean scale) {
		
		if (width == 0 || height == 0) {
			scale = false;
		}
		
		if (scale) {
			image = scale(width, height);
		} else {
			double xRatio = (double)width / image.getWidth();
			double yRatio = (double)height / image.getHeight();
			if (!(yRatio > 0) || xRatio > 0 && xRatio < yRatio) {
				image = scale(width, (int)(image.getHeight() * xRatio));
			} else if (!(xRatio > 0) || yRatio > 0 && yRatio < xRatio) {
				image = scale((int)(image.getWidth() * yRatio), height);
			} else if (xRatio > 0 && yRatio > 0) {
				image = scale(width, height);
			}
		}
		
	}
	
	private BufferedImage scale(int width, int height) {
		BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D gr2d = result.createGraphics();
		setRenderingHints(gr2d);
		AffineTransform at = AffineTransform.getScaleInstance((double)width/image.getWidth(), (double)height/image.getHeight());
		gr2d.drawRenderedImage(image, at);
		gr2d.dispose();
		return result;
	}
	
	public void crop(int width, int height) {
		if (width == 0 || height == 0) {
			resize(width, height, false);
		} else {
			
			BufferedImage temp = null;
			
			double xRatio = (double)width / image.getWidth();
			double yRatio = (double)height / image.getHeight();
			if (xRatio > yRatio) {
				temp = scale(width, (int)(image.getHeight() * xRatio));
			} else if (yRatio > xRatio) {
				temp = scale((int)(image.getWidth() * yRatio), height);
			} else if (xRatio > 0 && yRatio > 0) {
				image = scale(width, height);
			}
			
			
			
			if (temp != null) {
				
				int x = 0, y = 0;
				
				if (width < temp.getWidth()) {
					x = - (temp.getWidth() - width) / 2;
				} else {
					y = - (temp.getHeight() - height) / 2;
				}
				
				BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D gr2d = result.createGraphics();
				setRenderingHints(gr2d);
				gr2d.drawImage(temp, null, x, y);
				gr2d.dispose();
				
				image = result;
			}
		}
	}
	
	private void setRenderingHints(final Graphics2D graphics) {
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
		graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
		graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
		graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
	}	
}
