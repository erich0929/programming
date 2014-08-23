package org.rndclub.swt.graphics.color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ColorScribbleTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT ColorScribble Test");

		final Color foreColor = new Color(display, 0xFF, 0x66, 0x33);
		final Color backColor = new Color(display, 0xFF, 0xff, 0xcc);
		
		final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setForeground(foreColor);
		canvas.setBackground(backColor);
		Listener listener = new Listener() {
			int lastX = 0, lastY = 0;
			public void handleEvent(Event event) {
				switch (event.type) {
					case SWT.MouseMove :
						if ((event.stateMask & SWT.BUTTON1) == 0) {
							break;
						}
						GC gc = new GC(canvas);
						gc.drawLine(lastX, lastY, event.x, event.y);
						gc.dispose();
					// FALL THROUGH
					case SWT.MouseDown :
						lastX = event.x;
						lastY = event.y;
						break;
				}
			}
		};

		canvas.addListener(SWT.MouseDown, listener);
		canvas.addListener(SWT.MouseMove, listener);

		shell.setSize(320, 240);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		foreColor.dispose();
		backColor.dispose();

		display.dispose();
	}
}
