package org.rndclub.swt.comp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.rndclub.swt.graphics.intro.GraphicsUtil;

public class TableTest2 {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Table Test");

		GraphicsUtil.init(display);

		final Table table = new Table(shell, SWT.MULTI | SWT.CHECK
				| SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final int rowCount = 4, columnCount = 8;
		for (int i = 0; i < columnCount; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText("Column " + i);
		}
		for (int i = 0; i < rowCount; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_BIN));
			for (int j = 0; j < columnCount; j++) {
				item.setText(j, "Item " + i + "-" + j);
			}
		}
		for (int i = 0; i < columnCount; i++) {
			table.getColumn(i).pack();
		}

		Point size = table.computeSize(SWT.DEFAULT, 200);
		table.setSize(size);

		shell.pack();
		table.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				Point pt = new Point(event.x, event.y);
				TableItem item = table.getItem(pt);
				System.out.println("[Table-Selection] item : " + item);
				if (item == null)
					return;
				for (int i = 0; i < columnCount; i++) {
					Rectangle rect = item.getBounds(i);
					if (rect.contains(pt)) {
						int index = table.indexOf(item);
						System.out.println("[Table-MouseDown] Item " + index
								+ "-" + i);
						break;
					}
				}
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		GraphicsUtil.dispose();
		display.dispose();
	}
}
