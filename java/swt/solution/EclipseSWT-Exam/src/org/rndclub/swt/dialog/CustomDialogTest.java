package org.rndclub.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class CustomDialogTest extends Dialog {
	int result = SWT.CANCEL;
	Button yesButton = null;
	Button noButton = null;
	Shell shell = null;
	Shell parent = null;

	public CustomDialogTest(Shell parent, int style) {
		super(parent, style);
		this.parent = parent;
	}
	public CustomDialogTest(Shell parent) {
		this(parent, SWT.DEFAULT);
		this.parent = parent;
	}

	public int open() {
		shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText("SWT MyDialog");
		shell.setLayout(new FillLayout());

		Composite comp = new Composite(shell, SWT.PUSH);
		comp.setLayout(new FillLayout());// s ;new GridLayout());

		Listener listener = new Listener() {
			public void handleEvent(Event event) {
				if (event.type == SWT.Selection) {
					System.out.println("[Selection] event : " + event);
					if (event.widget == yesButton) {
						result = SWT.YES;
						shell.dispose();
					} else if (event.widget == noButton) {
						result = SWT.NO;
						shell.dispose();
					}
					System.out.println("[Selection] result : " + result);
				}
			}
		};

		yesButton = new Button(comp, SWT.PUSH);
		yesButton.setText("Yes");
		yesButton.addListener(SWT.Selection, listener);

		noButton = new Button(comp, SWT.PUSH);
		noButton.setText("No");
		noButton.addListener(SWT.Selection, listener);

		shell.pack();
		shell.open();
		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		return result;
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		CustomDialogTest dialog = new CustomDialogTest(shell);
		int result = dialog.open();
		System.out.println("[main] result : " + result);
		System.out.println("[main] SWT.CANCEL : " + SWT.CANCEL);
		System.out.println("[main] SWT.YES : " + SWT.YES);
		System.out.println("[main] SWT.NO : " + SWT.NO);
	}
}
