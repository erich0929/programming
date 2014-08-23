package org.rndclub.swt.p11;

/*
 * Browser example snippet: bring up a browser
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.0
 */
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.browser.*;

public class XBrowser extends Composite {
	Browser browser = null;

	Text location = null;
	ToolItem defaultGo = null;

	Label status = null;

	ProgressBar progressBar = null;

	String defaultUrl = null;

	public XBrowser(Composite parent, int style, String sUrl, boolean flag) {
		super(parent, style);

		this.defaultUrl = sUrl;

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		setLayout(gridLayout);

		ToolBar toolbar = new ToolBar(this, SWT.NONE);

		ToolItem itemBack = new ToolItem(toolbar, SWT.PUSH);
		itemBack.setText("Back");

		ToolItem itemForward = new ToolItem(toolbar, SWT.PUSH);
		itemForward.setText("Forward");

		ToolItem itemStop = new ToolItem(toolbar, SWT.PUSH);
		itemStop.setText("Stop");

		ToolItem itemRefresh = new ToolItem(toolbar, SWT.PUSH);
		itemRefresh.setText("Refresh");

		ToolItem itemGo = new ToolItem(toolbar, SWT.PUSH);
		itemGo.setText("Go");

		defaultGo = new ToolItem(toolbar, SWT.PUSH);
		if ((sUrl == null) || ("".equals(sUrl))) {
			defaultGo.setText("NO");
			defaultGo.setEnabled(false);
		} else {
			defaultGo.setText(sUrl);
			defaultGo.setEnabled(true);
		}

		GridData data = new GridData();
		data.horizontalSpan = 3;
		toolbar.setLayoutData(data);

		Label labelAddress = new Label(this, SWT.NONE);
		labelAddress.setText("Address");

		location = new Text(this, SWT.BORDER);
		location.setText("none");
		data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.horizontalSpan = 2;
		data.grabExcessHorizontalSpace = true;
		location.setLayoutData(data);

		browser = new Browser(this, SWT.NONE);
		data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		data.horizontalSpan = 3;
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		browser.setLayoutData(data);

		status = new Label(this, SWT.NONE);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		status.setLayoutData(data);

		progressBar = new ProgressBar(this, SWT.NONE);
		data = new GridData();
		data.horizontalAlignment = GridData.END;
		progressBar.setLayoutData(data);

		if (flag == false) {
			location.setEnabled(false);
			itemGo.setEnabled(false);
		}

		Listener listener = new Listener() {
			public void handleEvent(Event event) {
				if((browser==null)||(browser.isDisposed())) {
					return;
				}
				ToolItem item = (ToolItem) event.widget;
				String string = item.getText();
				if ("Back".equals(string)) {
					browser.back();
				} else if ("Forward".equals(string)) {
					browser.forward();
				} else if ("Stop".equals(string)) {
					browser.stop();
				} else if ("Refresh".equals(string)) {
					browser.refresh();
				} else if ("Go".equals(string)) {
					browser.setUrl(location.getText());
				} else {
					browser.setUrl(defaultUrl);
				}
			}
		};

		browser.addProgressListener(new ProgressListener() {
			public void changed(ProgressEvent event) {
				if (event.total == 0)
					return;
				int ratio = event.current * 100 / event.total;
				progressBar.setSelection(ratio);
			}

			public void completed(ProgressEvent event) {
				progressBar.setSelection(0);
			}
		});
		browser.addStatusTextListener(new StatusTextListener() {
			public void changed(StatusTextEvent event) {
				status.setText(event.text);
			}
		});
		browser.addLocationListener(new LocationListener() {
			public void changed(LocationEvent event) {
				if (event.top) {
					location.setText(event.location);
				}
			}

			public void changing(LocationEvent event) {
			}
		});
		// browser.addTitleListener(new TitleListener() {
		// public void changed(TitleEvent event) {
		// LoggerModel.logln"TitleEvent: " + event.title);
		// shell.setText(event.title);
		// }
		// });
		//

		itemBack.addListener(SWT.Selection, listener);
		itemForward.addListener(SWT.Selection, listener);
		itemStop.addListener(SWT.Selection, listener);
		itemRefresh.addListener(SWT.Selection, listener);
		itemGo.addListener(SWT.Selection, listener);
		defaultGo.addListener(SWT.Selection, listener);
		location.addListener(SWT.DefaultSelection, new Listener() {
			public void handleEvent(Event e) {
				if((browser==null)||(browser.isDisposed())) {
					return;
				}
				browser.setUrl(location.getText());
			}
		});
	}

	public String getUrl() {
		if((browser==null)||(browser.isDisposed())) {
			return null;
		}
		return (browser.getUrl());
	}

	public void setDefaultUrl(String url) {
		if((browser==null)||(browser.isDisposed())) {
			return;
		}
		defaultUrl = url;
		if((defaultUrl!=null)&&(!"".equals(defaultUrl))) {
			defaultGo.setEnabled(true);
			browser.setUrl(defaultUrl);
		}
	}

	public void setUrl(String url) {
		if((browser==null)||(browser.isDisposed())) {
			return;
		}
		browser.setUrl(url);
	}

	public boolean execute(String script) {
		if((browser==null)||(browser.isDisposed())) {
			return false;
		}
		return (browser.execute(script));
	}

	public void run() {
		// shell.open();
		// browser.setUrl("http://eclipse.org");
		//
		// while (!shell.isDisposed()) {
		// if (!display.readAndDispatch())
		// display.sleep();
		// }
		// display.dispose();
	}

	static public void main(String args[]) {
		// XBrowser xBrowser = new XBrowser();
		// xBrowser.run();
	}
}
