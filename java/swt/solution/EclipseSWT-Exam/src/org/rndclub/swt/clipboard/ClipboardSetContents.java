package org.rndclub.swt.clipboard;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ClipboardSetContents {

	public static void main(String[] args) {
		Display display = new Display();
		Clipboard cb = new Clipboard(display);
		Shell shell = new Shell(display);
		shell.setText("SWT Clipboard Test");

		String textData = "Hello World";
		String rtfData = "{\\rtf1\\b\\i Hello World}";
		Object[] data = new Object[]{textData, rtfData};

		TextTransfer textTransfer = TextTransfer.getInstance();
		RTFTransfer rtfTransfer = RTFTransfer.getInstance();
		Transfer[] transfers = new Transfer[]{textTransfer, rtfTransfer};

		cb.setContents(data, transfers, DND.CLIPBOARD);

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
