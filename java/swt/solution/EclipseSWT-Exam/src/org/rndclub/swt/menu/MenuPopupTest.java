package org.rndclub.swt.menu;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class MenuPopupTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		Listener menuListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.type == SWT.Show) {
					System.out.println("[SWT.Show] event : " + event);
				} else if (event.type == SWT.Hide) {
					System.out.println("[SWT.Hide] event : " + event);
				} else if (event.type == SWT.Help) {
					System.out.println("[SWT.Help] event : " + event);
				}
			}
		};

		Menu menuPopup = new Menu(shell, SWT.POP_UP | SWT.LEFT_TO_RIGHT);
		// Menu popup = new Menu(shell, SWT.POP_UP | SWT.RIGHT_TO_LEFT);
		menuPopup.addListener(SWT.Show, menuListener);
		menuPopup.addListener(SWT.Hide, menuListener);
		menuPopup.addListener(SWT.Help, menuListener);
		shell.setMenu(menuPopup);

		MenuItem fileItem = new MenuItem(menuPopup, SWT.CASCADE);
		fileItem.setText("&File");

		Menu fileSubmenu = new Menu(shell, SWT.DROP_DOWN);
		fileItem.setMenu(fileSubmenu);
		fileSubmenu.addListener(SWT.Show, menuListener);
		fileSubmenu.addListener(SWT.Hide, menuListener);
		fileSubmenu.addListener(SWT.Help, menuListener);

		MenuItem newFileItem = new MenuItem(fileSubmenu, SWT.PUSH);
		newFileItem.setText("&New File\tCtrl+N");
		newFileItem.setAccelerator(SWT.MOD1 + 'N');

		MenuItem editItem = new MenuItem(menuPopup, SWT.CASCADE);
		editItem.setText("&Edit");

		Menu editSubmenu = new Menu(shell, SWT.DROP_DOWN);
		editItem.setMenu(editSubmenu);
		editSubmenu.addListener(SWT.Show, menuListener);
		editSubmenu.addListener(SWT.Hide, menuListener);
		editSubmenu.addListener(SWT.Help, menuListener);

		MenuItem cutItem = new MenuItem(editSubmenu, SWT.PUSH);
		cutItem.setText("Cu&t\tCtrl+X");
		cutItem.setAccelerator(SWT.MOD1 + 'X');

		shell.setSize(200, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}

}
