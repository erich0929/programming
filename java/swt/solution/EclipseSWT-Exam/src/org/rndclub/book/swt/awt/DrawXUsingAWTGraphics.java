package org.rndclub.book.swt.awt;

/*
 * example snippet: draw an X using AWT Graphics
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.0
 */
import java.awt.Frame;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.awt.SWT_AWT;

public class DrawXUsingAWTGraphics {

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		Composite composite = new Composite(shell, SWT.EMBEDDED);

		/* Draw an X using AWT */
		Frame frame = SWT_AWT.new_Frame(composite);
		Canvas canvas = new Canvas() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g) {
				Dimension d = getSize();
				g.drawLine(0, 0, d.width, d.height);
				g.drawLine(d.width, 0, 0, d.height);
			}
		};
		frame.add(canvas);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
