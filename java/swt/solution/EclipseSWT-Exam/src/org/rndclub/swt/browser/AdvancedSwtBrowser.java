package org.rndclub.swt.browser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.browser.TitleEvent;
import org.eclipse.swt.browser.TitleListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;

public class AdvancedSwtBrowser {
	final static String homeUrl = "http://www.cyber.co.kr";

	Display display = null;
	Shell shell = null;

	ToolBar toolbar = null;
	ToolItem itemBack = null;
	ToolItem itemForward = null;
	ToolItem itemStop = null;
	ToolItem itemRefresh = null;
	ToolItem itemHome = null;

	Composite compAddr = null;
	Label labelAddr = null;
	Combo comboLoc = null;
	// Text textLoc = null;
	Button buttonGo = null;
	Label labelStatus = null;
	ProgressBar progressBar = null;

	Browser browser = null;

	public AdvancedSwtBrowser() {
		createUI();
		doLayout();
		addListener();
	}

	public void createUI() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("SWT Advanced Browser");
		GraphicsUtil.init(display);

		try {
			toolbar = new ToolBar(shell, SWT.NONE);
			itemBack = new ToolItem(toolbar, SWT.PUSH);
			itemBack.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_BACK));
			itemBack.setEnabled(false);
			itemBack.setToolTipText("Back");
			itemForward = new ToolItem(toolbar, SWT.PUSH);
			itemForward.setImage(GraphicsUtil
					.getImage(GraphicsUtil.IMAGE_FORWARD));
			itemForward.setEnabled(false);
			itemForward.setToolTipText("Forward");
			itemStop = new ToolItem(toolbar, SWT.PUSH);
			itemStop.setToolTipText("Stop");
			itemStop.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_STOP));
			itemRefresh = new ToolItem(toolbar, SWT.PUSH);
			itemRefresh.setToolTipText("Refresh");
			itemRefresh.setImage(GraphicsUtil
					.getImage(GraphicsUtil.IMAGE_REFRESH));
			itemHome = new ToolItem(toolbar, SWT.PUSH);
			itemHome.setToolTipText("Home");
			itemHome.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_HOME));

			compAddr = new Composite(shell, SWT.NONE);
			labelAddr = new Label(compAddr, SWT.NONE);
			labelAddr.setText("аж╪р : ");

			comboLoc = new Combo(compAddr, SWT.DROP_DOWN);
			buttonGo = new Button(compAddr, SWT.PUSH);
			buttonGo.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_GO));
			buttonGo.setToolTipText("GO");

			browser = new Browser(shell, SWT.NONE);
			labelStatus = new Label(shell, SWT.NONE);
			labelStatus.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
			labelStatus.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
			progressBar = new ProgressBar(shell, SWT.NONE);

			browser.setUrl(homeUrl);
		} catch (SWTError e) {
			e.printStackTrace();

			MessageBox mbox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
			mbox.setText("Error!!!");
			mbox.setMessage("[Browser] e : " + e.getMessage());
			mbox.open();

			dispose();
			System.exit(-1);
		}
	}

	public void doLayout() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		shell.setLayout(gridLayout);

		GridData data = new GridData();
		data.horizontalSpan = 3;
		toolbar.setLayoutData(data);

		data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 3;
		compAddr.setLayoutData(data);

		data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		data.horizontalSpan = 3;
		browser.setLayoutData(data);

		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		labelStatus.setLayoutData(data);

		data = new GridData();
		data.horizontalAlignment = GridData.END;
		progressBar.setLayoutData(data);

		gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		compAddr.setLayout(gridLayout);

		data = new GridData();
		data.horizontalAlignment = GridData.BEGINNING;
		labelAddr.setLayoutData(data);

		data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		comboLoc.setLayoutData(data);

		data = new GridData();
		data.horizontalAlignment = GridData.END;
		buttonGo.setLayoutData(data);
	}

	public void addListener() {
		Listener listener = new Listener() {
			public void handleEvent(Event e) {
				Widget widget = e.widget;

				if (widget == itemBack) {
					browser.back();
				} else if (widget == itemForward) {
					browser.forward();
				} else if (widget == itemStop) {
					browser.stop();
				} else if (widget == itemRefresh) {
					browser.refresh();
				} else if (widget == itemHome) {
					browser.setUrl(homeUrl);
				} else if (widget == buttonGo) {
					String url = comboLoc.getText();
					browser.setUrl(url);
				} else if (widget == comboLoc) {
					int index = comboLoc.getSelectionIndex();
					if (index == -1) {
						String url = comboLoc.getText();
						browser.setUrl(url);
					} else {
						String url = comboLoc.getItem(index);
						browser.setUrl(url);
					}
				}
			}
		};

		itemBack.addListener(SWT.Selection, listener);
		itemForward.addListener(SWT.Selection, listener);
		itemStop.addListener(SWT.Selection, listener);
		itemRefresh.addListener(SWT.Selection, listener);
		itemHome.addListener(SWT.Selection, listener);
		buttonGo.addListener(SWT.Selection, listener);
		comboLoc.addListener(SWT.Selection, listener);
		comboLoc.addListener(SWT.DefaultSelection, listener);

		browser.addProgressListener(new ProgressListener() {
			public void changed(ProgressEvent e) {
				if (e.total == 0) {
					return;
				}
				int ratio = e.current * 100 / e.total;
				progressBar.setSelection(ratio);
			}

			public void completed(ProgressEvent e) {
				progressBar.setSelection(0);
			}
		});

		browser.addStatusTextListener(new StatusTextListener() {
			public void changed(StatusTextEvent e) {
				labelStatus.setText(e.text);
			}
		});

		browser.addTitleListener(new TitleListener() {
			public void changed(TitleEvent e) {
				shell.setText(e.title);
			}
		});

		browser.addLocationListener(new LocationListener() {
			public void changed(LocationEvent e) {
				Browser browser = (Browser) e.widget;
				itemBack.setEnabled(browser.isBackEnabled());
				itemForward.setEnabled(browser.isForwardEnabled());
				if (e.top) {
					comboLoc.setText(e.location);
					boolean exist = false;
					for (int i = 0; i < comboLoc.getItemCount(); i++) {
						String item = comboLoc.getItem(i);
						if (item.equals(e.location)) {
							exist = true;
							break;
						}
					}
					if (exist == false) {
						comboLoc.add(e.location);
					}
				}
			}
			public void changing(LocationEvent e) {
			}
		});
	}

	public void dispose() {
		GraphicsUtil.dispose();
		display.dispose();
	}

	public void run() {
		shell.setSize(640, 480);
		shell.open();
		browser.setUrl(homeUrl);

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		dispose();
	}

	public static void main(String[] args) {
		AdvancedSwtBrowser swtBrowser = new AdvancedSwtBrowser();
		swtBrowser.run();
	}
}
