package org.rndclub.swt.graphics.image;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

public class GraphicsImageLoaderGifTest {
	public static void main(String[] args) {
		String fileName = "e:\\temp\\idea.gif";
		ImageLoader loader = new ImageLoader();
		ImageData[] imageDataArray = loader.load(fileName);

		loader.data = imageDataArray;
		try {
			loader.save("e:\\temp\\idea(gif-png).png", SWT.IMAGE_PNG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(gif-jpg).jpg", SWT.IMAGE_JPEG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(gif-bmp).bmp", SWT.IMAGE_BMP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(gif-tif).tiff", SWT.IMAGE_TIFF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
