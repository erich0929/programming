package org.rndclub.swt.comp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.rndclub.swt.graphics.intro.GraphicsUtil;

public class TableTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Table Test");

		GraphicsUtil.init(display);

		Listener tableListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.type == SWT.DefaultSelection) {
					System.out.println("[Table-Default] event : " + event);
				} else if (event.type == SWT.Selection) {
					System.out.println("[Table-Selection] event : " + event);
					if (event.detail == SWT.CHECK) {
						System.out.println("[Table-Selection] " + event.item
								+ " Checked");
					} else {
						System.out.println("[Table-Selection] " + event.item
								+ " Selected");
					}
				}
			}
		};

		// final Table table = new Table(shell, SWT.SINGLE);
		// final Table table = new Table(shell, SWT.MULTI);
		// final Table table = new Table(shell, SWT.CHECK);
		final Table table = new Table(shell, SWT.MULTI | SWT.CHECK
				| SWT.FULL_SELECTION);
		// final Table table = new Table(shell, SWT.FULL_SELECTION);
		// final Table table = new Table(shell, SWT.HIDE_SELECTION);
		// final Table table = new Table(shell, SWT.VIRTUAL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.addListener(SWT.Selection, tableListener);
		table.addListener(SWT.DefaultSelection, tableListener);

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
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		GraphicsUtil.dispose();
		display.dispose();
	}
}
