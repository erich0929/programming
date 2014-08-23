package org.rndclub.swt.clipboard;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CopyAndPasteWithClipboard {
	Display display = null;
	Shell shell = null;
	Text text = null;
	Button copy = null;
	Button paste = null;
	Button clear = null;
	Button query = null;
	Clipboard cb = null;

	public CopyAndPasteWithClipboard() {
		createUI();
		doLayout();
		addListener();
	}

	public void createUI() {
		display = new Display();
		cb = new Clipboard(display);
		shell = new Shell(display);
		shell.setText("SWT Clipboard Test");

		text = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL
				| SWT.H_SCROLL);

		copy = new Button(shell, SWT.PUSH);
		copy.setText("Copy");

		paste = new Button(shell, SWT.PUSH);
		paste.setText("Paste");

		clear = new Button(shell, SWT.PUSH);
		clear.setText("Clear");

		query = new Button(shell, SWT.PUSH);
		query.setText("Query");
	}

	public void doLayout() {
		shell.setLayout(new FormLayout());

		FormData data = new FormData();
		data.right = new FormAttachment(100, -5);
		data.top = new FormAttachment(0, 5);
		copy.setLayoutData(data);

		data = new FormData();
		data.right = new FormAttachment(100, -5);
		data.top = new FormAttachment(copy, 5);
		paste.setLayoutData(data);

		data = new FormData();
		data.right = new FormAttachment(100, -5);
		data.top = new FormAttachment(paste, 5);
		clear.setLayoutData(data);

		data = new FormData();
		data.right = new FormAttachment(100, -5);
		data.top = new FormAttachment(clear, 5);
		query.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, 5);
		data.top = new FormAttachment(0, 5);
		data.right = new FormAttachment(copy, -5);
		data.bottom = new FormAttachment(100, -5);
		text.setLayoutData(data);

		shell.setSize(320, 240);
	}

	public void addListener() {
		copy.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				String textData = text.getSelectionText();
				if ((textData != null) && (!"".equals(textData))) {
					TextTransfer textTransfer = TextTransfer.getInstance();
					cb.setContents(new Object[]{textData},
							new Transfer[]{textTransfer});
				}
			}
		});
		paste.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				TextTransfer transfer = TextTransfer.getInstance();
				String data = (String) cb.getContents(transfer);
				if (data != null) {
					text.insert(data);
				}
			}
		});
		clear.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				cb.clearContents();
			}
		});
		query.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				String names[] = cb.getAvailableTypeNames();
				text.insert("\n----------------------\n");
				for (int i = 0; (names != null) && (i < names.length); i++) {
					text.insert("names[" + i + "] : " + names[i] + "\n");
				}
				text.insert("----------------------\n");
			}
		});
	}

	public void dispose() {
		if (cb != null) {
			cb.dispose();
		}
		if (display != null) {
			display.dispose();
		}
	}

	public void run() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public static void main(String[] args) {
		CopyAndPasteWithClipboard app = new CopyAndPasteWithClipboard();
		app.run();
	}
}
