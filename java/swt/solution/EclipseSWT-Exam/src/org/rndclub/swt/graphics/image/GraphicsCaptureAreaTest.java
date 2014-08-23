package org.rndclub.swt.graphics.image;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class GraphicsCaptureAreaTest {
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("SWT GraphicsCaptureArea Test");

		String path = "/org/rndclub/swt/res/images/circle.png";

		InputStream stream = GraphicsImageLabelTest.class
				.getResourceAsStream(path);
		ImageData imageData = new ImageData(stream);
		Image image = new Image(display, imageData);

		final Table table = new Table(shell, SWT.MULTI);
		table.setLinesVisible(true);
		table.setBounds(10, 10, 100, 100);
		for (int i = 0; i < 9; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText("Item " + i);
			item.setImage(image);
		}

		Button button = new Button(shell, SWT.PUSH);
		button.setText("Capture");
		button.pack();
		button.setLocation(10, 140);
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Rectangle tb = table.getBounds();

				GC gc = new GC(shell);
				final Image image = new Image(display, tb.width, tb.width);
				gc.copyArea(image, tb.x, tb.y);
				gc.dispose();

				Shell popup = new Shell(shell);
				popup.setText("CaptureWidget");
				popup.addListener(SWT.Close, new Listener() {
					public void handleEvent(Event e) {
						image.dispose();
					}
				});

				int w = tb.width;
				int h = tb.height;
				Canvas canvas = new Canvas(popup, SWT.NONE);
				canvas.setBounds(10, 10, w + 10, h + 10);
				canvas.addPaintListener(new PaintListener() {
					public void paintControl(PaintEvent e) {
						GC gc = e.gc;
						gc.drawImage(image, 0, 0);
					}
				});
				popup.pack();
				popup.open();
			}
		});

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
