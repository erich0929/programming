package org.rndclub.swt.graphics.effects;

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

public class GraphicsClippingTest {
	public static void main(String[] args) {
		final Display display = new Display();

		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsClipping Test");

		Class c = GraphicsHighlightTest.class;
		InputStream stream = c
				.getResourceAsStream("/org/rndclub/swt/res/images/clover.jpg");
		ImageData imageData = new ImageData(stream);
		final Image image = new Image(display, imageData);
		Rectangle ibounds = image.getBounds();
		final int iw = ibounds.width;
		final int ih = ibounds.height;

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle cbounds = canvas.getBounds();

				int w = cbounds.width;
				int h = cbounds.height;

				float r = (float) w / (float) iw;
				int cx = (int) ((float) 234 * r);
				int cy = (int) ((float) 112 * r);
				int cw = (int) ((float) 1644 * r);
				int ch = (int) ((float) 663 * r);

				gc.setClipping(cx, cy, cw, ch);
				gc.drawImage(image, 0, 0, iw, ih, 0, 0, w, h);
			}
		});

		shell.setSize(320, 240);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		image.dispose();
		display.dispose();
	}
}
