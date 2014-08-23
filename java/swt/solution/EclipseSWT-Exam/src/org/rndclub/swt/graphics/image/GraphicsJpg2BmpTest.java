package org.rndclub.swt.graphics.image;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsJpg2BmpTest {
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);

		String fileName = "e:\\temp\\idea.jpg";
		ImageLoader loader = new ImageLoader();
		ImageData[] imageDataArray = loader.load(fileName);

		loader.data = imageDataArray;
		loader.save("e:\\temp\\idea.bmp", SWT.IMAGE_BMP);

		System.out.println("imageDataArray : " + imageDataArray.length);

		final Image image = new Image(display, imageDataArray[0]);
		System.out.println("image : " + image);

		Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.drawImage(image, 0, 0);
			}
		});

		Rectangle bounds = image.getBounds();
		canvas.setSize(bounds.width, bounds.height);

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		image.dispose();
		display.dispose();
	}
}
