package org.rndclub.book.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.*;

public class UiThreadTest {
	Display display = null;
	Shell shell = null;
	Button button = null;

	public UiThreadTest() {
		createUI();
		setLayout();
		addListener();
	}

	public void createUI() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("Eclipse SWT");

		button = new Button(shell, SWT.PUSH);
		button.setText("Hello SWT World!");
		button.pack();

		shell.pack();
	}

	public void setLayout() {
	}

	public void addListener() {
		button.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				GenThread genThread = new GenThread(UiThreadTest.this);
				genThread.start();
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
	}

	public void setText(String str) {
		button.setText(str);
	}

	public void run() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	public static void main(String[] args) {
		UiThreadTest uiThreadTest = new UiThreadTest();
		uiThreadTest.run();
	}
}
