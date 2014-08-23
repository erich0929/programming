package org.rndclub.fd.ui;

/*
 * Shell example snippet: create a splash screen
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class Loader {
	static int BAR_HEIGHT = 32;

	static Display display = null;

	static Shell shell = null;

	static Image image = null;

	static ProgressBar bar = null;

	static int progressBar = 0;

	public static Display init(Shell pShell, int max) {
		// Display display = new Display();
		display = pShell.getDisplay();
		shell = new Shell(pShell, SWT.ON_TOP | SWT.CENTER);

		System.out.println("IMAGE_SFG_CI:"
				+ GraphicsModel.getImageName(GraphicsModel.IMAGE_PENTA_LOGO));
		image = GraphicsModel.loadImage(display, GraphicsModel
				.getImageName(GraphicsModel.IMAGE_PENTA_LOGO));
		System.out.println("IMAGE_PENTA_LOGO:" + image);
		bar = new ProgressBar(shell, SWT.NONE);
		bar.setMaximum(max);

		Label label = new Label(shell, SWT.NONE);
		label.setImage(image);

		FormLayout layout = new FormLayout();
		shell.setLayout(layout);

		FormData labelData = new FormData();
		labelData.right = new FormAttachment(100, 0);
		labelData.bottom = new FormAttachment(100, -BAR_HEIGHT);
		label.setLayoutData(labelData);

		FormData progressData = new FormData();
		progressData.left = new FormAttachment(0, 5);
		progressData.right = new FormAttachment(100, -5);
		progressData.bottom = new FormAttachment(100, -(5));
		bar.setLayoutData(progressData);

		shell.setSize(image.getBounds().width, image.getBounds().height
				+ BAR_HEIGHT);// .pack();

		// LoggerModel.logln("image:" + image.getBounds() + ", bar:"
		// + bar.getBounds());

		Rectangle splashRect = shell.getBounds();
		Rectangle displayRect = display.getBounds();
		int x = (displayRect.width - splashRect.width) / 2;
		int y = (displayRect.height - splashRect.height) / 2;
		shell.setLocation(x, y);
		shell.open();

		return (display);
	}
	public static void destroy() {
		if (shell != null) {
			shell.close();
		}
		if (image != null) {
			image.dispose();
		}
	}

	public static void incSelection(int i) {
		progressBar += i;
		setSelection(progressBar);
	}

	public static void setSelection(int i) {
		if (bar != null) {
			progressBar = i;
			bar.setSelection(progressBar);
			bar.redraw();
		}
	}
}
