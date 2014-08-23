package org.rndclub.swt.browser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class BrowserProgressEventTest {
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
			final ProgressBar bar = new ProgressBar(shell, SWT.SMOOTH);

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
			bar.setLayoutData(gridData);

			browser.setUrl(url);
			System.out.println("browser.getUrl : '" + browser.getUrl() + "'");

			browser.addProgressListener(new ProgressListener() {
				public void changed(ProgressEvent e) {
					int curr = e.current;
					int tot = e.total;
					bar.setMaximum(tot);
					bar.setSelection(curr);
				}

				public void completed(ProgressEvent e) {
					int curr = e.current;
					int tot = e.total;
					bar.setMaximum(tot);
					bar.setSelection(curr);
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