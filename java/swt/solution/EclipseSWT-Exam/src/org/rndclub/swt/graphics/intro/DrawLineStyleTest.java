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

public class DrawLineStyleTest {
	public static void main(String[] args) {
		final Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsDraw Test");

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;

				gc.setLineWidth(1);

				gc.setLineStyle(SWT.LINE_SOLID);
				gc.drawLine(20, 20, 200, 20);

				gc.setLineStyle(SWT.LINE_DOT);
				gc.drawLine(20, 30, 200, 30);

				gc.setLineStyle(SWT.LINE_DASH);
				gc.drawLine(20, 40, 200, 40);

				gc.setLineStyle(SWT.LINE_DASHDOT);
				gc.drawLine(20, 52, 200, 52);

				gc.setLineStyle(SWT.LINE_DASHDOTDOT);
				gc.drawLine(20, 70, 200, 70);
			}
		});

		shell.setSize(240, 130);

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
