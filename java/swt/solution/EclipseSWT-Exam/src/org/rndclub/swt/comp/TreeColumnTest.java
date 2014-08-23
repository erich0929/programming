package org.rndclub.swt.comp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.rndclub.swt.graphics.intro.GraphicsUtil;

public class TreeColumnTest {
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Tree Column Test");

		GraphicsUtil.init(display);

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

		Tree tree = new Tree(shell, SWT.FULL_SELECTION | SWT.BORDER
				| SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setHeaderVisible(true);

		TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
		column1.setText("Column 1");
		column1.setWidth(160);
		column1.addListener(SWT.Move, columnListener);
		column1.addListener(SWT.Resize, columnListener);
		column1.addListener(SWT.Selection, columnListener);

		TreeColumn column2 = new TreeColumn(tree, SWT.CENTER);
		column2.setText("Column 2");
		column2.setWidth(160);
		column2.addListener(SWT.Move, columnListener);
		column2.addListener(SWT.Resize, columnListener);
		column2.addListener(SWT.Selection, columnListener);

		TreeColumn column3 = new TreeColumn(tree, SWT.RIGHT);
		column3.setText("Column 3");
		column3.setWidth(160);
		column3.addListener(SWT.Move, columnListener);
		column3.addListener(SWT.Resize, columnListener);
		column3.addListener(SWT.Selection, columnListener);

		for (int i = 0; i < 3; i++) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText(new String[]{"item " + i, "abc", "defghi"});
			item.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_OPEN));
			for (int j = 0; j < 2; j++) {
				TreeItem subItem = new TreeItem(item, SWT.NONE);
				subItem.setText(new String[]{"subitem " + j, "jklmnop", "qrs"});
				subItem.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_BIN));
				for (int k = 0; k < 2; k++) {
					TreeItem subsubItem = new TreeItem(subItem, SWT.NONE);
					subsubItem.setText(new String[]{"subsubitem " + k, "tuv",
							"wxyz"});
					subsubItem.setImage(GraphicsUtil
							.getImage(GraphicsUtil.IMAGE_RUN));
				}
			}
		}

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		GraphicsUtil.dispose();
		display.dispose();
	}
}