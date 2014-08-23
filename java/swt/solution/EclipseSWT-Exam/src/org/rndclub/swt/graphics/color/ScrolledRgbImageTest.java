package org.rndclub.swt.graphics.color;

import java.io.InputStream;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class ScrolledRgbImageTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsSimpleScribble Test");

		final ScrolledComposite sc = new ScrolledComposite(shell, SWT.BORDER
				| SWT.H_SCROLL | SWT.V_SCROLL);

		Class c = ScrolledRgbImageTest.class;
		String path = "/org/rndclub/swt/res/images/rgb.gif";
		InputStream stream = c.getResourceAsStream(path);
		ImageData imageData = new ImageData(stream);
		final Image image = new Image(display, imageData);

		Canvas canvas = new Canvas(sc, SWT.NO_REDRAW_RESIZE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.drawImage(image, 0, 0);
			}
		});
		Rectangle bounds = image.getBounds();
		canvas.setSize(bounds.width, bounds.height);

		sc.setContent(canvas);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		sc.setMinSize(canvas.getSize());

		shell.setSize(320, 240);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
