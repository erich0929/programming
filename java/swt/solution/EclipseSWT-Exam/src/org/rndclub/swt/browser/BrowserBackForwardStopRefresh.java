package org.rndclub.swt.browser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class BrowserBackForwardStopRefresh {
	static Browser browser = null;

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
		shell.setLayout(new GridLayout());
		shell.setText("SWT Browser Test");

		ToolBar toolbar = new ToolBar(shell, SWT.NONE);
		final ToolItem itemBack = new ToolItem(toolbar, SWT.PUSH);
		itemBack.setEnabled(false);
		itemBack.setText("Back");
		final ToolItem itemForward = new ToolItem(toolbar, SWT.PUSH);
		itemForward.setEnabled(false);
		itemForward.setText("Forward");
		ToolItem itemStop = new ToolItem(toolbar, SWT.PUSH);
		itemStop.setText("Stop");
		ToolItem itemRefresh = new ToolItem(toolbar, SWT.PUSH);
		itemRefresh.setText("Refresh");

		try {
			String url = "http://www.cyber.co.kr";
			browser = new Browser(shell, SWT.NONE);
			browser.setUrl(url);
			System.out.println("browser.getUrl : '" + browser.getUrl() + "'");

			browser.addLocationListener(new LocationListener() {
				public void changed(LocationEvent e) {
					Browser browser = (Browser) e.widget;
					itemBack.setEnabled(browser.isBackEnabled());
					itemForward.setEnabled(browser.isForwardEnabled());
				}

				public void changing(LocationEvent event) {
				}
			});

			Listener listener = new Listener() {
				public void handleEvent(Event e) {
					ToolItem item = (ToolItem) e.widget;

					String string = item.getText();
					if (string.equals("Back")) {
						browser.back();
					} else if (string.equals("Forward")) {
						browser.forward();
					} else if (string.equals("Stop")) {
						browser.stop();
					} else if (string.equals("Refresh")) {
						browser.refresh();
					}
				}
			};
			itemBack.addListener(SWT.Selection, listener);
			itemForward.addListener(SWT.Selection, listener);
			itemStop.addListener(SWT.Selection, listener);
			itemRefresh.addListener(SWT.Selection, listener);
		} catch (SWTError e) {
			e.printStackTrace();

			exit(shell, e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();

			exit(shell, e.getMessage());
		}

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		toolbar.setLayoutData(gridData);

		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		browser.setLayoutData(gridData);

		shell.setSize(640, 480);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}
