package org.rndclub.swt.comp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class GroupTest {
	final static String[] langs = {"Java", "C/C++", "Python", "Lisp"};

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Group Composite Test");

		// Group group = new Group(shell, SWT.NONE);
		// Group group = new Group(shell, SWT.SHADOW_ETCHED_IN);
		// Group group = new Group(shell, SWT.SHADOW_ETCHED_OUT);
		// Group group = new Group(shell, SWT.SHADOW_IN);
		// Group group = new Group(shell, SWT.SHADOW_OUT);
		Group group = new Group(shell, SWT.SHADOW_NONE);
		group.setText("가장 선호하는 프로그래밍 언어는?");

		Button buttons[] = new Button[langs.length];
		for (int i = 0; i < langs.length; i++) {
			buttons[i] = new Button(group, SWT.PUSH);
			buttons[i].setText(langs[i]);
		}
		group.setLayout(new FillLayout());
		group.pack();

		// shell.pack();
		shell.setSize(group.getSize().x + 20, group.getSize().y + 40);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
