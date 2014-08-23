package org.rndclub.swt.layout;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class GridLayoutMarginWHTest {
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("SWT GridLayout Test");

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		gridLayout.makeColumnsEqualWidth = true;
		gridLayout.marginWidth = 10;
		gridLayout.marginHeight = 30;

		shell.setLayout(gridLayout);
		for (int i = 0; i < 10; i++) {
			Button b = new Button(shell, SWT.PUSH);
			if ((i % 4) == 0) {
				b.setText("B " + i);
			} else if ((i % 4) == 1) {
				b.setText("B * " + i);
			} else if ((i % 4) == 2) {
				b.setText("B ** " + i);
			} else if ((i % 4) == 3) {
				b.setText("B *** " + i);
			}
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
