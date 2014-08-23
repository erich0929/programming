package org.rndclub.swt.menu;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class ToolBarTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		// ToolBar toolBar = new ToolBar(shell, SWT.BORDER | SWT.FLAT);
		ToolBar toolBar = new ToolBar(shell, SWT.FLAT);
		// ToolBar toolBar = new ToolBar(shell, SWT.WRAP);
		// ToolBar toolBar = new ToolBar(shell, SWT.RIGHT);
		// ToolBar toolBar = new ToolBar(shell, SWT.HORIZONTAL);
		// ToolBar toolBar = new ToolBar(shell, SWT.VERTICAL);
		// ToolBar toolBar = new ToolBar(shell, SWT.SHADOW_OUT);
		// ToolBar toolBar = new ToolBar(shell, SWT.BORDER);
		shell.setText("SWT.SHADOW_OUT");
		for (int i = 0; i < 4; i++) {
			ToolItem item = new ToolItem(toolBar, SWT.PUSH);
			item.setText("Item " + i);
		}
		toolBar.pack();

		shell.open();
		shell.setSize(toolBar.getSize().x + 16, toolBar.getSize().y + 40);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
