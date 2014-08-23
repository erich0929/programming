package org.rndclub.swt.menu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ArmEvent;
import org.eclipse.swt.events.ArmListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.rndclub.swt.graphics.intro.GraphicsUtil;

public class ToolBarImageTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		GraphicsUtil.init(display);

		final Menu menu = new Menu(shell, SWT.POP_UP);
		for (int i = 0; i < 8; i++) {
			MenuItem item = new MenuItem(menu, SWT.PUSH);
			item.setText("Item " + i);
			item.addArmListener(new ArmListener() {
				public void widgetArmed(ArmEvent event) {
					System.out.println("[Arm] event : " + event);
				}
			});
			item.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent event) {
					System.out.println("[Selection] event : " + event);
				}

				public void widgetDefaultSelected(SelectionEvent event) {
					System.out.println("[DefaultSelection] event : " + event);
				}
			});
		}

		final ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.BORDER);
		for (int i = 0; i < 12; i++) {
			final ToolItem item = new ToolItem(toolBar, SWT.DROP_DOWN);
			item.setImage(GraphicsUtil.getImage(i));
			item.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					if (event.detail == SWT.ARROW) {
						Rectangle rect = item.getBounds();
						Point pt = new Point(rect.x, rect.y + rect.height);
						pt = toolBar.toDisplay(pt);

						menu.setLocation(pt.x, pt.y);
						menu.setVisible(true);
					}
				}
			});
		}

		toolBar.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		GraphicsUtil.dispose();

		display.dispose();
	}

}
