package org.rndclub.swt.browser;

/*
 * Browser example snippet: query DOM node value
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.1
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class BrowserExecuteJavaScript {
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
		shell.setLayout(new FillLayout());
		shell.setText("SWT Browser Test");

		Browser browser = null;
		try {
			String url = "http://www.cyber.co.kr";
			browser = new Browser(shell, SWT.NONE);
			browser.setUrl(url);

			browser.addProgressListener(new ProgressListener() {
				public void changed(ProgressEvent e) {
				}

				public void completed(ProgressEvent e) {
					Browser browser = (Browser) e.widget;
					boolean result = browser.execute("alert('Hello, World!')");
					if (!result) {
						System.out.println("Script was not executed.");
						return;
					}
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
