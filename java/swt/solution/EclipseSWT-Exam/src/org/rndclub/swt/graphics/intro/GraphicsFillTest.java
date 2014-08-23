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

public class GraphicsFillTest {
	public static void main(String[] args) {
		final Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsFill Test");

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		// final Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;

				gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
				gc.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));

				gc.fillOval(4, 4, 46, 36);
				gc.fillArc(54, 4, 46, 36, 0, 300);

				int[] points = new int[]{104, 4, 154, 4, 127, 40};
				gc.fillPolygon(points);

				points = new int[]{154, 4, 204, 4, 177, 40};
				gc.fillPolygon(points);

				gc.drawRectangle(4, 44, 46, 36);
				gc.fillRectangle(4, 44, 46, 36);

				gc.drawRoundRectangle(54, 44, 46, 36, 10, 10);
				gc.fillRoundRectangle(54, 44, 46, 36, 10, 10);

				gc.setForeground(display.getSystemColor(SWT.COLOR_CYAN));
				gc.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
				gc.drawRectangle(104, 44, 46, 36);
				gc.fillGradientRectangle(104, 44, 46, 36, true);

				gc.setForeground(display.getSystemColor(SWT.COLOR_CYAN));
				gc.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
				gc.drawRoundRectangle(154, 44, 46, 36, 10, 10);
				gc.fillGradientRectangle(154, 44, 46, 36, false);
			}
		});

		shell.setSize(220, 120);

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
