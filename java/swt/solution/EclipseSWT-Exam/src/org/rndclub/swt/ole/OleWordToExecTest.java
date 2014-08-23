package org.rndclub.swt.ole;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class OleWordToExecTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT EmbedOleObject Test");

		OleFrame frame = new OleFrame(shell, SWT.NONE);
		final File file = new File("E:\\temp\\»õ¹®¼­.doc");
		final OleClientSite clientSite = new OleClientSite(frame, SWT.NONE,
				file);
		System.out.println("clientSite : " + clientSite);

		shell.setSize(640, 480);
		shell.open();

		int result = clientSite.queryStatus(OLE.OLECMDID_PRINT);
		if ((result & OLE.OLECMDF_ENABLED) == OLE.OLECMDF_ENABLED) {
			clientSite.exec(OLE.OLECMDID_PRINT, OLE.OLECMDEXECOPT_PROMPTUSER,
					null, null);
		}
		System.out.println("result : " + result);
		System.out.println("OLECMDF_ENABLED : " + OLE.OLECMDF_ENABLED);
		System.out.println("OLECMDF_ENABLED : " + (result & OLE.OLECMDF_ENABLED));

		frame.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				clientSite.setEnabled(true);
			}

			public void focusLost(FocusEvent e) {
			}

		});

		shell.addShellListener(new ShellAdapter() {
			public void shellActivated(ShellEvent e) {
				clientSite.setEnabled(true);
			}

			public void shellDeactivated(ShellEvent e) {
				clientSite.setEnabled(false);
			}
		});

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}