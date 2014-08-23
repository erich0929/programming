package org.rndclub.swt.clipboard;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ClipboardGetContents {

	public static void main(String[] args) {
		Display display = new Display();
		Clipboard cb = new Clipboard(display);
		Shell shell = new Shell(display);
		shell.setText("SWT Clipboard Test");

	    TextTransfer textTransfer = TextTransfer.getInstance();
	    String textData = (String)cb.getContents(textTransfer);
	    if (textData != null) {
	    	System.out.println("Text : "+textData);
	    }

	    RTFTransfer rtfTransfer = RTFTransfer.getInstance();
	    String rtfData = (String)cb.getContents(rtfTransfer, DND.CLIPBOARD);
	    if (rtfData != null) {
	    	System.out.println("RTF Text : "+rtfData);
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
