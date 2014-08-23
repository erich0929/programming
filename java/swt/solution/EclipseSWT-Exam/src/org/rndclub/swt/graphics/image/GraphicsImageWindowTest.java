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

public class GraphicsImageWindowTest {
	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsImageFit Test");

		Class c = GraphicsImageWindowTest.class;
		InputStream stream = c
				.getResourceAsStream("/org/rndclub/swt/res/images/idea.jpg");
		ImageData imageData = new ImageData(stream);
		final Image image = new Image(display, imageData);

		final Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;

				gc.drawImage(image, 10, 10, 40, 60, 10, 10, 40, 60);
				gc.drawImage(image, 0, 0, 100, 80, 88, 74, 100, 80);
			}
		});

		shell.setSize(270, 220);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		image.dispose();
		display.dispose();
	}
}
