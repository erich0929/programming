package org.rndclub.swt.graphics.color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class DirectPaletteTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT DirectPalette Test");

		PaletteData palData = new PaletteData(0xff, 0xff00, 0xff0000);
		ImageData imageData = new ImageData(256, 256, 24, palData);
		for (int x = 0; x < 256; x++) {
			for (int y = 0; y < 256; y++) {
				int rgb = (0 << 16) | (x << 8) | y;
				imageData.setPixel(x, y, rgb);
			}
		};
		final Image image = new Image(display, imageData);

		shell.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				gc.drawImage(image, 0, 0);
			}
		});

		shell.setSize(256 + 8, 256 + 34);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		image.dispose();
		display.dispose();
	}
}
