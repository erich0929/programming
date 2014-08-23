package org.rndclub.swt.dialog;

import org.eclipse.swt.widgets.*;

public class DirectoryDialogTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.open();

		DirectoryDialog dialog = new DirectoryDialog(shell);
		dialog.setFilterPath("e:\\temp");
		String dirName = dialog.open();
		System.out.println("dir : " + dirName);

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
