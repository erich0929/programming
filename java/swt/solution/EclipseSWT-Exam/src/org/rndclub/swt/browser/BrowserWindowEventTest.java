package org.rndclub.swt.browser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.CloseWindowListener;
import org.eclipse.swt.browser.OpenWindowListener;
import org.eclipse.swt.browser.VisibilityWindowListener;
import org.eclipse.swt.browser.WindowEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class BrowserWindowEventTest {
	public static void exit(Shell shell, String message) {
		MessageBox mbox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
		mbox.setText("Error!!!");
		mbox.setMessage("[Browser] e : " + message);
		mbox.open();

		System.exit(-1);
	}

	static void initialize(final Display display, Browser browser) {
		browser.addOpenWindowListener(new OpenWindowListener() {
			public void open(WindowEvent e) {
				System.out.println("[open] : " + e);
				System.out.println("[open] : " + e.required);
				if (!e.required) {
					// return;
				}

				Shell shell = new Shell(display);
				shell.setText("New Window");
				shell.setLayout(new FillLayout());

				Browser browser = new Browser(shell, SWT.NONE);
				initialize(display, browser);
				e.browser = browser;
			}
		});

		browser.addVisibilityWindowListener(new VisibilityWindowListener() {
			public void hide(WindowEvent e) {
				System.out.println("[hide] : " + e);
				Browser browser = (Browser) e.widget;
				Shell shell = browser.getShell();
				shell.setVisible(false);
			}

			public void show(WindowEvent e) {
				System.out.println("[show] : " + e);
				Browser browser = (Browser) e.widget;
				Shell shell = browser.getShell();
				if (e.location != null) {
					shell.setLocation(e.location);
				}
				if (e.size != null) {
					Point size = e.size;
					shell.setSize(shell.computeSize(size.x, size.y));
				}
				System.out.println("[show] e.location   : " + e.location);
				System.out.println("[show] e.size       : " + e.size);
				System.out.println("[show] e.addressBar : " + e.addressBar);
				System.out.println("[show] e.menuBar    : " + e.menuBar);
				System.out.println("[show] e.statusBar  : " + e.statusBar);
				System.out.println("[show] e.toolBar    : " + e.toolBar);
				if (e.addressBar || e.menuBar || e.statusBar || e.toolBar) {
					// 각 상태값에 따라 브라우저 위젯을 꾸민다.
				}
				shell.open();
			}
		});

		browser.addCloseWindowListener(new CloseWindowListener() {
			public void close(WindowEvent e) {
				System.out.println("[close] : " + e);
				Browser browser = (Browser) e.widget;
				Shell shell = browser.getShell();
				shell.close();
			}
		});
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Browser Test");

		Browser browser = null;
		try {
			String url = "http://www.cyber.co.kr";
			browser = new Browser(shell, SWT.NONE);
			initialize(display, browser);

			browser.setUrl(url);
			System.out.println("browser.getUrl : '" + browser.getUrl() + "'");
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
