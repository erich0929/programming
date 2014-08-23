package org.rndclub.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public abstract class GeneralDialog implements GeneralDialogInterface {
	protected Shell dialog = null;

	protected Display display = null;

	boolean result = false;

	public GeneralDialog(Shell shell, int style) {
		this(shell, style, null);
	}

	public GeneralDialog(Shell shell, int style, String title) {
//		LoggerModel.logln("[GeneralDialog-GeneralDialog(" + shell + ", "
//				+ style + ", " + title + ")] ");

		display = shell.getDisplay();

		dialog = new Shell(shell, style);
		if (title != null) {
			dialog.setText(title);
		}

		Listener exitListener = new Listener() {
			public void handleEvent(Event e) {
				System.out.println("XXXXXXXXXXXXXXXXXXXX");
				result = false;
				dispose();
			}
		};

		dialog.addListener(SWT.Close, exitListener);
	}

	public void moveCenter() {
//		LoggerModel.logln("[GeneralDialog-moveCenter()] ");

		Rectangle r = dialog.getDisplay().getBounds();
//		LoggerModel.logln("[GeneralDialog-moveCenter] r : "+r);

		moveCenter(r.x, r.y, r.width, r.height);
	}

	public void moveCenter(Shell shell) {
//		LoggerModel.logln("[GeneralDialog-moveCenter("+shell+")] ");

		Rectangle r = shell.getBounds();
//		LoggerModel.logln("[GeneralDialog-moveCenter] r : "+r);

		moveCenter(r.x, r.y, r.width, r.height);
	}

	public void moveCenter(int x, int y, int w, int h) {
//		LoggerModel.logln("[GeneralDialog-moveCenter(" + x + ", " + y + ", "
//				+ w + ", " + h + ")] ");

		x += (w - dialog.getSize().x) / 2;
		y += (h - dialog.getSize().y) / 2;

		dialog.setLocation(x, y);
	}

	public boolean open() {
//		LoggerModel.logln("[GeneralDialog-open()] ");
		dialog.open();
		setFocus();
		result = true;
		while (!dialog.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return (result);
	}

	public void dispose() {
//		LoggerModel.logln("[GeneralDialog-dispose()] ");

		dialog.dispose();
	}

	public void setFocus() {
//		LoggerModel.logln("[GeneralDialog-setFocus()] ");
	}

	public void setEnabled(boolean flag) {
//		LoggerModel.logln("[GeneralDialog-setEnabled(" + flag + ")] ");
	}

	public void setStatus(final String str){
	}
}

