package org.rndclub.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ColorDialogTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT ColorDialog & RGB Test");
		shell.setSize(320, 240);

		Color color = display.getSystemColor(SWT.COLOR_BLUE);
		RGB rgb = color.getRGB();

		ColorDialog colorDialog = new ColorDialog(shell);
		colorDialog.setRGB(rgb);
		rgb = colorDialog.open();

		System.out.println("rgb : " + rgb);
		if (rgb != null) {
			color = new Color(display, rgb);
			System.out.println("color : " + color);
			color.dispose();
		}

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
