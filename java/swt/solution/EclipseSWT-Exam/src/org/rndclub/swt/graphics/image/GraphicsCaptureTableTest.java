package org.rndclub.swt.graphics.image;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class GraphicsCaptureTableTest {
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("SWT GraphicsCaptureTable Test");

		String path = "/org/rndclub/swt/res/images/circle.png";

		InputStream stream = GraphicsImageLabelTest.class
				.getResourceAsStream(path);
		ImageData imageData = new ImageData(stream);
		Image image = new Image(display, imageData);

		final Table table = new Table(shell, SWT.MULTI | SWT.CHECK
				| SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBounds(10, 10, 340, 128);
		for (int i = 0; i < 4; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText("Column " + i);
		}
		for (int i = 0; i < 9; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setImage(image);
			for (int j = 0; j < 4; j++) {
				item.setText(j, "Item " + i + "-" + j);
			}
		}
		for (int i = 0; i < 4; i++) {
			table.getColumn(i).pack();
		}

		Button button = new Button(shell, SWT.PUSH);
		button.setText("Capture");
		button.pack();
		button.setLocation(10, 140);
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Point tsize = table.getSize();

				GC gc = new GC(table);
				final Image image = new Image(display, tsize.x, tsize.y);
				gc.copyArea(image, 0, 0);
				gc.dispose();

				Shell popup = new Shell(shell);
				popup.setText("CaptureWidget");
				popup.addListener(SWT.Close, new Listener() {
					public void handleEvent(Event e) {
						image.dispose();
					}
				});

				Canvas canvas = new Canvas(popup, SWT.NONE);
				canvas.setBounds(10, 10, tsize.x + 10, tsize.y + 10);
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
