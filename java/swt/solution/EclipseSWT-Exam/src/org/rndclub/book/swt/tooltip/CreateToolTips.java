package org.rndclub.book.swt.tooltip;

/*
 * Tool Tips example snippet: create tool tips for a tab folder, tool bar and control
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class CreateToolTips {

	public static void main(String[] args) {
		String string = "This is a string\nwith a new line.";
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.open();
		TabFolder folder = new TabFolder(shell, SWT.BORDER);
		folder.setSize(200, 200);
		TabItem item0 = new TabItem(folder, 0);
		item0.setToolTipText(string);
		ToolBar bar = new ToolBar(shell, SWT.BORDER);
		bar.setBounds(0, 200, 200, 64);
		ToolItem item1 = new ToolItem(bar, 0);
		item1.setToolTipText(string);
		shell.setToolTipText(string);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
