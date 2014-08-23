package org.rndclub.swt.graphics.font;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class FontTest {
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Font Test");

		shell.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = new GC(shell);
				Font font = new Font(display, "Times", 30, SWT.BOLD
						| SWT.ITALIC);

				gc.setFont(font);

				gc.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
				gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));

				String str = "Hello, SWT!!!";
				Point size = gc.textExtent(str);
				gc.fillRectangle(8, 8, size.x, size.y);
				gc.drawText(str, 8, 8, true);

				gc.drawText(str, 8, 8 + size.y, true);
				gc.drawText(str, 8, 8 + size.y * 2, false);
				
				font.dispose();
				gc.dispose();
			}
		});

		shell.setSize(270, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
