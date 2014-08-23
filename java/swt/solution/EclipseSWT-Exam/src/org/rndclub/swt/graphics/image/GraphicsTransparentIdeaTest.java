package org.rndclub.swt.graphics.image;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsTransparentIdeaTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsTransparerIdea Test");

		Class c = GraphicsTransparentIdeaTest.class;
		String path = "/org/rndclub/swt/res/images/sheep.jpg";
		InputStream stream = c.getResourceAsStream(path);
		ImageData sheepData = new ImageData(stream);
		final Image sheepImage = new Image(display, sheepData);

		path = "/org/rndclub/swt/res/images/idea.jpg";
		stream = c.getResourceAsStream(path);
		ImageData ideaData = new ImageData(stream);
		int whitePixel = ideaData.palette.getPixel(new RGB(255, 255, 255));
		ideaData.transparentPixel = whitePixel;

		final Image ideaImage = new Image(display, ideaData);

		Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.drawImage(sheepImage, 0, 0);
				e.gc.drawImage(ideaImage, 40, 21);
			}
		});

		shell.setSize(210, 160);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		sheepImage.dispose();
		display.dispose();
	}
}
