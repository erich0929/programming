package org.rndclub.swt.browser;

/*
 * Browser example snippet: render HTML that includes relative links from memory
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.0
 */
import org.eclipse.swt.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class RenderHTMLWithRelativeLinks {

	public static void main(String[] args) {
		/* Relative links: use the HTML base tag */
		String html = "<html><head>"
				+ "<base href=\"http://www.eclipse.org/swt/\" >"
				+ "<title>HTML Test</title></head>"
				+ "<body><a href=\"faq.php\">local link</a></body></html>";

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		Browser browser = new Browser(shell, SWT.NONE);
		browser.setText(html);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
