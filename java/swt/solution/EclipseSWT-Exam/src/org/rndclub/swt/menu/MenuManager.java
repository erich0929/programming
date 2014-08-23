package org.rndclub.swt.menu;

/*
 * Control example snippet: update a status line when an item is armed
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.0
 */

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MenuManager implements Listener {
	public static int MENUITEM_MAX = 0;

	public static final int MENUITEM_FILE = MENUITEM_MAX++;
	public static final int MENUITEM_EDIT = MENUITEM_MAX++;
	public static final int MENUITEM_WINDOW = MENUITEM_MAX++;
	public static final int MENUITEM_FILE_NEW = MENUITEM_MAX++;
	public static final int MENUITEM_FILE_OPEN = MENUITEM_MAX++;
	public static final int MENUITEM_FILE_CLOSE = MENUITEM_MAX++;
	public static final int MENUITEM_FILE_EXIT = MENUITEM_MAX++;
	public static final int MENUITEM_EDIT_UNDO = MENUITEM_MAX++;
	public static final int MENUITEM_EDIT_REDO = MENUITEM_MAX++;
	public static final int MENUITEM_EDIT_CUT = MENUITEM_MAX++;
	public static final int MENUITEM_EDIT_COPY = MENUITEM_MAX++;
	public static final int MENUITEM_WINDOW_NEW = MENUITEM_MAX++;
	public static final int MENUITEM_WINDOW_OPEN = MENUITEM_MAX++;
	public static final int MENUITEM_WINDOW_CLOSE = MENUITEM_MAX++;
	public static final int MENUITEM_WINDOW_PREFER = MENUITEM_MAX++;
	public static final int MENUITEM_WINDOW_ABOUT = MENUITEM_MAX++;

	private static String[] menuStrings = {"File", "Edit", "Window", "New",
			"Open", "Close", "Exit", "Undo", "Redo", "Cut", "Copy",
			"New Window", "Open Window", "Close Window", "Preferences", "About"};

	private static MenuItem[] menuItems = new MenuItem[MENUITEM_MAX];

	Display display = null;

	Shell shell = null;

	Label label = null;

	Listener listener = null;

	public MenuManager(Display display, Shell shell, Listener listener) {
		this.display = display;
		this.shell = shell;

		if (listener == null) {
			listener = this;
			doLayout();
		}
		this.listener = listener;

		createMenu();
	}

	private void doLayout() {
		FormLayout layout = new FormLayout();
		shell.setLayout(layout);
		label = new Label(shell, SWT.BORDER);

		FormData labelData = new FormData();
		labelData.left = new FormAttachment(0);
		labelData.right = new FormAttachment(100);
		labelData.bottom = new FormAttachment(100);
		label.setLayoutData(labelData);
	}

	private void createMenu() {
		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);

		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileMenu.addListener(SWT.Hide, listener);
		fileMenu.addListener(SWT.Show, listener);
		fileMenu.addListener(SWT.Selection, listener);

		Menu editMenu = new Menu(shell, SWT.DROP_DOWN);
		editMenu.addListener(SWT.Hide, listener);
		editMenu.addListener(SWT.Show, listener);
		editMenu.addListener(SWT.Selection, listener);

		Menu windowMenu = new Menu(shell, SWT.DROP_DOWN);
		windowMenu.addListener(SWT.Hide, listener);
		windowMenu.addListener(SWT.Show, listener);
		windowMenu.addListener(SWT.Selection, listener);

		for (int i = 0; i < menuStrings.length; i++) {
			if ((i >= MENUITEM_FILE) && (i <= MENUITEM_WINDOW)) {
				menuItems[i] = new MenuItem(menuBar, SWT.CASCADE);
				if (i == MENUITEM_FILE) {
					menuItems[i].setMenu(fileMenu);
				} else if (i == MENUITEM_EDIT) {
					menuItems[i].setMenu(editMenu);
				} else if (i == MENUITEM_WINDOW) {
					menuItems[i].setMenu(windowMenu);
				}
			} else if ((i >= MENUITEM_FILE_NEW) && (i <= MENUITEM_FILE_EXIT)) {
				menuItems[i] = new MenuItem(fileMenu, SWT.PUSH);
				if ((i == MENUITEM_FILE_NEW) || (i == MENUITEM_FILE_CLOSE)) {
					new MenuItem(fileMenu, SWT.SEPARATOR);
				}
			} else if ((i >= MENUITEM_EDIT_UNDO) && (i <= MENUITEM_EDIT_COPY)) {
				menuItems[i] = new MenuItem(editMenu, SWT.PUSH);
				if (i == MENUITEM_EDIT_REDO) {
					new MenuItem(editMenu, SWT.SEPARATOR);
				}
			} else if ((i >= MENUITEM_WINDOW_NEW)
					&& (i <= MENUITEM_WINDOW_ABOUT)) {
				menuItems[i] = new MenuItem(windowMenu, SWT.PUSH);
				if ((i == MENUITEM_WINDOW_NEW) || (i == MENUITEM_WINDOW_CLOSE)
						|| (i == MENUITEM_WINDOW_PREFER)) {
					new MenuItem(windowMenu, SWT.SEPARATOR);
				}
			}

			menuItems[i].setText(menuStrings[i]);
			menuItems[i].addListener(SWT.Arm, listener);
			menuItems[i].addListener(SWT.Selection, listener);

			if (i == MENUITEM_WINDOW_CLOSE) {
				menuItems[i].setEnabled(false);
			}
		}
	}

	public void setStaus(String str) {
		label.setText(str);
		label.update();
	}

	public void handleEvent(Event event) {
		if (event.type == SWT.Selection) {
			MenuItem item = (MenuItem) event.widget;
			System.out.println("[SWT.Selection] event : " + event);

			if (item != null) {
				setStaus(item.getText());
			}
		} else if (event.type == SWT.Arm) {
			MenuItem item = (MenuItem) event.widget;
			System.out.println("[SWT.Arm] event : " + event);

			if (item != null) {
				setStaus(item.getText());
			}
		} else if (event.type == SWT.Show) {
			Menu menu = (Menu) event.widget;
			MenuItem item = menu.getParentItem();
			System.out.println("[SWT.Show] event : " + event);

			if (item != null) {
				setStaus(item.getText());
			}
		} else if (event.type == SWT.Hide) {
			System.out.println("[SWT.Hide] event : " + event);

			setStaus("");
		}
	}

	public static MenuItem getMenuItem(int i) {
		if ((i < 0) || (i >= MENUITEM_MAX)) {
			return null;
		}
		return (menuItems[i]);
	}

	private void run() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		MenuManager menu = new MenuManager(display, shell, null);
		menu.run();
	}
}
