package org.rndclub.swt.ole;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OleControlSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class OleInternetExplorerByProgramIdTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT EmbedOleObject Test");

		OleFrame frame = new OleFrame(shell, SWT.NONE);
		final OleControlSite controlSite = new OleControlSite(frame, SWT.NONE,
				"Shell.Explorer");
		controlSite.setEnabled(true);
		controlSite.setVisible(true);
		//		controlSite.doVerb(OLE.OLEIVERB_SHOW);
		System.out.println("controlSite : " + controlSite);

		shell.addShellListener(new ShellAdapter() {
			public void shellActivated(ShellEvent e) {
				controlSite.setEnabled(true);
			}

			public void shellDeactivated(ShellEvent e) {
				controlSite.setEnabled(false);
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