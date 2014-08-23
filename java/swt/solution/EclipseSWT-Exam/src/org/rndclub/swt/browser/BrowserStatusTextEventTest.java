package org.rndclub.swt.browser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class BrowserStatusTextEventTest {
	public static void exit(Shell shell, String message) {
		MessageBox mbox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
		mbox.setText("Error!!!");
		mbox.setMessage("[Browser] e : " + message);
		mbox.open();

		System.exit(-1);
	}

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("SWT Browser Test");

		Browser browser = null;
		try {
			String url = "http://www.cyber.co.kr";
			browser = new Browser(shell, SWT.NONE);
			final Label label = new Label(shell, SWT.SMOOTH);

			shell.setLayout(new GridLayout());

			GridData gridData = new GridData();
			gridData.horizontalAlignment = GridData.FILL;
			gridData.verticalAlignment = GridData.FILL;
			gridData.grabExcessHorizontalSpace = true;
			gridData.grabExcessVerticalSpace = true;
			browser.setLayoutData(gridData);

			gridData = new GridData();
			gridData.horizontalAlignment = GridData.FILL;
			gridData.grabExcessHorizontalSpace = true;
			label.setLayoutData(gridData);

			browser.setUrl(url);
			System.out.println("browser.getUrl : '" + browser.getUrl() + "'");

			browser.addStatusTextListener(new StatusTextListener() {
				public void changed(StatusTextEvent e) {
					String text = e.text;
					label.setText(text);
				}
			});
		} catch (SWTError e) {
			e.printStackTrace();

			exit(shell, e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();

			exit(shell, e.getMessage());
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
