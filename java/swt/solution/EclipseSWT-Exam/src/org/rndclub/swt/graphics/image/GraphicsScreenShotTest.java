package org.rndclub.swt.graphics.image;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.custom.*;

public class GraphicsScreenShotTest {
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT GraphicsScreenShot Test");

		Button button = new Button(shell, SWT.PUSH);
		button.setText("ScreenShot");
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				GC gc = new GC(display);
				final Image image = new Image(display, display.getBounds());
				gc.copyArea(image, 0, 0);
				gc.dispose();

				Shell popup = new Shell(shell, SWT.SHELL_TRIM);
				popup.setLayout(new FillLayout());
				popup.setText("ScreenShot Image");
				popup.setBounds(50, 50, 200, 200);
				popup.addListener(SWT.Close, new Listener() {
					public void handleEvent(Event e) {
						image.dispose();
					}
				});

				ScrolledComposite sc = new ScrolledComposite(popup,
						SWT.V_SCROLL | SWT.H_SCROLL);
				Canvas canvas = new Canvas(sc, SWT.NONE);
				sc.setContent(canvas);
				canvas.setBounds(display.getBounds());
				canvas.addPaintListener(new PaintListener() {
					public void paintControl(PaintEvent e) {
						GC gc = e.gc;
						gc.drawImage(image, 0, 0);
					}
				});
				popup.open();
			}
		});

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
