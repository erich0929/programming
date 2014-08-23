package org.rndclub.swt.ole;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class EmbedWordByProgramIdTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT EmbedOleObject Test");

		OleFrame frame = new OleFrame(shell, SWT.NONE);
		final OleClientSite clientSite = new OleClientSite(frame, SWT.NONE,
				"Word.Document");
		System.out.println("clientSite : " + clientSite);

		shell.addShellListener(new ShellAdapter() {
			public void shellActivated(ShellEvent e) {
				clientSite.setEnabled(true);
			}

			public void shellDeactivated(ShellEvent e) {
				clientSite.setEnabled(false);
			}
		});

		shell.setSize(640, 480);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}