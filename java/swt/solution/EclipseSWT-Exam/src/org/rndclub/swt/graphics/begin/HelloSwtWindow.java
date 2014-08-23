package org.rndclub.swt.graphics.begin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloSwtWindow {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		// Shell shell = new Shell(display, SWT.NONE);
		// Shell shell = new Shell(display, SWT.NULL);
		// Shell shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
		// Shell shell = new Shell(display, SWT.NO_TRIM);
		// Shell shell = new Shell(display, SWT.TOOL);
		shell.setText("SWT HelloSWTWindow");

		int x = (display.getBounds().width - shell.getSize().x) / 2;
		int y = (display.getBounds().height - shell.getSize().y) / 2;

		shell.setLocation(x, y);
		shell.setSize(320, 240);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();
	}
}
