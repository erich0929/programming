package org.rndclub.swt.graphics.image;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsImageDataTest {
	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsImageData Test");

		Class c = GraphicsImageDataTest.class;
		String path = "/org/rndclub/swt/res/images/idea.jpg";
		InputStream stream = c.getResourceAsStream(path);
		ImageData ideaImageData = new ImageData(stream);

		int redMask = ideaImageData.palette.redMask;
		int blueMask = ideaImageData.palette.blueMask;
		int greenMask = ideaImageData.palette.greenMask;

		int[] lineData = new int[ideaImageData.width];
		for (int y = 0; y < ideaImageData.height; y++) {
			ideaImageData.getPixels(0, y, ideaImageData.width, lineData, 0);
			// Analyze each pixel value in the line
			for (int x = 0; x < lineData.length; x++) {
				// Extract the red, green and blue component
				int pixelValue = lineData[x];
				int r = pixelValue & redMask;
				int g = (pixelValue & greenMask) >> 8;
				int b = (pixelValue & blueMask) >> 16;
				if (r > 230 && g > 230 && b > 150) {
					ideaImageData.setPixel(x, y, 0xFFFFFF);
				}
			}
		};

		ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[]{ideaImageData};
		try {
			loader.save("e:\\temp\\idea_transp.jpg", SWT.IMAGE_JPEG);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int whitePixel = ideaImageData.palette.getPixel(new RGB(255, 255, 255));
		ideaImageData.transparentPixel = whitePixel;
		final Image image = new Image(display, ideaImageData);

		Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.drawImage(image, 4, 4);
			}
		});

		shell.setSize(150, 135);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		image.dispose();
		display.dispose();
	}
}
