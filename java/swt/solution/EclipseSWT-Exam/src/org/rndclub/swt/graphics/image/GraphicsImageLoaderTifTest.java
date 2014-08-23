package org.rndclub.swt.graphics.image;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

public class GraphicsImageLoaderTifTest {
	public static void main(String[] args) {
		String fileName = "e:\\temp\\idea.tif";
		ImageLoader loader = new ImageLoader();
		ImageData[] imageDataArray = loader.load(fileName);

		loader.data = imageDataArray;
		try {
			loader.save("e:\\temp\\idea(tif-gif).gif", SWT.IMAGE_GIF);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(tif-png).png", SWT.IMAGE_PNG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(tif-jpg).jpg", SWT.IMAGE_JPEG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(tif-bmp).bmp", SWT.IMAGE_BMP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
