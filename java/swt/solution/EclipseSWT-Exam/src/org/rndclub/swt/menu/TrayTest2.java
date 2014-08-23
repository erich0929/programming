package org.rndclub.swt.menu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.rndclub.swt.graphics.intro.GraphicsUtil;

public class TrayTest2 {
	static MenuItem showItem = null;
	static MenuItem hideItem = null;

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);

		GraphicsUtil.init(display);

		final Tray tray = display.getSystemTray();
		if (tray == null) {
			System.out.println("The system tray is not available");
		} else {
			final TrayItem itemAnt = new TrayItem(tray, SWT.NONE);
			itemAnt.setToolTipText("SWT TrayItem - Ant");
			itemAnt.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_ANT));

			final TrayItem itemBug = new TrayItem(tray, SWT.NONE);
			itemBug.setToolTipText("SWT TrayItem - Bug");
			itemBug.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_BUG));

			Listener menuListener = new Listener() {
				public void handleEvent(Event event) {
					if (event.type == SWT.Show) {
						System.out.println("[Menu-Show] event : " + event);
					} else if (event.type == SWT.Hide) {
						System.out.println("[Menu-Hide] event : " + event);
					} else if (event.type == SWT.Selection) {
						System.out.println("[Menu-Selection] event : " + event);
						if (event.widget == showItem) {
							shell.setVisible(true);
						} else if (event.widget == hideItem) {
							shell.setVisible(false);
						}
					}
				}
			};

			final Menu menu = new Menu(shell, SWT.POP_UP);
			showItem = new MenuItem(menu, SWT.PUSH);
			showItem.setText("Show");
			showItem.addListener(SWT.Selection, menuListener);
			menu.setDefaultItem(showItem);

			hideItem = new MenuItem(menu, SWT.PUSH);
			hideItem.setText("Hide");
			hideItem.addListener(SWT.Selection, menuListener);

			Listener itemListener = new Listener() {
				public void handleEvent(Event event) {
					if (event.type == SWT.Show) {
						System.out.println("[Tray-Show] event : " + event);
					} else if (event.type == SWT.Hide) {
						System.out.println("[Tray-Hide] event : " + event);
					} else if (event.type == SWT.Selection) {
						System.out.println("[Tray-Selection] event : " + event);
					} else if (event.type == SWT.DefaultSelection) {
						System.out.println("[Tray-Default] event : " + event);
					} else if (event.type == SWT.MenuDetect) {
						System.out.println("[Tray-Menu] event : " + event);
						menu.setVisible(true);
					}
				}
			};

			itemBug.addListener(SWT.Show, itemListener);
			itemBug.addListener(SWT.Hide, itemListener);
			itemBug.addListener(SWT.Selection, itemListener);
			itemBug.addListener(SWT.DefaultSelection, itemListener);
			itemBug.addListener(SWT.MenuDetect, itemListener);
		}
		shell.setBounds(50, 50, 300, 200);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		GraphicsUtil.dispose();

		display.dispose();
	}
}
