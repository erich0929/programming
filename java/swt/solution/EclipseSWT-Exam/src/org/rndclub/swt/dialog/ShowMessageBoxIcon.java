package org.rndclub.swt.dialog;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class ShowMessageBoxIcon {
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("SWT GridLayout Test");

		int icons[] = new int[]{SWT.ICON_ERROR, SWT.ICON_INFORMATION,
				SWT.ICON_QUESTION, SWT.ICON_WARNING, SWT.ICON_WORKING};
		String names[] = new String[]{"ERROR", "INFORMATION", "QUESTION",
				"WARNING", "WORKING"};
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		shell.setLayout(gridLayout);
		for (int i = 0; i < icons.length; i++) {
			Button b = new Button(shell, SWT.PUSH);
			b.setImage(display.getSystemImage(icons[i]));

			Label l = new Label(shell, SWT.PUSH);
			l.setText(names[i]);
		}

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
