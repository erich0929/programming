package org.rndclub.swt.browser;

/*
 * Browser example snippet: query DOM node value
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.1
 */
import org.eclipse.swt.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class QueryDOMNodeValue {
	public static void main(String[] args) {
		final String html = "<html><title>Snippet</title><body><p id='myid'>Best Friends</p><p id='myid2'>Cat and Dog</p></body></html>";
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		final Browser browser = new Browser(shell, SWT.NONE);
		browser.addStatusTextListener(new StatusTextListener() {
			public void changed(StatusTextEvent event) {
				browser.setData("query", event.text);
			}
		});
		browser.addProgressListener(new ProgressListener() {
			public void changed(ProgressEvent event) {
			}

			public void completed(ProgressEvent event) {
				/*
				 * Use JavaScript to query the desired node content through the
				 * Document Object Model
				 * 
				 * Assign result to the window property status to pass the
				 * result to the StatusTextListener This trick is required since
				 * <code>execute</code> does not return the <code>String</code>
				 * directly.
				 */
				boolean result = browser.execute("alert('Hello, World!')");
				// boolean result = browser
				// .execute("window.status=document.getElementById('myid').childNodes[0].nodeValue;");
				if (!result) {
					/*
					 * Script may fail or may not be supported on certain
					 * platforms.
					 */
					System.out.println("Script was not executed.");
					return;
				}
				String value = (String) browser.getData("query");
				System.out.println("Node value: " + value);
			}
		});
		/* Load an HTML document */
		browser.setText(html);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
