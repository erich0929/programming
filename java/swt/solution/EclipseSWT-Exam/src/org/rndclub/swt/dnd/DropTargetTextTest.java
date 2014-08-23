package org.rndclub.swt.dnd;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class DropTargetTextTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT DropTarget Test");

		final Label label = new Label(shell, SWT.BORDER);
		int operations = DND.DROP_DEFAULT | DND.DROP_COPY | DND.DROP_MOVE
				| DND.DROP_LINK;
		Transfer[] types = new Transfer[]{TextTransfer.getInstance()};
		DropTarget target = new DropTarget(label, operations);
		target.setTransfer(types);

		target.addDropListener(new DropTargetListener() {
			public void dragEnter(DropTargetEvent e) {
				System.out.println("[dragEnter] e : " + e);
			}

			public void dragOver(DropTargetEvent e) {
				System.out.println("[dragOver] e : " + e);
			}

			public void dragLeave(DropTargetEvent e) {
				System.out.println("[dragLeave] e : " + e);
			}

			public void dragOperationChanged(DropTargetEvent e) {
				System.out.println("[dragOperationChanged] e : " + e);
			}

			public void dropAccept(DropTargetEvent e) {
				System.out.println("[dropAccept] e : " + e);
			}

			public void drop(DropTargetEvent e) {
				if (e.data == null) {
					e.detail = DND.DROP_NONE;
					return;
				}
				label.setText((String) e.data);
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
