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

public class TrayTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

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

			final Menu menu = new Menu(shell, SWT.POP_UP);
			for (int i = 0; i < 8; i++) {
				MenuItem mi = new MenuItem(menu, SWT.PUSH);
				mi.setText("Menu " + i);
				mi.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						System.out.println("[Menu-Selection] event : " + event);
					}
				});
				if (i == 0) {
					menu.setDefaultItem(mi);
				}
			}

			itemBug.addListener(SWT.Show, new Listener() {
				public void handleEvent(Event event) {
					System.out.println("[Tray-Show] event : " + event);
				}
			});
			itemBug.addListener(SWT.Hide, new Listener() {
				public void handleEvent(Event event) {
					System.out.println("[Tray-Hide] event : " + event);
				}
			});
			itemBug.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					System.out.println("[Tray-Selection] event : " + event);
				}
			});
			itemBug.addListener(SWT.DefaultSelection, new Listener() {
				public void handleEvent(Event event) {
					System.out.println("[Tray-Default] event : " + event);
				}
			});
			itemBug.addListener(SWT.MenuDetect, new Listener() {
				public void handleEvent(Event event) {
					System.out.println("[Tray-MenuDetect] event : " + event);
					menu.setVisible(true);
				}
			});
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
