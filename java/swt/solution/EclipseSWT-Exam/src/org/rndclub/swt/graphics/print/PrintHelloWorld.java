package org.rndclub.swt.graphics.print;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.printing.*;

public class PrintHelloWorld {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.open();

		PrinterData data = Printer.getDefaultPrinterData();
		if (data == null) {
			System.out.println("Warning: No default printer.");
			return;
		}

		Printer printer = new Printer(data);
		if (printer.startJob("SWT PrintHelloWorld")) {
			Color black = printer.getSystemColor(SWT.COLOR_BLACK);
			Color white = printer.getSystemColor(SWT.COLOR_WHITE);
			Color red = printer.getSystemColor(SWT.COLOR_RED);

			Rectangle trim = printer.computeTrim(0, 0, 0, 0);
			Point dpi = printer.getDPI();
			int leftMargin = dpi.x + trim.x;
			int topMargin = dpi.y / 2 + trim.y;

			GC gc = new GC(printer);
			Font font = gc.getFont();
			if (printer.startPage()) {
				gc.setBackground(white);
				gc.setForeground(black);

				String testString = "Hello World!";
				Point extent = gc.stringExtent(testString);
				gc.drawString(testString, leftMargin, topMargin
						+ font.getFontData()[0].getHeight());
				gc.setForeground(red);
				gc.drawRectangle(leftMargin, topMargin, extent.x, extent.y);

				printer.endPage();
			}
			gc.dispose();
			printer.endJob();
		}
		printer.dispose();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
