package org.rndclub.book.swt.widgets;

/*
 * Caret example snippet: create a caret (using an image)
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class CreateCaretUsingImage {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.open();
		Caret caret = new Caret(shell, SWT.NONE);
		Color white = display.getSystemColor(SWT.COLOR_WHITE);
		Color black = display.getSystemColor(SWT.COLOR_BLACK);
		Image image = new Image(display, 20, 20);
		GC gc = new GC(image);
		gc.setBackground(black);
		gc.fillRectangle(0, 0, 20, 20);
		gc.setForeground(white);
		gc.drawLine(0, 0, 19, 19);
		gc.drawLine(19, 0, 0, 19);
		gc.dispose();
		caret.setLocation(10, 10);
		caret.setImage(image);
		gc = new GC(shell);
		gc.drawImage(image, 10, 64);
		caret.setVisible(false);
		gc.drawString("Test", 12, 12);
		caret.setVisible(true);
		gc.dispose();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		image.dispose();
		display.dispose();
	}
}