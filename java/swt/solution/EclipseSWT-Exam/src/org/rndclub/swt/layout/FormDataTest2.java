package org.rndclub.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FormDataTest2 {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT FormData Test");

		FormLayout formLayout = new FormLayout();
		shell.setLayout(formLayout);

		Button b1 = new Button(shell, SWT.PUSH);
		Button b2 = new Button(shell, SWT.PUSH);
		Button b3 = new Button(shell, SWT.PUSH);
		b1.setText("B 1");
		b2.setText("Button 2");
		b3.setText("Button 3");

		FormData formData1 = new FormData();
		formData1.left = new FormAttachment(0, 5);
		formData1.right = new FormAttachment(25, 0);
		b1.setLayoutData(formData1);

		FormData formData2 = new FormData();
		formData2.left = new FormAttachment(b1, 5);
		formData2.right = new FormAttachment(90, -5);
		b2.setLayoutData(formData2);

		FormData formData3 = new FormData();
		formData3.top = new FormAttachment(b2, 5);
		formData3.bottom = new FormAttachment(100, -5);
		formData3.left = new FormAttachment(25, 5);
		formData3.right = new FormAttachment(100, -5);
		b3.setLayoutData(formData3);

		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
