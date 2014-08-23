package org.rndclub.swt.ole;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class OleWordByFileExtTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT EmbedOleObject Test");

		OleFrame frame = new OleFrame(shell, SWT.NONE);

		File file = new File("E:\\temp\\이클립스SWT.doc");
		final OleClientSite clientSite = new OleClientSite(frame, SWT.NONE,
				file);
		clientSite.setEnabled(true);
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