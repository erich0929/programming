package org.rndclub.swt.graphics.font;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FontDialogTest {
	Display display;
	Shell shell;

	Text text;
	Font font;

	public static void main(String[] args) {
		new FontDialogTest().open();
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
		item.setText("&Font");

		Menu fontMenu = new Menu(shell, SWT.DROP_DOWN);
		item.setMenu(fontMenu);

		item = new MenuItem(fontMenu, SWT.PUSH);
		item.setText("Font...");
		item.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				menuFont();
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		if (font != null) {
			font.dispose();
		}
		display.dispose();
	}

	void menuFont() {
		FontDialog fontDialog = new FontDialog(shell);
		fontDialog.setFontList(text.getFont().getFontData());
		FontData fontData = fontDialog.open();
		if (fontData != null) {
			if (font != null) {
				font.dispose();
			}
			font = new Font(display, fontData);
			text.setFont(font);
		}
	}
}
