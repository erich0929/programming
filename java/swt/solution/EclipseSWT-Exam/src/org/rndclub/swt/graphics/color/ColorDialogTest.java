package org.rndclub.swt.graphics.color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ColorDialogTest {
	Display display;
	Shell shell;

	Text text;
	Color foregroundColor, backgroundColor;

	public static void main(String[] args) {
		new ColorDialogTest().open();
	}

	void open() {
		display = new Display();
		shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT ColorDialog & RGB Test");
		shell.setSize(480, 240);

		text = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL
				| SWT.H_SCROLL);

		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);

		MenuItem item = new MenuItem(menuBar, SWT.CASCADE);
		item.setText("&Color");

		Menu colorMenu = new Menu(shell, SWT.DROP_DOWN);
		item.setMenu(colorMenu);

		item = new MenuItem(colorMenu, SWT.PUSH);
		item.setText("Foreground Color...");
		item.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				menuForegroundColor();
			}
		});

		item = new MenuItem(colorMenu, SWT.PUSH);
		item.setText("Background Color...");
		item.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				menuBackgroundColor();
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		if (foregroundColor != null) {
			foregroundColor.dispose();
		}
		if (backgroundColor != null) {
			backgroundColor.dispose();
		}
		display.dispose();
	}

	void menuForegroundColor() {
		ColorDialog colorDialog = new ColorDialog(shell);
		colorDialog.setRGB(text.getForeground().getRGB());
		RGB rgb = colorDialog.open();
		if (rgb != null) {
			if (foregroundColor != null)
				foregroundColor.dispose();
			foregroundColor = new Color(display, rgb);
			text.setForeground(foregroundColor);
		}
	}

	void menuBackgroundColor() {
		ColorDialog colorDialog = new ColorDialog(shell);
		colorDialog.setRGB(text.getBackground().getRGB());
		RGB rgb = colorDialog.open();
		if (rgb != null) {
			if (backgroundColor != null)
				backgroundColor.dispose();
			backgroundColor = new Color(display, rgb);
			text.setBackground(backgroundColor);
		}
	}
}
