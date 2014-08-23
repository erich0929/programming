package org.rndclub.swt.dnd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DropTargetCopyTextFileTest {
	private static void open(Text text, String filename) {
		File file = new File(filename);
		try {
			text.setText("");
			FileReader reader = new FileReader(file);
			BufferedReader in = new BufferedReader(reader);
			String str = null;
			while ((str = in.readLine()) != null) {
				text.append(str + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT DropTarget Test");

		final Text text = new Text(shell, SWT.BORDER | SWT.MULTI);
		int operations = DND.DROP_DEFAULT | DND.DROP_COPY | DND.DROP_MOVE;
		DropTarget target = new DropTarget(text, operations);
		target.setTransfer(new Transfer[]{FileTransfer.getInstance(),
				TextTransfer.getInstance()});

		target.addDropListener(new DropTargetAdapter() {
			FileTransfer fileTransfer = FileTransfer.getInstance();
			TextTransfer textTransfer = TextTransfer.getInstance();
			public void dragEnter(DropTargetEvent e) {
				System.out.println("[dragEnter] e : " + e);
				TransferData data[] = e.dataTypes;
				for (int i = 0; i < data.length; i++) {
					System.out.println("[dragEnter] data[" + i + "] : "
							+ data[i]);
				}
				if (e.detail == DND.DROP_DEFAULT) {
					e.detail = DND.DROP_COPY;
				}
			}

			public void dragOperationChanged(DropTargetEvent e) {
				if (e.detail == DND.DROP_DEFAULT) {
					e.detail = DND.DROP_COPY;
				}
			}

			public void drop(DropTargetEvent e) {
				System.out.println("[drop] e : " + e);
				if (fileTransfer.isSupportedType(e.currentDataType)) {
					String[] files = (String[]) e.data;
					if (files != null && files.length > 0) {
						open(text, files[0]); // 파일을 연다
					}
				}
				if (textTransfer.isSupportedType(e.currentDataType)) {
					String str = (String) e.data;
					if (str != null) {
						text.setText(str); // 텍스트를 커서 위치에 삽입
					}
				}
			}
		});

		shell.setLocation(display.getBounds().width - 320,
				display.getBounds().height - 240);
		shell.setSize(320, 240);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
