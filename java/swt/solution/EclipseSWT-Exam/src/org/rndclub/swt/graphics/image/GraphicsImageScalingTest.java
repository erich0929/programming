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

public class GraphicsImageScalingTest {
	static int imageNumber;

public static void main(String[] args) {
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsImageScaling Test");

		Class c = GraphicsTransparentIdeaTest.class;
		String path = "/org/rndclub/swt/res/images/idea.gif";
		InputStream stream = c.getResourceAsStream(path);
		final Image image = new Image(display, stream);

		int w = image.getBounds().width / 2;
		int h = image.getBounds().height / 2;
		ImageData imageData = image.getImageData().scaledTo(w, h);
		final Image scaled050 = new Image(display, imageData);

		w = image.getBounds().width * 2;
		h = image.getBounds().height * 2;
		imageData = image.getImageData().scaledTo(w, h);
		final Image scaled200 = new Image(display, imageData);

		w = image.getBounds().width;
		h = image.getBounds().height;
		final Image scaledGC200 = new Image(display, w * 2, h * 2);
		GC gc = new GC(scaledGC200);
		gc.drawImage(image, 0, 0, w, h, 0, 0, w * 2, h * 2);
		gc.dispose();

		Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;

				int w = image.getBounds().width;
				int h = image.getBounds().height;

				gc.drawImage(image, 0, 0, w, h, 0, 0, w / 2, h / 2);
				gc.drawImage(scaled050, 100, 0);

				gc.drawImage(scaledGC200, 0, 75);
				gc.drawImage(scaled200, 250, 75);
			}
		});

		shell.setSize(520, 300);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		scaled050.dispose();
		scaledGC200.dispose();
		scaled200.dispose();
		display.dispose();
	}}
