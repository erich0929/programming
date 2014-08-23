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

public class TableItemColumnTest {

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

		final Table table = new Table(shell, SWT.MULTI | SWT.CHECK
				| SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		table.addListener(SWT.Selection, tableListener);
		table.addListener(SWT.DefaultSelection, tableListener);

		Listener columnListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.type == SWT.Move) {
					System.out.println("[Column-Move] event : " + event);
				} else if (event.type == SWT.Resize) {
					System.out.println("[Column-Resize] event : " + event);
				} else if (event.type == SWT.Selection) {
					System.out.println("[Column-Selection] event : " + event);
				}
			}
		};

		final int rowCount = 4, columnCount = 8;
		for (int i = 0; i < columnCount; i++) {
			TableColumn column = null;
			System.out.println("[TableColumn] " + i + " : " + (i % 4));
			if ((i % 4) == 0) {
				column = new TableColumn(table, SWT.NONE);
			} else if ((i % 4) == 1) {
				column = new TableColumn(table, SWT.LEFT);
			} else if ((i % 4) == 2) {
				column = new TableColumn(table, SWT.CENTER);
			} else if ((i % 4) == 3) {
				column = new TableColumn(table, SWT.RIGHT);
			}
			column.addListener(SWT.Move, columnListener);
			column.addListener(SWT.Resize, columnListener);
			column.addListener(SWT.Selection, columnListener);
			column.setText("Column " + i);
		}

		for (int i = 0; i < rowCount; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_BIN));
			for (int j = 0; j < columnCount; j++) {
				item.setText(j, "Item " + i + "-" + j);
				if ((j % 4) == 0) {
					item.setBackground(j, GraphicsUtil.COLOR_RED);
				} else if ((j % 4) == 1) {
					item.setBackground(j, GraphicsUtil.COLOR_BLUE);
				} else if ((j % 4) == 2) {
					item.setBackground(j, GraphicsUtil.COLOR_YELLOW);
				} else if ((j % 4) == 3) {
					item.setBackground(j, GraphicsUtil.COLOR_CYAN);
				}
			}
		}
		for (int i = 0; i < columnCount; i++) {
			table.getColumn(i).pack();
		}

		Point size = table.computeSize(SWT.DEFAULT + 20, 200);
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
