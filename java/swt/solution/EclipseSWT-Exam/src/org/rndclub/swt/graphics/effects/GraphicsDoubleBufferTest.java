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

public class GraphicsDoubleBufferTest {
	public static final int IMAGE_MAX = 4;

	static int frameIndex = 0;
	static Image frameImages[] = null;
	static Image bufferImage = null;

	public static void main(String[] args) {
		final Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsImage Test");

		frameImages = new Image[IMAGE_MAX];
		for (int i = 0; i < frameImages.length; i++) {
			Class c = GraphicsDoubleBufferTest.class;
			InputStream stream = c.getResourceAsStream("ani-" + (i + 1)
					+ ".jpg");
			ImageData imageData = new ImageData(stream);
			frameImages[i] = new Image(display, imageData);
		}

		Rectangle bounds = frameImages[0].getBounds();
		final int IW = bounds.width;
		final int IH = bounds.height;

		final Canvas canvas = new Canvas(shell, SWT.NO_BACKGROUND);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (display.isDisposed()) {
					return;
				}
				GC gc = e.gc;

				Rectangle bounds = canvas.getBounds();
				int cw = bounds.width;
				int ch = bounds.height;
				if (bufferImage == null) {
					bufferImage = new Image(display, cw, ch);
				}

				GC bufGc = new GC(bufferImage);
				bufGc.fillRectangle(0, 0, cw, ch);
				bufGc.drawImage(frameImages[frameIndex], 0, 0, IW, IH, 4, 4,
						cw - 8, ch - 8);
				bufGc.dispose();

				gc.drawImage(bufferImage, 0, 0);
			}
		});

		shell.setSize(656, 522);

		Thread aniThread = new Thread() {
			public void run() {
				while (true) {
					frameIndex++;
					if (frameIndex >= frameImages.length) {
						frameIndex = 0;
					}
					if (!display.isDisposed()) {
						display.asyncExec(new Runnable() {
							public void run() {
								canvas.redraw();
							}
						});
					}

					try {
						Thread.sleep(600);
					} catch (InterruptedException e) {
						break;
					}
				}
			}
		};

		shell.open();
		aniThread.start();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		aniThread.stop();

		for (int i = 0; i < frameImages.length; i++) {
			frameImages[i].dispose();
		}
		display.dispose();
	}
}
