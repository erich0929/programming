package org.rndclub.swt.dnd;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class DropTargetTableUnderEffects {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT DropTarget Test");

		final Table table = new Table(shell, SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final int rowCount = 24, columnCount = 4;
		for (int i = 0; i < columnCount; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText("Column " + i);
		}
		for (int i = 0; i < rowCount; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			for (int j = 0; j < columnCount; j++) {
				item.setText(j, "Item " + i + "-" + j);
			}
		}
		for (int i = 0; i < columnCount; i++) {
			table.getColumn(i).pack();
		}

		int operations = DND.DROP_DEFAULT | DND.DROP_COPY | DND.DROP_MOVE
				| DND.DROP_LINK;
		Transfer[] types = new Transfer[]{FileTransfer.getInstance(),
				TextTransfer.getInstance()};
		DropTarget target = new DropTarget(table, operations);
		target.setTransfer(types);

		target.addDropListener(new DropTargetAdapter() {
			public void dragEnter(DropTargetEvent e) {
				System.out.println("[dragEnter] e : " + e);
				if (e.detail == DND.DROP_DEFAULT) {
					e.detail = DND.DROP_COPY;
				}
			}

			public void dragOperationChanged(DropTargetEvent e) {
				System.out.println("[dragOperationChanged] e : " + e);
				if (e.detail == DND.DROP_DEFAULT) {
					e.detail = DND.DROP_COPY;
				}
			}

			public void dragOver(DropTargetEvent e) {
				System.out.println("[dragOver] e : " + e);
				e.feedback = DND.FEEDBACK_SELECT | DND.FEEDBACK_SCROLL;
			}

			public void drop(DropTargetEvent e) {
				System.out.println("[drop] e : " + e);
			}
		});

		shell.setLocation(display.getBounds().width - 320,
				display.getBounds().height - 240);
		shell.setSize(320, 240);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
