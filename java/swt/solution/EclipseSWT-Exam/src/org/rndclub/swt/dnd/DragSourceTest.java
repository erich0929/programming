package org.rndclub.swt.dnd;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class DragSourceTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT DragSource Test");

		// ���̺� ������ �巡�� ����(Drag Source)���� Ȱ��ȭ �Ѵ�.
		final Label label = new Label(shell, SWT.BORDER);
		label.setText("text to be transferred");

		// �巡�� �������� �����Ͱ� ����ǰų� �̵��� �� �ֵ��� �Ѵ�.
		int operations = DND.DROP_MOVE | DND.DROP_COPY;
		DragSource source = new DragSource(label, operations);

		// �ؽ�Ʈ ���� ���� �����͸� �����Ѵ�.
		Transfer[] types = new Transfer[]{TextTransfer.getInstance()};
		source.setTransfer(types);

		source.addDragListener(new DragSourceListener() {
			public void dragStart(DragSourceEvent event) {
				// ���̺� ���� ���� �ؽ�Ʈ�� ���� ��쿡��, �巡�׸� �����Ѵ�.
				if (label.getText().length() == 0) {
					event.doit = false;
				}
			}

			public void dragSetData(DragSourceEvent event) {
				// ��û�� Ÿ���� �����͸� �����Ѵ�.
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = label.getText();
				}
			}

			public void dragFinished(DragSourceEvent event) {
				// ����, �������� �̵�(MOVE) �۾��� ����Ǿ��ٸ�,
				// �巡�� ������ ���̺� �������� �̵��� �����͸� �����Ѵ�.
				if (event.detail == DND.DROP_MOVE) {
					label.setText("");
				}
			}
		});

		shell.setSize(640, 480);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
