package org.rndclub.swt.ole;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleControlSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTOleFrame {

	public static void main(String[] args) {

		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(600, 400);
		shell.setLayout(new FillLayout());

		OleControlSite oleControlSite;

		OleFrame oleFrame = new OleFrame(shell, SWT.NONE);
		oleControlSite = new OleControlSite(oleFrame, SWT.NONE,
				"Shell.Explorer");
		oleControlSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
		shell.open();

		final OleAutomation browser = new OleAutomation(oleControlSite);

		int[] browserIDs = browser
				.getIDsOfNames(new String[]{"Navigate", "URL"});
		Variant[] address = new Variant[]{new Variant("http://www.oreilly.com")};
		browser.invoke(browserIDs[0], address, new int[]{browserIDs[1]});

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		browser.dispose();
		display.dispose();
	}
}
