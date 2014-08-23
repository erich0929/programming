package org.rndclub.swt.graphics.effects;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsNoRedrawTest {
	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsNoRedraw Test");

		final Color yellow = display.getSystemColor(SWT.COLOR_YELLOW);
		final Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		// final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;

				Rectangle bounds = canvas.getBounds();
				gc.setBackground(yellow);
				gc.fillOval(0, 0, bounds.width, bounds.height);
			}
		});

		shell.setSize(150, 150);

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
