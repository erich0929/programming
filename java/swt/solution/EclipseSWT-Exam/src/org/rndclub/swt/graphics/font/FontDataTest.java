package org.rndclub.swt.graphics.font;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class FontDataTest {
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT FontData Test");

		shell.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				Font font = new Font(display, "Times", 12, SWT.BOLD
						| SWT.ITALIC);
				FontData[] fd = font.getFontData();

				GC gc = new GC(shell);
				gc.setFont(font);

				int y = 8;
				String[] names = new String[]{"height", "locale", "name",
						"style"};
				FontData[] rd = font.getFontData();
				for (int i = 0; i < rd.length; i++) {
					for (int n = 0; n < names.length; n++) {
						String height = "" + fd[i].getHeight();
						String locale = fd[i].getLocale();
						String name = fd[i].getName();
						String style = "" + fd[i].getStyle();
						String[] values = new String[]{height, locale, name,
								style};

						String str = names[n] + " : " + values[n];
						Point size = gc.textExtent(str);

						gc.drawText(str, 8, y, true);
						y += size.y + 4;
					}
					y += 8;
					String str = "FontData[" + i + "] : " + fd[i];
					gc.drawText(str, 8, y, true);
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
