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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class DropTargetTreeUnderEffects {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT DropTarget Test");

		Tree tree = new Tree(shell, SWT.V_SCROLL | SWT.H_SCROLL);
		for (int i = 0; i < 16; i++) {
			TreeItem itemi = new TreeItem(tree, SWT.NONE);
			itemi.setText("Item " + i);
			for (int j = 0; j < 2; j++) {
				TreeItem itemj = new TreeItem(itemi, SWT.NONE);
				itemj.setText("Item " + i + " " + j);
			}
		}

		int operations = DND.DROP_DEFAULT | DND.DROP_COPY | DND.DROP_MOVE
				| DND.DROP_LINK;
		Transfer[] types = new Transfer[]{FileTransfer.getInstance(),
				TextTransfer.getInstance()};
		DropTarget target = new DropTarget(tree, operations);
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
				e.feedback = DND.FEEDBACK_EXPAND | DND.FEEDBACK_SELECT
						| DND.FEEDBACK_SCROLL;
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
