package org.rndclub.swt.graphics.effects;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsXorTest {
	public static void main(String[] args) {
		final Display display = new Display();

		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsXor Test");

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;

				shell.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
				gc.setBackground(display.getSystemColor(SWT.COLOR_BLUE));

				gc.fillRectangle(40, 30, 180, 100);
				gc.setXORMode(true);

				gc.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
				gc.fillRectangle(60, 90, 90, 90);

				gc.setBackground(display.getSystemColor(SWT.COLOR_RED));
				gc.fillOval(180, 60, 120, 120);
			}
		});

		shell.setSize(340, 250);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}
