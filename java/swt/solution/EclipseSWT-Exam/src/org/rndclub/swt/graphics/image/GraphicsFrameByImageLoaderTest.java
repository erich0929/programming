package org.rndclub.swt.graphics.image;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsFrameByImageLoaderTest {
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsFrameByImageLoader Test");

		Class c = GraphicsTransparentIdeaTest.class;
		String path = "/org/rndclub/swt/res/images/ani-delta.gif";
//		String path = "/org/rndclub/swt/res/images/ani-dolphin.gif";
		ImageLoader loader = new ImageLoader();
		InputStream stream = c.getResourceAsStream(path);
		final ImageData[] imageDataArray = loader.load(stream);

		final Image[] imageArray = new Image[imageDataArray.length];
		for (int i = 0; i < imageDataArray.length; i++) {
			ImageData imageData = imageDataArray[i];
			imageArray[i] = new Image(display, imageData);
		}

		Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				int x = 0;
				for (int i = 0; i < imageArray.length; i++) {
					gc.drawImage(imageArray[i], 0, 0, 150, 179, x, 0, 150, 179);
					x += imageArray[i].getBounds().width;
				}
			}
		});

		int w = loader.logicalScreenWidth;
		int h = 179;//loader.logicalScreenHeight;

		shell.setSize(w * imageArray.length+30, h+50);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		for (int i = 0; i < imageArray.length; i++) {
			imageArray[i].dispose();
		}

		display.dispose();
	}
}
