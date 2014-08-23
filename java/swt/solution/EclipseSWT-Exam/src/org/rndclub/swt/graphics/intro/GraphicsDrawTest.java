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

public class GraphicsDrawTest {
	public static void main(String[] args) {
		final Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsDraw Test");

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		// final Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
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

				gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
				gc.drawString("Hello, SWT graphics\n by drawString!", 10, 140);
				gc.drawText("Hello, \tSWT graphics\n by drawText!", 10, 160);
				gc.drawText("Hello, \tSWT graphics by drawText with true!", 10,
						200, true);
				gc.drawText("Hello, \tSWT graphics by drawText with fasle!", 10,
						220, false);

				gc.setForeground(display.getSystemColor(SWT.COLOR_DARK_GRAY));
				gc.drawRectangle(10, 80, 46, 36);
				gc.drawRoundRectangle(60, 80, 46, 36, 10, 10);

				gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
				gc.setLineStyle(SWT.LINE_SOLID);
				for (int i = 1; i < 6; i++) {
					gc.setLineWidth(i);
					gc.drawLine(115, 80 + i * 8, 175, 80 + i * 8);
				}

				gc.setLineStyle(SWT.LINE_DOT);
				for (int i = 1; i < 6; i++) {
					gc.setLineWidth(i);
					gc.drawLine(185, 80 + i * 8, 245, 80 + i * 8);
				}

				gc.setLineStyle(SWT.LINE_DASH);
				for (int i = 1; i < 6; i++) {
					gc.setLineWidth(i);
					gc.drawLine(255, 80 + i * 8, 305, 80 + i * 8);
				}

				gc.setLineStyle(SWT.LINE_DASHDOT);
				for (int i = 1; i < 6; i++) {
					gc.setLineWidth(i);
					gc.drawLine(315, 80 + i * 8, 365, 80 + i * 8);
				}

				gc.setLineStyle(SWT.LINE_DASHDOTDOT);
				for (int i = 1; i < 6; i++) {
					gc.setLineWidth(i);
					gc.drawLine(375, 80 + i * 8, 425, 80 + i * 8);
				}
			}
		});

		shell.setSize(440, 280);

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
