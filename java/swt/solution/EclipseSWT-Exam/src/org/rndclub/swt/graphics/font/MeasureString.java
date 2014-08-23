package org.rndclub.swt.graphics.font;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class MeasureString {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new RowLayout());

		Label label = new Label(shell, SWT.NONE);
		GC gc = new GC(label);
		Point size = gc.textExtent("Hello");
		gc.dispose();

		label.setText("Hello -> " + size);

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
