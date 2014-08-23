package org.rndclub.swt.comp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.rndclub.swt.graphics.intro.GraphicsUtil;

public class TreeTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Tree Test");

		GraphicsUtil.init(display);

		Tree tree = new Tree(shell, SWT.CHECK | SWT.V_SCROLL | SWT.H_SCROLL);
		// Tree tree = new Tree(shell, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		// Tree tree = new Tree(shell, SWT.FULL_SELECTION | SWT.V_SCROLL
		// | SWT.H_SCROLL);
		for (int i = 0; i < 4; i++) {
			TreeItem itemi = new TreeItem(tree, SWT.NONE);
			itemi.setText("Item " + i);
			itemi.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_OPEN));
			for (int j = 0; j < 2; j++) {
				TreeItem itemj = new TreeItem(itemi, SWT.NONE);
				itemj.setText("Item " + i + " " + j);
				itemj.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_FILE));
			}
		}

		Listener treeListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.type == SWT.Collapse) {
					System.out.println("[Tree-Collapse] event : " + event);
				} else if (event.type == SWT.Expand) {
					System.out.println("[Tree-Expand] event : " + event);
				} else if (event.type == SWT.DefaultSelection) {
					System.out.println("[Tree-Default] event : " + event);
				} else if (event.type == SWT.Selection) {
					System.out.println("[Tree-Selection] event : " + event);
					if (event.detail == SWT.CHECK) {
						System.out.println("[Tree-Selection] " + event.item
								+ " Checked");
					} else {
						System.out.println("[Tree-Selection] " + event.item
								+ " Selected");
					}
				}
			}
		};

		tree.addListener(SWT.Collapse, treeListener);
		tree.addListener(SWT.Expand, treeListener);
		tree.addListener(SWT.Selection, treeListener);
		tree.addListener(SWT.DefaultSelection, treeListener);

		shell.setSize(240, 120);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		GraphicsUtil.dispose();
		display.dispose();
	}
}
