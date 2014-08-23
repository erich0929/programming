package org.rndclub.book.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ButtonTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Eclipse SWT");

		/* Button b1 = */new Button(shell, SWT.PUSH);
		/* Button b21 = */new Button(shell, SWT.ARROW | SWT.UP);
		/* Button b22 = */new Button(shell, SWT.ARROW | SWT.DOWN);
		/* Button b23 = */new Button(shell, SWT.ARROW | SWT.LEFT);
		/* Button b24 = */new Button(shell, SWT.ARROW | SWT.RIGHT);
		/* Button b25 = */new Button(shell, SWT.ARROW | SWT.CENTER);
		/* Button b3 = */new Button(shell, SWT.CHECK);
		/* Button b4 = */new Button(shell, SWT.RADIO);
		/* Button b5 = */new Button(shell, SWT.TOGGLE);
		/* Button b6 = */new Button(shell, SWT.FLAT);

		shell.setLayout(new FillLayout());

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
