package org.rndclub.swt.clipboard;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.HTMLTransfer;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ClipboardGetAvailableTypes {

	public static void main(String[] args) {
		Display display = new Display();
		Clipboard cb = new Clipboard(display);
		Shell shell = new Shell(display);
		shell.setText("SWT Clipboard Test");

		TransferData[] types = cb.getAvailableTypes();
		String[] names = cb.getAvailableTypeNames();
		for (int i = 0; i < types.length; i++) {
			System.out.print("Type[" + i + "] : " + types[i].type);
			if (TextTransfer.getInstance().isSupportedType(types[i])) {
				System.out.print(" --> TextTransfer isSupportedType");
			} else if (HTMLTransfer.getInstance().isSupportedType(types[i])) {
				System.out.print(" --> HTMLTransfer isSupportedType");
			} else if (RTFTransfer.getInstance().isSupportedType(types[i])) {
				System.out.print(" --> RTFTransfer isSupportedType");
			} else if (FileTransfer.getInstance().isSupportedType(types[i])) {
				System.out.print(" --> FileTransfer isSupportedType");
			}
			System.out.println();
			System.out.println("Name[" + i + "] : " + names[i]);
		}

		shell.setSize(320, 240);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		cb.dispose();
		display.dispose();
	}
}
