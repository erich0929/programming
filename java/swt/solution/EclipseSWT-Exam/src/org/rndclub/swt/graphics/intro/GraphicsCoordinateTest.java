package org.rndclub.swt.graphics.intro;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsCoordinateTest {
	public static void main(String[] args) {
		final Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Coordinate System");

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;

				gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
				gc.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));

				gc.drawRectangle(10, 20, 46, 36);
				gc.drawRoundRectangle(60, 20, 46, 36, 8, 8);

				gc.drawOval(150, 20, 46, 36);
				gc.drawArc(200, 20, 46, 36, 0, 300);

				int points[] = new int[]{250, 20, 300, 20, 273, 56};
				gc.drawPolyline(points);

				points = new int[]{310, 20, 360, 20, 333, 56};
				gc.drawPolygon(points);

				points = new int[]{370, 20, 420, 20, 393, 56};
				gc.fillPolygon(points);

				gc.drawLine(350, 60, 396, 86);

				gc.setForeground(display.getSystemColor(SWT.COLOR_DARK_GRAY));
				gc.drawRectangle(10, 80, 46, 36);
				gc.drawRoundRectangle(60, 80, 46, 36, 10, 10);
			}
		});

		shell.setSize(440, 160);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}
