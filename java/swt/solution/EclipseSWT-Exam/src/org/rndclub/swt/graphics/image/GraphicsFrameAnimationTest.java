package org.rndclub.swt.graphics.image;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsFrameAnimationTest {
	static int frameIndex = 0;
	static Image frameImages[] = null;
	static Image bufferImage = null;

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsFrameAnimation Test");

		ImageLoader loader = new ImageLoader();

		Class c = GraphicsTransparentIdeaTest.class;
		String path = "/org/rndclub/swt/res/images/ani-dolphin.gif";
		InputStream stream = c.getResourceAsStream(path);
		final ImageData[] imageDataArray = loader.load(stream);

		frameImages = new Image[imageDataArray.length];
		for (int i = 0; i < imageDataArray.length; i++) {
			ImageData imageData = imageDataArray[i];
			frameImages[i] = new Image(display, imageData);
		}

		final Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (display.isDisposed()) {
					return;
				}
				GC gc = e.gc;

				Rectangle bounds = canvas.getBounds();
				int width = bounds.width;
				int height = bounds.height;
				if (bufferImage == null) {
					bufferImage = new Image(display, width, height);
				}
				GC bufGc = new GC(bufferImage);
				bufGc.fillRectangle(0, 0, width, height);
				bufGc.drawImage(frameImages[frameIndex], 0, 0);
				bufGc.dispose();

				gc.drawImage(bufferImage, 0, 0);
			}
		});

		int w = loader.logicalScreenWidth;
		int h = loader.logicalScreenHeight;
		canvas.setSize(w, h);

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
								if (!canvas.isDisposed()) {
									canvas.redraw();
								}
							}
						});
					}

					try {
						Thread.sleep(imageDataArray[frameIndex].delayTime * 10);
					} catch (InterruptedException e) {
						break;
					}
				}
			}
		};

		shell.pack();
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
