package org.rndclub.swt.browser;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SimpleSwtBrowser {
	final static String homeUrl = "http://www.cyber.co.kr";

	Display display = null;
	Shell shell = null;

	Composite browserComp = null;

	Label addLabel = null;
	Text addrText = null;
	Button goButton = null;
	Image goImage = null;

	Browser browser = null;

	public SimpleSwtBrowser() {
		createUI();
		doLayout();
		addListener();
	}

	public void createUI() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("SWT Simple Browser");

		browserComp = new Composite(shell, SWT.NONE);
		addLabel = new Label(browserComp, SWT.NONE);
		addLabel.setText("주소 : ");

		addrText = new Text(browserComp, SWT.NONE);
		addrText.setText(homeUrl);

		Class c = SimpleSwtBrowser.class;
		InputStream stream = c
				.getResourceAsStream("/org/rndclub/swt/res/images/go.jpg");
		ImageData imageData = new ImageData(stream);
		goImage = new Image(display, imageData);

		goButton = new Button(browserComp, SWT.PUSH);
		goButton.setImage(goImage);

		try {
			browser = new Browser(browserComp, SWT.NONE);
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
		shell.setLayout(new FillLayout());

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		browserComp.setLayout(gridLayout);

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.BEGINNING;
		addLabel.setLayoutData(gridData);

		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		addrText.setLayoutData(gridData);

		gridData = new GridData();
		gridData.horizontalAlignment = GridData.END;
		goButton.setLayoutData(gridData);

		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 3;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		browser.setLayoutData(gridData);
	}

	public void addListener() {
		shell.addShellListener(new ShellAdapter() {
			public void shellClosed(ShellEvent e) {
				String title = "Confirm!!!";
				String message = "정말로 빠져나가시겠습니까?";
				int style = SWT.OK | SWT.CANCEL | SWT.ICON_QUESTION;
				MessageBox dialog = new MessageBox(shell, style);
				dialog.setText(title);
				dialog.setMessage(message);

				int flag = dialog.open();
				if (flag == SWT.OK) {
					e.doit = true;
				} else {
					e.doit = false;
				}
			}
		});

		SelectionListener selectionListener = new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				String url = addrText.getText();
				if ((url != null) && (!"".equals(url))) {
					browser.setUrl(url);
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				String url = addrText.getText();
				if ((url != null) && (!"".equals(url))) {
					browser.setUrl(url);
				}
			}
		};
		addrText.addSelectionListener(selectionListener);
		goButton.addSelectionListener(selectionListener);
	}

	public void dispose() {
		if (goImage != null) {
			goImage.dispose();
		}
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
		SimpleSwtBrowser swtBrowser = new SimpleSwtBrowser();
		swtBrowser.run();
	}
}
