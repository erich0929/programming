package org.rndclub.swt.graphics.intro;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsDrawTextTransparentTest {
	public static void main(String[] args) {
		final Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsDrawTextTransparent Test");

		Class c = GraphicsDrawTextTransparentTest.class;
		InputStream stream = c
				.getResourceAsStream("/org/rndclub/swt/res/images/idea.jpg");
		ImageData imageData = new ImageData(stream);
		final Image image = new Image(display, imageData);

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;

				gc.drawImage(image, 0, 0);

				gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
				gc.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));

				Font font = new Font(display, "Arial", 14, SWT.BOLD
						| SWT.ITALIC);
				gc.setFont(font);
				gc.drawString("Hello, SWT!", 6, 10, false);
				gc.drawString("Hello, SWT!", 6, 35, true);
				font.dispose();
			}
		});

		shell.setSize(140, 130);

		Rectangle bounds = shell.getClientArea();
		System.out.println("[CanvasGraphicsTest-main] bounds : " + bounds);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		image.dispose();
		display.dispose();
	}
}
