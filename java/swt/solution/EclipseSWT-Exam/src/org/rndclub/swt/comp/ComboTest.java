package org.rndclub.swt.comp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ComboTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("가장 선호하는 프로그래밍 언어는?");

		Combo combo = new Combo(shell, SWT.DROP_DOWN);
		// Combo combo = new Combo(shell, SWT.READ_ONLY);
		// Combo combo = new Combo(shell, SWT.SIMPLE);
		combo.setItems(new String[]{"Java", "C/C++", "Python", "Lisp"});
		combo.setSize(200, 200);

		combo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				System.out.println("[Select] event : " + event);
			}

			public void widgetDefaultSelected(SelectionEvent event) {
				System.out.println("[DefaultSelect] event : " + event);
			}
		});
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				System.out.println("[Modify] event : " + event);
			}
		});

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
