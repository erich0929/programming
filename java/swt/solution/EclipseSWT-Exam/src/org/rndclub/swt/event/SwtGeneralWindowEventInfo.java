package org.rndclub.swt.event;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class SwtGeneralWindowEventInfo {
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Event Test");

		Button okButton = new Button(shell, SWT.PUSH);
		okButton.setText("OK");

		Listener listener = new Listener() {
			public void handleEvent(Event e) {
				if (e.type == SWT.Selection) {
					System.out.println("e.type : " + e.type);
					System.out.println("e.time : " + e.time);
					System.out.println("e.doit : " + e.doit);
					System.out.println("e.widget : " + e.widget);
					System.out.println("e.item : " + e.item);
					System.out.println("e.gc : " + e.gc);
					System.out.println("e.stateMask : " + e.stateMask);
					System.out.println("e.x  : " + e.x);
					System.out.println("e.y  : " + e.y);
					System.out.println("e.width : " + e.width);
					System.out.println("e.height : " + e.height);
					System.out.println("e.getBounds : " + e.getBounds());
					System.out.println("e    : " + e);

					shell.close();
				}
			}
		};

		okButton.addListener(SWT.Selection, listener);

		shell.setSize(240, 100);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();
	}
}
