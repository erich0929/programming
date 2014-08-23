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
package org.rndclub.swt.dialog;

/*
 * Printing example snippet: print text to printer, with word wrap and
 * pagination
 * 
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class PrintDialogTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT PrintDialog Test");

		PrintDialog dialog = new PrintDialog(shell, SWT.NONE);
		dialog.setStartPage(2);
		dialog.setEndPage(4);
		dialog.setScope(8);
		dialog.setPrintToFile(true);
		dialog.setText("SWT Print");
		PrinterData printerData = dialog.open();

		System.out.println("printerData : " + printerData);
		if (printerData != null) {
			System.out.println("printerData : " + printerData.printToFile);
			Printer printer = new Printer(printerData);
			System.out.println("printer : " + printer);

			GC gc = new GC(printer);
			gc.drawText("Hello SWT Print!!!", 8, 8);
			gc.dispose();

			printer.dispose();
		}

	}
}
