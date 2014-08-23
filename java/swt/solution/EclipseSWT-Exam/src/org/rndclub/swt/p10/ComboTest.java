package org.rndclub.swt.p10;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class ComboTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setItems(new String[]{"A", "B", "C"});
		combo.setSize(200, 200);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
