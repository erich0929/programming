package org.rndclub.swt.graphics.font;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class FontMetricsTest {
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT FontMetrics Test");

		shell.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = new GC(shell);

				Font font = new Font(display, "Times", 30, SWT.NONE);
				gc.setFont(font);
				FontMetrics fm = gc.getFontMetrics();

				int ascent = fm.getAscent();
				int averageWidth = fm.getAverageCharWidth();
				int descent = fm.getDescent();
				int height = fm.getHeight();
				int leading = fm.getLeading();

				String[] names = new String[]{"Ascent", "AverageCharWidth",
						"Descent", "Height", "Leading"};
				int[] values = new int[]{ascent, averageWidth, descent, height,
						leading};

				int y = 8;
				for (int i = 0; i < names.length; i++) {
					String str = names[i] + " : " + values[i];
					Point size = gc.textExtent(str);

					gc.drawText(str, 8, y, true);
					y += size.y + 4;
				}

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
