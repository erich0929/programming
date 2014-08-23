package org.rndclub.swt.browser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class BrowserCheckAvailableTest {
	final static String homeUrl = "http://www.cyber.co.kr";

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Browser Test");

		Browser browser = null;
		try {
			browser = new Browser(shell, SWT.NONE);
			browser.setUrl(homeUrl);
		} catch (SWTError e) {
			MessageBox mbox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
			mbox.setText("Error!!!");
			mbox.setMessage("[Browser] e : " + e.getMessage());
			mbox.open();

			System.exit(-1);
		}

		shell.setSize(640, 480);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
