package org.rndclub.swt.graphics.effects;

import java.io.InputStream;
import java.util.Random;

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

public class GraphicsHighlightTest {
	static boolean tflag = true;

	public static void main(String[] args) {
		final Display display = new Display();

		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsHighlight Test");

		Class c = GraphicsClippingTest.class;
		InputStream stream = c
				.getResourceAsStream("/org/rndclub/swt/res/images/food.jpg");
		ImageData imageData = new ImageData(stream);
		final Image image = new Image(display, imageData);
		Rectangle ibounds = image.getBounds();
		final int iw = ibounds.width;
		final int ih = ibounds.height;

		final Random random = new Random();

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				Rectangle cbounds = canvas.getBounds();

				int w = cbounds.width;
				int h = cbounds.height;

				int cx = (int) ((random.nextInt() % w) * 0.75);
				if (cx < 0) {
					cx = -cx;
				}
				int cy = (int) ((random.nextInt() % h) * 0.75);
				if (cy < 0) {
					cy = -cy;
				}

				int cw = (cx * 4) % 200;
				if (cw >= w) {
					cw = w - cx - 1;
				}
				int ch = (cy * 4) % 200;
				if (ch >= h) {
					ch = h - cy - 1;
				}

				if ((cw > 0) && (ch > 0)) {
					gc.setClipping(cx, cy, cw, ch);
				}
				gc.drawImage(image, 0, 0, iw, ih, 0, 0, w, h);
			}
		});

		Thread aniThread = new Thread() {
			public void run() {
				while (tflag == true) {
					if (!display.isDisposed()) {
						display.asyncExec(new Runnable() {
							public void run() {
								if (!canvas.isDisposed()) {
									canvas.redraw();
								}
							}
						});
					}

					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						break;
					}
				}
			}
		};

		shell.setSize(320, 240);
		shell.open();

		aniThread.start();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		tflag = false;
		image.dispose();
		display.dispose();
	}
}
