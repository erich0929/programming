package org.rndclub.swt.graphics.cursor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class CursorPrecedenceTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT CursorPrecedence Test");

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		shell.setLayout(gridLayout);

		List list = new List(shell, SWT.BORDER);
		Button button = new Button(shell, SWT.NONE);
		button.setText("Button");

		Cursor waitCursor = new Cursor(display, SWT.CURSOR_WAIT);
		shell.setCursor(waitCursor);

		Cursor beamCursor = new Cursor(display, SWT.CURSOR_IBEAM);
		list.setCursor(beamCursor);

		Cursor handCursor = new Cursor(display, SWT.CURSOR_HAND);
		button.setCursor(handCursor);

		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.HORIZONTAL_ALIGN_FILL;
		gridData.grabExcessHorizontalSpace = true;
		list.setLayoutData(gridData);

		gridData = new GridData();
		gridData.verticalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gridData.grabExcessHorizontalSpace = true;
		button.setLayoutData(gridData);

		shell.setSize(150, 150);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		waitCursor.dispose();
		beamCursor.dispose();
		handCursor.dispose();

		display.dispose();
	}
}
