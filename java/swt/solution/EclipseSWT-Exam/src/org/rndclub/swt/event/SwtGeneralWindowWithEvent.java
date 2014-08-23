package org.rndclub.swt.event;

import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SwtGeneralWindowWithEvent {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT Event Test");

		shell.addShellListener(new ShellListener() {
			public void shellActivated(ShellEvent e) {
				System.out.println("[SWT.Activate] e : " + e);
			}

			public void shellDeactivated(ShellEvent e) {
				System.out.println("[SWT.Deactivate] e : " + e);
			}

			public void shellIconified(ShellEvent e) {
				System.out.println("[SWT.Iconify] e : " + e);
			}

			public void shellDeiconified(ShellEvent e) {
				System.out.println("[SWT.Deiconify] e : " + e);
			}

			public void shellClosed(ShellEvent e) {
				System.out.println("[SWT.Close] e : " + e);
			}
		});

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
