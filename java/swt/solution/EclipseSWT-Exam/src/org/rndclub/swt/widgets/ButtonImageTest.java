package org.rndclub.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.rndclub.swt.graphics.intro.GraphicsUtil;

public class ButtonImageTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT ButtonImage Test");

		GraphicsUtil.init(display);

		Button b1 = new Button(shell, SWT.PUSH);
		b1.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_ANT));
		b1.setText("Ant");

		Button b2 = new Button(shell, SWT.PUSH);
		b2.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_BUG));
		b2.setText("Bug");

		shell.setLayout(new FillLayout());

		shell.setSize(240, 172);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		GraphicsUtil.dispose();
		display.dispose();
	}
}
