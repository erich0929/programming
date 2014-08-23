package org.rndclub.swt.widgets;

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

		new Button(shell, SWT.PUSH);
		new Button(shell, SWT.ARROW | SWT.UP);
		new Button(shell, SWT.ARROW | SWT.DOWN);
		new Button(shell, SWT.ARROW | SWT.LEFT);
		new Button(shell, SWT.ARROW | SWT.RIGHT);
		new Button(shell, SWT.ARROW | SWT.CENTER);
		new Button(shell, SWT.CHECK);
		new Button(shell, SWT.RADIO);
		new Button(shell, SWT.TOGGLE);
		new Button(shell, SWT.FLAT);

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
