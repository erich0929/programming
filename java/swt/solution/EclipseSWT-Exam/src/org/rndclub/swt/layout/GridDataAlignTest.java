package org.rndclub.swt.layout;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class GridDataAlignTest {
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("SWT GridLayout Test");

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		shell.setLayout(gridLayout);
		for (int i = 0; i < 10; i++) {
			Button b = new Button(shell, SWT.PUSH);
			b.setText("Button " + i);

			GridData gridData = new GridData();
			gridData.horizontalAlignment = GridData.CENTER;//GridData.FILL;
			// GridData.BEGINNING, GridData.CENTER, GridData.END, GridData.FILL
			gridData.verticalAlignment = GridData.CENTER;//GridData.FILL;
			// GridData.BEGINNING, GridData.CENTER, GridData.END, GridData.FILL

			gridData.grabExcessHorizontalSpace = true;
			gridData.grabExcessVerticalSpace = true;

			b.setLayoutData(gridData);
		}

		shell.setSize(340, 160);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
