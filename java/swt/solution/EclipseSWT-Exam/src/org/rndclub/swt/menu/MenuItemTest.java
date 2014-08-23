package org.rndclub.swt.menu;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class MenuItemTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		Listener itemListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.type == SWT.Selection) {
					System.out.println("[SWT.Selection] event : " + event);
				} else if (event.type == SWT.Arm) {
					System.out.println("[SWT.Arm] event : " + event);
				} else if (event.type == SWT.Help) {
					System.out.println("[SWT.Help] event : " + event);
				}
			}
		};

		Menu bar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(bar);

		MenuItem fileItem = new MenuItem(bar, SWT.CASCADE);
		fileItem.setText("&File");

		Menu fileSubmenu = new Menu(shell, SWT.DROP_DOWN);
		// Menu fileSubmenu = new Menu(shell, SWT.DROP_DOWN |
		// SWT.NO_RADIO_GROUP);
		fileItem.setMenu(fileSubmenu);

		String menuItemTitles[] = new String[]{"SWT.CASCADE", "SWT.PUSH",
				"SWT.CHECK", "SWT.SEPARATOR", "SWT.RADIO-1", "SWT.RADIO-2",
				"SWT.RADIO-3"};
		int menuItemStyles[] = new int[]{SWT.CASCADE, SWT.PUSH, SWT.CHECK,
				SWT.SEPARATOR, SWT.RADIO, SWT.RADIO, SWT.RADIO};

		for (int i = 0; i < menuItemTitles.length; i++) {
			MenuItem menuItem = new MenuItem(fileSubmenu, menuItemStyles[i]);
			menuItem.setText(menuItemTitles[i]);
			menuItem.addListener(SWT.Arm, itemListener);
			menuItem.addListener(SWT.Help, itemListener);
			menuItem.addListener(SWT.Selection, itemListener);
		}

		shell.setSize(200, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}
