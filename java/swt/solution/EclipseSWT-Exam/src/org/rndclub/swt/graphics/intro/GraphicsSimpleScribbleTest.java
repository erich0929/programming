package org.rndclub.swt.graphics.intro;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

public class GraphicsSimpleScribbleTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsSimpleScribble Test");

		final Canvas canvas = new Canvas(shell, SWT.NONE);
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

		display.dispose();
	}
}
