package org.rndclub.swt.graphics.intro;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsImageStreamTest {
	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsImageStream Test");

		Class c = GraphicsImageStreamTest.class;
		String path = "/org/rndclub/swt/res/images/idea.jpg";
		InputStream stream = c.getResourceAsStream(path);
		ImageData imageData = new ImageData(stream);
		final Image image = new Image(display, imageData);

		Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.drawImage(image, 0, 0);
			}
		});

		Rectangle bounds = image.getBounds();
		System.out.println("[GraphicsImageStreamTest-main] bounds : " + bounds);

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
