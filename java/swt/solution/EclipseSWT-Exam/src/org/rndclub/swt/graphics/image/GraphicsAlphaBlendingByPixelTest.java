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

public class GraphicsAlphaBlendingByPixelTest {
	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsAlphaBlendingByPixel Test");

		Class c = GraphicsAlphaBlendingTest.class;
		String path = "/org/rndclub/swt/res/images/sheep.jpg";
		InputStream stream = c.getResourceAsStream(path);
		ImageData sheepData = new ImageData(stream);
		final Image backImage = new Image(display, sheepData);

		path = "/org/rndclub/swt/res/images/idea.jpg";
		stream = c.getResourceAsStream(path);
		ImageData ideaData = new ImageData(stream);

		int width = ideaData.width;
		int height = ideaData.height;
		byte[] alphaData = new byte[height * width];
		int i = 0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				alphaData[i++] = (byte) ((255 * y) / height);
			}
		}
		ideaData.alphaData = alphaData;
		final Image ideaImage = new Image(display, ideaData);

		Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.drawImage(backImage, 0, 0);
				gc.drawImage(ideaImage, 40, 40);
			}
		});

		shell.setSize(210, 180);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		backImage.dispose();
		ideaImage.dispose();
		display.dispose();
	}
}
