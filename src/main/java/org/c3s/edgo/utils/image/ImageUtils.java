package org.c3s.edgo.utils.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {

	public static BufferedImage byteArrayToImage(byte[] source) throws IOException {
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(source));
		return image;
	}

	public static void imageSave(BufferedImage image, String format, String filename) throws IOException {
		ImageIO.write(image, format, new File(filename));
	}
	
	public static void imageSave(byte[] image, String format, String filename) throws IOException {
		ImageIO.write(byteArrayToImage(image), format, new File(filename));
	}
	
}
