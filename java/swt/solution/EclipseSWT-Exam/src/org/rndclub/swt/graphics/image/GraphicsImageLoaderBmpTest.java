package org.rndclub.swt.graphics.image;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

public class GraphicsImageLoaderBmpTest {
	public static void main(String[] args) {
		String fileName = "e:\\temp\\idea.bmp";
		ImageLoader loader = new ImageLoader();
		ImageData[] imageDataArray = loader.load(fileName);

		loader.data = imageDataArray;
		try {
			loader.save("e:\\temp\\idea(bmp-gif).gif", SWT.IMAGE_GIF);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(bmp-png).png", SWT.IMAGE_PNG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(bmp-jpg).jpg", SWT.IMAGE_JPEG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(bmp-tif).tiff", SWT.IMAGE_TIFF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
