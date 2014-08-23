/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.rndclub.swt.layout;

/*
 * FormLayout example snippet: create a simple OK/CANCEL dialog using form
 * layout
 * 
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class RowLayoutPackTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT RowLayout Test");

		RowLayout rowLayout = new RowLayout();
		// rowLayout.pack = true;
		rowLayout.pack = false;
		shell.setLayout(rowLayout);
		for (int i = 0; i < 8; i++) {
			Button button = new Button(shell, SWT.PUSH);
			if ((i % 2) == 0) {
				button.setText("A-" + i);
			} else {
				button.setText("LARGE A-" + i);
			}
		}

		shell.setSize(240, 96);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
