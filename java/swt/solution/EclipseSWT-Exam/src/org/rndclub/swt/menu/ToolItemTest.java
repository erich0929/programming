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

public class ToolItemTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("ToolItem Test");

		GraphicsUtil.init(display);

		final Menu menu = new Menu(shell, SWT.POP_UP);
		for (int i = 0; i < 3; i++) {
			MenuItem item = new MenuItem(menu, SWT.PUSH);
			item.setText("Item " + i);
			item.addArmListener(new ArmListener() {
				public void widgetArmed(ArmEvent event) {
					System.out.println("[Menu-Arm] event : " + event);
				}
			});
			item.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent event) {
					System.out.println("[Menu-Selection] event : " + event);
				}

				public void widgetDefaultSelected(SelectionEvent event) {
					System.out.println("[Menu-Default] event : " + event);
				}
			});
		}

		final ToolBar toolBar = new ToolBar(shell, SWT.BORDER | SWT.FLAT);

		String toolItemTitles[] = new String[]{"PUSH", "CHECK", "DROP_DOWN",
				"SEPARATOR", "RADIO-1", "RADIO-2", "RADIO-3"};
		int toolItemStyles[] = new int[]{SWT.PUSH, SWT.CHECK, SWT.DROP_DOWN,
				SWT.SEPARATOR, SWT.RADIO, SWT.RADIO, SWT.RADIO};

		for (int i = 0; i < toolItemTitles.length; i++) {
			final ToolItem toolItem = new ToolItem(toolBar, toolItemStyles[i]);
			toolItem.setText(toolItemTitles[i]);
			toolItem.setImage(GraphicsUtil.getImage(i));
			if (toolItemStyles[i] == SWT.DROP_DOWN) {
				toolItem.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						if (event.detail == SWT.ARROW) {
							Rectangle rect = toolItem.getBounds();
							Point pt = new Point(rect.x, rect.y + rect.height);
							pt = toolBar.toDisplay(pt);

							menu.setLocation(pt.x, pt.y);
							menu.setVisible(true);
						}
					}
				});
			} else {
				toolItem.addSelectionListener(new SelectionListener() {
					public void widgetSelected(SelectionEvent event) {
						System.out.println("[Tool-Selection] event : " + event);
					}
					public void widgetDefaultSelected(SelectionEvent event) {
						System.out.println("[Tool-Default] event : " + event);
					}
				});
			}
		}
		toolBar.pack();

		shell.open();
		shell.setSize(toolBar.getSize().x + 16, toolBar.getSize().y + 40);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		GraphicsUtil.dispose();

		display.dispose();
	}
}
