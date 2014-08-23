package org.rndclub.swt.event;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class SwtGeneralWindowWithListener {
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Event Test");

		Button yesButton = new Button(shell, SWT.PUSH);
		yesButton.setText("예");
		Button noButton = new Button(shell, SWT.PUSH);
		noButton.setText("아니오");

		final Color black = display.getSystemColor(SWT.COLOR_BLACK);
		final Color red = display.getSystemColor(SWT.COLOR_RED);
		final Color white = display.getSystemColor(SWT.COLOR_WHITE);

		yesButton.setForeground(black);
		yesButton.setBackground(white);
		noButton.setForeground(black);
		noButton.setBackground(white);

		Listener listener = new Listener() {
			public void handleEvent(Event e) {
				Button b = null;
				switch (e.type) {
					case SWT.MouseEnter :
						System.out.println("[SWT.MouseEnter] e : " + e);
						b = (Button) e.widget;
						b.setBackground(red);
						break;
					case SWT.MouseExit :
						System.out.println("[SWT.MouseExit] e : " + e);
						b = (Button) e.widget;
						b.setBackground(white);
						break;
					case SWT.Selection :
						System.out.println("[SWT.Selection] e : " + e);
						shell.close();
						break;
				}
			}
		};

		yesButton.addListener(SWT.MouseEnter, listener);
		yesButton.addListener(SWT.MouseExit, listener);
		yesButton.addListener(SWT.Selection, listener);

		noButton.addListener(SWT.MouseEnter, listener);
		noButton.addListener(SWT.MouseExit, listener);

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
