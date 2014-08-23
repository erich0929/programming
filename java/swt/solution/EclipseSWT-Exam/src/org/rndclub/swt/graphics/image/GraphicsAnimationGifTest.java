package org.rndclub.swt.graphics.image;

import java.io.InputStream;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

public class GraphicsAnimationGifTest {
	static ImageLoader loader;
	static ImageData[] imageDataArray;
	static final boolean useGIFBackground = false;
	static final int IW = 150;
	static final int IH = 179;

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsAnimationGif Test");

		shell.setSize(150, 179);
		shell.open();

		final GC shellGc = new GC(shell);
		final Color shellBackground = shell.getBackground();

		try {
			Class c = GraphicsTransparentIdeaTest.class;
			String path = "/org/rndclub/swt/res/images/ani-delta.gif";
			// String path = "/org/rndclub/swt/res/images/ani-dolphin.gif";
			InputStream stream = c.getResourceAsStream(path);

			loader = new ImageLoader();
			imageDataArray = loader.load(stream);

			if (imageDataArray.length > 1) {
				Thread animateThread = new Thread("Animation") {
					Image image = null;
					public void run() {
						/*
						 * Create an off-screen image to draw on, and fill it
						 * with the shell background.
						 */
						Image offImage = new Image(display,
								loader.logicalScreenWidth,
								loader.logicalScreenHeight);
						GC offGc = new GC(offImage);
						offGc.setBackground(shellBackground);
						offGc.fillRectangle(0, 0, loader.logicalScreenWidth,
								loader.logicalScreenHeight);

						try {
							/*
							 * Create the first image and draw it on the
							 * off-screen image.
							 */
							int imageDataIndex = 0;
							ImageData imageData = null;

							/*
							 * Now loop through the images, creating and drawing
							 * each one on the off-screen image before drawing
							 * it on the shell.
							 */
							boolean first = true;
							int repeatCount = loader.repeatCount;
							while (loader.repeatCount == 0 || repeatCount > 0) {
								if (first == false) {
									switch (imageData.disposalMethod) {
										case SWT.DM_FILL_BACKGROUND :
											/*
											 * Fill with the background color
											 * before drawing.
											 */
											Color bgColor = null;
											if (useGIFBackground
													&& loader.backgroundPixel != -1) {
												RGB rgb = imageData.palette
														.getRGB(loader.backgroundPixel);
												bgColor = new Color(display,
														rgb);
											}
											offGc.setBackground(bgColor != null
													? bgColor
													: shellBackground);
											offGc.fillRectangle(imageData.x,
													imageData.y,
													imageData.width,
													imageData.height);
											if (bgColor != null)
												bgColor.dispose();
											break;
										case SWT.DM_FILL_PREVIOUS :
											/*
											 * Restore the previous image before
											 * drawing.
											 */
											offGc.drawImage(image, 0, 0,
													imageData.width,
													imageData.height,
													imageData.x, imageData.y,
													imageData.width,
													imageData.height);
											break;
									}
								} else {
									first = false;
								}

								imageData = imageDataArray[imageDataIndex];
								if ((image != null) && (!image.isDisposed())) {
									image.dispose();
								}
								image = new Image(display, imageData);
								offGc.drawImage(image, 0, 0, imageData.width,
										imageData.height, imageData.x,
										imageData.y, imageData.width,
										imageData.height);

								/* Draw the off-screen image to the shell. */
								shellGc.drawImage(offImage, 0, 0, IW, IH, 0, 0,
										IW, IH);

								imageDataIndex = (imageDataIndex + 1)
										% imageDataArray.length;
								/*
								 * Sleep for the specified delay time (adding
								 * commonly-used slow-down fudge factors).
								 */
								try {
									int ms = imageData.delayTime * 10;
									if (ms < 20)
										ms += 30;
									if (ms < 30)
										ms += 10;
									Thread.sleep(ms);
								} catch (InterruptedException e) {
								}

								/*
								 * If we have just drawn the last image,
								 * decrement the repeat count and start again.
								 */
								if (imageDataIndex == imageDataArray.length - 1)
									repeatCount--;
							}
						} catch (SWTException e) {
							e.printStackTrace();
						} finally {
							if (offImage != null && !offImage.isDisposed()) {
								offImage.dispose();
							}
							if (offGc != null && !offGc.isDisposed()) {
								offGc.dispose();
							}
							if (image != null && !image.isDisposed()) {
								image.dispose();
							}
						}
					}
				};
				animateThread.setDaemon(true);
				animateThread.start();
			}
		} catch (SWTException e) {
			e.printStackTrace();
		}

		shell.setSize(IW + 8, IH + 36);

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
