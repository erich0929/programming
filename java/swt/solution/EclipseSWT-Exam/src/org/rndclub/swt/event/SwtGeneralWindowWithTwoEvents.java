package org.rndclub.swt.event;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SwtGeneralWindowWithTwoEvents {
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

		MouseTrackListener mouseTrackListener = new MouseTrackListener() {
			public void mouseEnter(org.eclipse.swt.events.MouseEvent e) {
				System.out.println("[SWT.MouseEnter] e : " + e);
				Button b = (Button) e.widget;
				b.setBackground(red);
			}

			public void mouseExit(org.eclipse.swt.events.MouseEvent e) {
				System.out.println("[SWT.MouseExit] e : " + e);
				Button b = (Button) e.widget;
				b.setBackground(white);
			}

			public void mouseHover(org.eclipse.swt.events.MouseEvent e) {
				System.out.println("[SWT.MouseHover] e : " + e);
			}
		};

		SelectionListener selectionListener = new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				System.out.println("[SWT.Selection] e : " + e);
				shell.close();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println("[SWT.DefaultSelection] e : " + e);
			}
		};

		yesButton.addMouseTrackListener(mouseTrackListener);
		yesButton.addSelectionListener(selectionListener);

		noButton.addMouseTrackListener(mouseTrackListener);

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
