package org.rndclub.swt.program;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ProgramDocTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT Program Test");
		shell.setLayout(new FillLayout());

		Label icon = new Label(shell, SWT.NONE);
		Label name = new Label(shell, SWT.NONE);

		Image image = null;
		Program p = Program.findProgram(".doc");
		if (p != null) {
			System.out.println("name : " + p.getName());
			name.setText(p.getName());
			ImageData data = p.getImageData();
			if (data != null) {
				image = new Image(display, data);
				icon.setImage(image);
			}
		}

		icon.pack();
		name.pack();
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		if (image != null) {
			image.dispose();
		}
		display.dispose();
	}
}
