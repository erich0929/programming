package org.rndclub.swt.event;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class SwtGeneralWindowByShellAdapter {
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("SWT Event Test");

		shell.addShellListener(new ShellAdapter() {
			public void shellClosed(ShellEvent e) {
				String title = "Confirm!!!";
				String message = "정말로 빠져나가시겠습니까?";
				int style = SWT.OK | SWT.CANCEL | SWT.ICON_QUESTION;
				MessageBox dialog = new MessageBox(shell, style);
				dialog.setText(title);
				dialog.setMessage(message);

				int flag = dialog.open();
				if (flag == SWT.OK) {
					e.doit = true;
				} else {
					e.doit = false;
				}
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
