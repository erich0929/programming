package org.rndclub.swt.layout;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class GridDataHintTest {
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
			gridData.widthHint = 40 + (i / 2) * 16;
			gridData.heightHint = 16 + (i / 2) * 4;

			b.setLayoutData(gridData);
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