package org.rndclub.swt.browser;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SwtBrowserComposite {
	Composite parent = null;

	Composite browserComp = null;

	Label addLabel = null;
	Text addrText = null;
	Button goButton = null;
	Image goImage = null;

	Browser browser = null;

	public SwtBrowserComposite(Composite parent) {
		this.parent = parent;

		createUI();
		doLayout();
	}

	public void createUI() {
		// parent.setT.setText("SWT Browser");

		browserComp = new Composite(parent, SWT.NONE);
		addLabel = new Label(browserComp, SWT.NONE);
		addLabel.setText("аж╪р : ");

		addrText = new Text(browserComp, SWT.NONE);

		Class c = SwtBrowserComposite.class;
		InputStream stream = c
				.getResourceAsStream("/org/rndclub/swt/res/images/go.jpg");
		ImageData imageData = new ImageData(stream);
		goImage = new Image(parent.getDisplay(), imageData);

		goButton = new Button(browserComp, SWT.PUSH);
		goButton.setImage(goImage);

		browser = new Browser(browserComp, SWT.NONE);
	}

	public void doLayout() {
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

	public static void main(String[] args) {
		// SwtBrowserComposite swtBrowser = new SwtBrowserComposite();
		// swtBrowser.run();
	}
}
