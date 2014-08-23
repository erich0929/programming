package org.rndclub.swt.graphics.image;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class GraphicsImageLabelTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Image Test");

		Label label = new Label(shell, SWT.PUSH);
		String path = "/org/rndclub/swt/res/images/ant.png";

		Image image = null;
		try {
			InputStream stream = GraphicsImageLabelTest.class.getResourceAsStream(path);
			if (stream != null) {
				ImageData imageData = new ImageData(stream);
				if (imageData != null) {
					image = new Image(display, imageData);
					label.setImage(image);
				}
			}
		} catch (SWTException e) {
			e.printStackTrace();
		}

		shell.setSize(64, 64);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		if (image != null) {
			image.dispose();
		}
		display.dispose();
	}
}
