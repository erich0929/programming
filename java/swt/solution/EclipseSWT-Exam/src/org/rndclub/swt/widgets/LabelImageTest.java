package org.rndclub.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.rndclub.swt.graphics.intro.GraphicsUtil;

public class LabelImageTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT LabelImage Test");

		GraphicsUtil.init(display);

		Label l1 = new Label(shell, SWT.PUSH);
		l1.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_ANT));
		l1.setBackground(GraphicsUtil.COLOR_CYAN);

		Label l2 = new Label(shell, SWT.PUSH | SWT.LEFT);
		l2.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_BUG));
		l2.setText("Bug");
		l2.setBackground(GraphicsUtil.COLOR_YELLOW);

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
