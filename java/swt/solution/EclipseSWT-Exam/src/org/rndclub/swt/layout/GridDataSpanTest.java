package org.rndclub.swt.layout;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class GridDataSpanTest {
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("SWT GridLayout Test");

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		shell.setLayout(gridLayout);

		Button b = new Button(shell, SWT.PUSH);
		b.setText("Horizontal Title");
		GridData gridData = new GridData();
		gridData.heightHint = 32;
		gridData.horizontalSpan = 4;
		gridData.horizontalAlignment = GridData.FILL;
		b.setLayoutData(gridData);

		b = new Button(shell, SWT.PUSH);
		b.setText("Vertical Title");
		gridData = new GridData();
		gridData.verticalSpan = 3;
		gridData.verticalAlignment = GridData.FILL;
		b.setLayoutData(gridData);

		for (int i = 0; i < 8; i++) {
			b = new Button(shell, SWT.PUSH);
			b.setText("Button " + i);
		}

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
