package org.rndclub.swt.graphics.image;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsImageStyleTest {
	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsImageStyle Test");

		Class c = GraphicsImageStyleTest.class;
		String path = "/org/rndclub/swt/res/images/idea.jpg";
		InputStream stream = c.getResourceAsStream(path);
		ImageData imageData = new ImageData(stream);
		final Image ideaImage = new Image(display, imageData);

		final Image disabledImage = new Image(display, ideaImage,
				SWT.IMAGE_DISABLE);
		GC gc = new GC(disabledImage);
		gc.drawText("DISABLE", 0, 0, false);
		gc.dispose();

		final Image grayImage = new Image(display, ideaImage, SWT.IMAGE_GRAY);
		gc = new GC(grayImage);
		gc.drawText("GRAY", 0, 0, false);
		gc.dispose();

		final Image copyImage = new Image(display, ideaImage, SWT.IMAGE_COPY);
		gc = new GC(copyImage);
		gc.drawText("COPY", 0, 0, false);
		gc.dispose();

		gc = new GC(ideaImage);
		gc.drawText("ORIGINAL", 0, 0, false);
		gc.dispose();

		Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.drawImage(ideaImage, 4, 4);
				e.gc.drawImage(disabledImage, 140, 4);
				e.gc.drawImage(grayImage, 280, 4);
				e.gc.drawImage(copyImage, 420, 4);
			}
		});

		shell.setSize(560, 132);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		ideaImage.dispose();
		disabledImage.dispose();
		grayImage.dispose();
		copyImage.dispose();

		display.dispose();
	}
}
