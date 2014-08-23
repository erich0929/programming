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

		// 레이블 위젯을 드래그 원본(Drag Source)으로 활성화 한다.
		final Label label = new Label(shell, SWT.BORDER);
		label.setText("text to be transferred");

		// 드래그 원본에서 데이터가 복사되거나 이동될 수 있도록 한다.
		int operations = DND.DROP_MOVE | DND.DROP_COPY;
		DragSource source = new DragSource(label, operations);

		// 텍스트 포맷 내에 데이터를 제공한다.
		Transfer[] types = new Transfer[]{TextTransfer.getInstance()};
		source.setTransfer(types);

		source.addDragListener(new DragSourceListener() {
			public void dragStart(DragSourceEvent event) {
				// 레이블 내에 실제 텍스트가 있을 경우에만, 드래그를 시작한다.
				if (label.getText().length() == 0) {
					event.doit = false;
				}
			}

			public void dragSetData(DragSourceEvent event) {
				// 요청된 타입의 데이터를 제공한다.
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = label.getText();
				}
			}

			public void dragFinished(DragSourceEvent event) {
				// 만약, 데이터의 이동(MOVE) 작업이 수행되었다면,
				// 드래그 원본인 레이블 위젯에서 이동한 데이터를 제거한다.
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
