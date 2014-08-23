package org.rndclub.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class StackLayoutTest {
	static final int BUTTON_MAX = 8;
	static int buttonIndex = 0;

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("SWT StackLayout Test");
		shell.setLayout(new GridLayout());

		final Composite parent = new Composite(shell, SWT.NONE);
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));
		final StackLayout statckLayout = new StackLayout();
		parent.setLayout(statckLayout);

		final Control[] controls = new Control[BUTTON_MAX];
		for (int i = 0; i < controls.length; i++) {
			if ((i % 4) == 0) {
				Button b = new Button(parent, SWT.PUSH);
				b.setText("Button " + i);
				controls[i] = b;
			} else if ((i % 4) == 1) {
				Text t = new Text(parent, SWT.PUSH);
				t.setText("Text " + i);
				controls[i] = t;
			} else if ((i % 4) == 2) {
				Label l = new Label(parent, SWT.PUSH);
				l.setText("Label " + i);
				controls[i] = l;
			} else if ((i % 4) == 3) {
				Composite comp = new Composite(parent, SWT.PUSH);
				comp.setLayout(new FillLayout());
				for (int j = 0; j < 4; j++) {
					Button b = new Button(comp, SWT.PUSH);
					b.setText("Button " + i + "-" + j);
				}
				controls[i] = comp;
			}
		}
		statckLayout.topControl = controls[0];

		Button b = new Button(shell, SWT.PUSH);
		b.setText("Show Next Control");
		b.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		b.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				buttonIndex = (buttonIndex + 1) % BUTTON_MAX;
				statckLayout.topControl = controls[buttonIndex];
				parent.layout();
			}
		});

		shell.setSize(320, 120);
		shell.open();
		while (shell != null && !shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
