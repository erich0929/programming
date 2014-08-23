package org.rndclub.swt.comp;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class CTabFolderTest {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new GridLayout());
		shell.setText("SWT CTabFolder Test");
		
		Image image = new Image(display, 16, 16);
		GC gc = new GC(image);
		gc.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
		gc.fillRectangle(0, 0, 16, 16);
		gc.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
		gc.fillRectangle(3, 3, 10, 10);
		gc.dispose();

		final CTabFolder folder = new CTabFolder(shell, SWT.BORDER);//SWT.FLAT);
		folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		folder.setSimple(false);
		folder.setUnselectedImageVisible(true);
		folder.setUnselectedCloseVisible(true);
		for (int i = 0; i < 8; i++) {
			CTabItem item = new CTabItem(folder, SWT.CLOSE);
			item.setText("Item " + i);
			item.setImage(image);
			Text text = new Text(folder, SWT.MULTI | SWT.V_SCROLL
					| SWT.H_SCROLL);
			text.setText("Text for item " + i
					+ "\n\none, two, three\n\nabcdefghijklmnop");
			item.setControl(text);
		}
		folder.setMinimizeVisible(true);
		folder.setMaximizeVisible(true);

		folder.addCTabFolder2Listener(new CTabFolder2Adapter() {
			public void minimize(CTabFolderEvent event) {
				folder.setMinimized(true);
				shell.layout(true);
			}
			public void maximize(CTabFolderEvent event) {
				folder.setMaximized(true);
				folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
						true));
				shell.layout(true);
			}
			public void restore(CTabFolderEvent event) {
				folder.setMinimized(false);
				folder.setMaximized(false);
				folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
						false));
				shell.layout(true);
			}
		});

		shell.setSize(480, 240);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		image.dispose();
		display.dispose();
	}
}
