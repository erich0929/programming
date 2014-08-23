package org.rndclub.swt.graphics.intro;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class DrawOvalTest {
	public static void main(String[] args) {
		final Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsDraw Test");

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;

				gc.setForeground(display.getSystemColor(SWT.COLOR_YELLOW));
				gc.setLineStyle(SWT.LINE_DOT);
				gc.drawRectangle(20, 20, 80, 50);

				gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
				gc.setLineStyle(SWT.LINE_SOLID);
				gc.drawOval(20, 20, 80, 50);
			}
		});

		shell.setSize(100, 120);

		Rectangle bounds = shell.getClientArea();
		System.out.println("[CanvasGraphicsTest-main] bounds : " + bounds);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}