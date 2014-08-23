/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.rndclub.swt.comp;

/*
 * TabFolder example snippet: create a tab folder (six pages)
 * 
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;
import org.rndclub.swt.graphics.intro.GraphicsUtil;

public class TabFolderTest {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT TabFolder Test");

		GraphicsUtil.init(display);

		Listener tabFolderListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.type == SWT.Selection) {
					System.out.println("[Folder-Selection] event : " + event);
					TabFolder tabFolder = (TabFolder) event.widget;
					int index = tabFolder.getSelectionIndex();
					TabItem item = tabFolder.getItem(index);
					System.out.println("[Folder-Selection] item[" + index
							+ "] : " + item);
				}
			}
		};

		final TabFolder tabFolder = new TabFolder(shell, SWT.TOP);
		// final TabFolder tabFolder = new TabFolder(shell, SWT.BOTTOM);
		tabFolder.addListener(SWT.Selection, tabFolderListener);
		for (int i = 0; i < 6; i++) {
			TabItem item = new TabItem(tabFolder, SWT.NONE);
			item.setText("TabItem " + i);
			item.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_ANT + i));

			Button button = new Button(tabFolder, SWT.PUSH);
			button.setText("Page " + i);

			item.setControl(button);
		}
		tabFolder.pack();

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		GraphicsUtil.dispose();
		display.dispose();
	}
}
