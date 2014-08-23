package org.rndclub.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LabelTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Eclipse SWT");

		Label l11 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		l11.setText("Label l11");
		l11.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
		Label l12 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		l12.setText("Label l12");
		l12.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
		Label l21 = new Label(shell, SWT.SHADOW_IN);
		l21.setText("Label l21");
		l21.setBackground(display.getSystemColor(SWT.COLOR_DARK_BLUE));
		Label l22 = new Label(shell, SWT.SHADOW_OUT);
		l22.setText("Label l22");
		l22.setBackground(display.getSystemColor(SWT.COLOR_DARK_CYAN));
		Label l23 = new Label(shell, SWT.SHADOW_NONE);
		l23.setText("Label l23");
		l23.setBackground(display.getSystemColor(SWT.COLOR_DARK_GRAY));
		Label l31 = new Label(shell, SWT.CENTER);
		l31.setText("Label l31");
		l31.setBackground(display.getSystemColor(SWT.COLOR_DARK_GREEN));
		Label l32 = new Label(shell, SWT.LEFT);
		l32.setText("Label l32");
		l32.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
		Label l33 = new Label(shell, SWT.RIGHT);
		l33.setText("Label l33");
		l33.setBackground(display.getSystemColor(SWT.COLOR_GREEN));
		Label l34 = new Label(shell, SWT.WRAP);
		l34.setText("Label l234567 89012345 67890");
		l34.setBackground(display.getSystemColor(SWT.COLOR_MAGENTA));

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
