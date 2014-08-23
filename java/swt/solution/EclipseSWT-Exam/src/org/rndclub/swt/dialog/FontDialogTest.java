package org.rndclub.swt.dialog;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Shell;

public class FontDialogTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT ColorDialog & RGB Test");
		shell.setSize(320, 240);

		Font font = display.getSystemFont();
		FontData[] fontDataList = font.getFontData();

		FontDialog fontDialog = new FontDialog(shell);
		fontDialog.setFontList(fontDataList);
		FontData fontData = fontDialog.open();

		System.out.println("fontData : " + fontData);
		if (fontData != null) {
			font = new Font(display, fontData);
			System.out.println("font : " + font);
			font.dispose();
		}

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
