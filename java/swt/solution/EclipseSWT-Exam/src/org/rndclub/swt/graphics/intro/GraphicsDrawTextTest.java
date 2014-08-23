package org.rndclub.swt.graphics.intro;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsDrawTextTest {
	public static void main(String[] args) {
		final Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsDrawText Test");

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		// final Canvas canvas = new Canvas(shell, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;

				gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
				gc.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));

				gc.drawString("Hello, \tSWT graphics\n by drawString!", 10, 10);
				gc.drawText("Hello, \tSWT graphics\n by drawText!", 10, 30);

				Font font = new Font(display, "Arial", 14, SWT.BOLD
						| SWT.ITALIC);
				gc.setFont(font);
				gc.drawString("Hello, \tSWT graphics\n by drawString with true!", 10,
						70, true);
				gc.drawText("Hello, \tSWT graphics\n by drawText with fasle!",
						10, 100, false);
				font.dispose();
			}
		});

		shell.setSize(450, 190);

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
