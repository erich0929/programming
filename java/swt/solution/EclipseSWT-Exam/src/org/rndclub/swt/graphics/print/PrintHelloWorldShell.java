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
package org.rndclub.swt.graphics.print;

/*
 * Printing example snippet: print "Hello World!" in black, outlined in red, to
 * default printer
 * 
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class PrintHelloWorldShell {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.open();
		shell.setSize(40, 54);

		Color black = display.getSystemColor(SWT.COLOR_BLACK);
		Color white = display.getSystemColor(SWT.COLOR_WHITE);
		Color red = display.getSystemColor(SWT.COLOR_RED);

		GC gc = new GC(shell);

		gc.setBackground(white);
		gc.setForeground(black);

		String testString = "Hello World!";
		Point extent = gc.stringExtent(testString);
		gc.drawString(testString, 2, 2);
		gc.setForeground(red);
		gc.drawRectangle(2, 2, extent.x, extent.y);
		gc.dispose();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
