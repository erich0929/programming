package org.rndclub.swt.graphics.color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class IndexedPaletteTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT IndexedPalette Test");

		RGB[] rgbs = new RGB[]{new RGB(255, 0, 0), new RGB(0, 255, 0)};
		PaletteData palData = new PaletteData(rgbs);
		ImageData imageData = new ImageData(128, 128, 1, palData);
		int i = 0;
		for (int x = 0; x < 128; x++) {
			for (int y = 0; y < 128; y++) {
				if ((i % 8) < 4) {
					imageData.setPixel(x, y, 0);
				} else {
					imageData.setPixel(x, y, 1);
				}
				i++;
			}
		}
		// for (int x = 11; x < 35; x++) {
		// for (int y = 11; y < 35; y++) {
		// imageData.setPixel(x, y, 1);
		// }
		// }

		final Image image = new Image(display, imageData);
		shell.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				gc.drawImage(image, 0, 0);
			}
		});

		shell.setSize(128 + 8, 128 + 34);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		image.dispose();
		display.dispose();
	}
}
