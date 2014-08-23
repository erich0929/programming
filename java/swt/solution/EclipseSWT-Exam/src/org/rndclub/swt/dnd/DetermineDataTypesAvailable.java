package org.rndclub.swt.dnd;

/*
 * Drag and Drop example snippet: determine data types available (win32 only)
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.*;
import org.eclipse.swt.dnd.*;
import org.eclipse.swt.internal.ole.win32.*;
import org.eclipse.swt.internal.win32.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class DetermineDataTypesAvailable extends ByteArrayTransfer {

	private static DetermineDataTypesAvailable _instance = new DetermineDataTypesAvailable();

	private int[] ids;

	private String[] names;

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		final Table control = new Table(shell, SWT.NONE);
		TableItem item = new TableItem(control, SWT.NONE);
		item
				.setText("Drag data over this site to see the native transfer type.");
		DropTarget target = new DropTarget(control, DND.DROP_DEFAULT
				| DND.DROP_COPY | DND.DROP_LINK | DND.DROP_MOVE);
		target.setTransfer(new Transfer[] { DetermineDataTypesAvailable.getInstance() });
		target.addDropListener(new DropTargetAdapter() {
			public void dragEnter(DropTargetEvent event) {
				String ops = "";
				if ((event.operations & DND.DROP_COPY) != 0)
					ops += "Copy;";
				if ((event.operations & DND.DROP_MOVE) != 0)
					ops += "Move;";
				if ((event.operations & DND.DROP_LINK) != 0)
					ops += "Link;";
				control.removeAll();
				TableItem item1 = new TableItem(control, SWT.NONE);
				item1.setText("Allowed Operations are " + ops);

				if (event.detail == DND.DROP_DEFAULT) {
					if ((event.operations & DND.DROP_COPY) != 0) {
						event.detail = DND.DROP_COPY;
					} else if ((event.operations & DND.DROP_LINK) != 0) {
						event.detail = DND.DROP_LINK;
					} else if ((event.operations & DND.DROP_MOVE) != 0) {
						event.detail = DND.DROP_MOVE;
					}
				}

				TransferData[] data = event.dataTypes;
				for (int i = 0; i < data.length; i++) {
					int id = data[i].type;
					String name = getNameFromId(id);
					TableItem item2 = new TableItem(control, SWT.NONE);
					item2.setText("Data type is " + id + " " + name);
				}
			}
		});

		shell.setSize(400, 400);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public static DetermineDataTypesAvailable getInstance() {
		return _instance;
	}

	DetermineDataTypesAvailable() {
		ids = new int[80000];
		names = new String[80000];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = i;
			names[i] = getNameFromId(i);
		}
	}

	public void javaToNative(Object object, TransferData transferData) {
	}

	public Object nativeToJava(TransferData transferData) {
		return "Hello World";
	}

	protected String[] getTypeNames() {
		return names;
	}

	protected int[] getTypeIds() {
		return ids;
	}

	static String getNameFromId(int id) {
		String name = null;
		int maxSize = 128;
		TCHAR buffer = new TCHAR(0, maxSize);
		int size = COM.GetClipboardFormatName(id, buffer, maxSize);
		if (size != 0) {
			name = buffer.toString(0, size);
		} else {
			switch (id) {
			case COM.CF_HDROP:
				name = "CF_HDROP";
				break;
			case COM.CF_TEXT:
				name = "CF_TEXT";
				break;
			case COM.CF_BITMAP:
				name = "CF_BITMAP";
				break;
			case COM.CF_METAFILEPICT:
				name = "CF_METAFILEPICT";
				break;
			case COM.CF_SYLK:
				name = "CF_SYLK";
				break;
			case COM.CF_DIF:
				name = "CF_DIF";
				break;
			case COM.CF_TIFF:
				name = "CF_TIFF";
				break;
			case COM.CF_OEMTEXT:
				name = "CF_OEMTEXT";
				break;
			case COM.CF_DIB:
				name = "CF_DIB";
				break;
			case COM.CF_PALETTE:
				name = "CF_PALETTE";
				break;
			case COM.CF_PENDATA:
				name = "CF_PENDATA";
				break;
			case COM.CF_RIFF:
				name = "CF_RIFF";
				break;
			case COM.CF_WAVE:
				name = "CF_WAVE";
				break;
			case COM.CF_UNICODETEXT:
				name = "CF_UNICODETEXT";
				break;
			case COM.CF_ENHMETAFILE:
				name = "CF_ENHMETAFILE";
				break;
			case COM.CF_LOCALE:
				name = "CF_LOCALE";
				break;
			case COM.CF_MAX:
				name = "CF_MAX";
				break;
			}

		}
		return name;
	}
}
