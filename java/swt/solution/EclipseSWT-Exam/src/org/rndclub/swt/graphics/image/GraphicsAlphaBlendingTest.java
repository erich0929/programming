package org.rndclub.swt.graphics.image;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsAlphaBlendingTest {
	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsAlphaBlending Test");

		Class c = GraphicsAlphaBlendingTest.class;
		String path = "/org/rndclub/swt/res/images/sheep.jpg";
		InputStream stream = c.getResourceAsStream(path);
		ImageData sheepData = new ImageData(stream);
		final Image backImage = new Image(display, sheepData);

		path = "/org/rndclub/swt/res/images/idea.jpg";
		stream = c.getResourceAsStream(path);

		ImageData ideaData = new ImageData(stream);
		final Image fullImage = new Image(display, ideaData);

		ideaData.alpha = 128;
		final Image halfImage = new Image(display, ideaData);

		ideaData.alpha = 64;
		final Image quarterImage = new Image(display, ideaData);

		Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.drawImage(backImage, 0, 0);
				e.gc.drawImage(fullImage, 30, 90);
				e.gc.drawImage(halfImage, 170, 90);
				e.gc.drawImage(quarterImage, 310, 90);
			}
		});

		shell.setSize(480, 320);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		backImage.dispose();
		fullImage.dispose();
		halfImage.dispose();
		quarterImage.dispose();
		display.dispose();
	}
}
