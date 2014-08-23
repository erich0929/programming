package org.rndclub.swt.graphics.image;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

public class GraphicsImageLoaderJpgTest {
	public static void main(String[] args) {
		String fileName = "e:\\temp\\idea.jpg";
		ImageLoader loader = new ImageLoader();
		ImageData[] imageDataArray = loader.load(fileName);

		loader.data = imageDataArray;
		try {
			loader.save("e:\\temp\\idea(jpg-gif).gif", SWT.IMAGE_GIF);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(jpg-png).png", SWT.IMAGE_PNG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(jpg-bmp).bmp", SWT.IMAGE_BMP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			loader.save("e:\\temp\\idea(jpg-tif).tiff", SWT.IMAGE_TIFF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
