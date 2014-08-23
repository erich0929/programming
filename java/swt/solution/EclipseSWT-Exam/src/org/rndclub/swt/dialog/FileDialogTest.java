package org.rndclub.swt.dialog;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class FileDialogTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.open();

		// FileDialog dialog = new FileDialog(shell, SWT.OPEN);
		// FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		FileDialog dialog = new FileDialog(shell, SWT.MULTI);
		dialog.setFilterNames(new String[]{"JPG Files", "GIF Files",
				"PNG Files", "All Files (*.*)"});
		dialog.setFilterExtensions(new String[]{"*.jpg", "*.gif", "*.png",
				"*.*"});
		dialog.setFilterPath("e:\\temp");
		dialog.setFileName("iamge.jpg");
		System.out.println("filename : " + dialog.open());
		String filenames[] = dialog.getFileNames();
		for (int i = 0; (filenames != null) && (i < filenames.length); i++) {
			System.out.println("filename[" + i + "] : " + filenames[i]);
		}

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
