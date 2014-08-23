package org.rndclub.swt.dnd;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class DragAndDropTest {
	Display display = null;
	Shell shell = null;

	Composite lComp = null;
	Composite rComp = null;

	Button lButt = null;
	Button rButt = null;

	public DragAndDropTest() {
		createUI();
		doLayout();
		addListener();
	}

	public void createUI() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("SWT Drag&Drop Test");

		lComp = new Composite(shell, SWT.BORDER);
		rComp = new Composite(shell, SWT.BORDER);

		lButt = new Button(lComp, SWT.PUSH);
		lButt.setText("Source");
		rButt = new Button(rComp, SWT.PUSH);
		rButt.setText("Target");
	}

	public void doLayout() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = true;
		shell.setLayout(gridLayout);

		gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		lComp.setLayout(gridLayout);

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;

		lComp.setLayoutData(gridData);

		gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		rComp.setLayout(gridLayout);

		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;

		rComp.setLayoutData(gridData);

		gridData = new GridData();
		gridData.horizontalAlignment = GridData.CENTER;
		gridData.verticalAlignment = GridData.END;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;

		lButt.setLayoutData(gridData);

		gridData = new GridData();
		gridData.horizontalAlignment = GridData.CENTER;
		gridData.verticalAlignment = GridData.END;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;

		rButt.setLayoutData(gridData);

		shell.pack();
	}

	public void addListener() {
		int operations = DND.DROP_MOVE | DND.DROP_COPY;
		final DragSource lDragSource = new DragSource(lButt, operations);
		final DragSource rDragSource = new DragSource(rButt, operations);

		DragSourceListener dsl = new DragSourceListener() {
			public void dragStart(DragSourceEvent e) {
				// ���̺� ���� ���� �ؽ�Ʈ�� ���� ��쿡��, �巡�׸� �����Ѵ�.
				System.out.println("[dragStart] e : " + e);
				System.out.println("[dragStart] e : " + e);
				System.out.println("[dragStart] e : " + e.widget);
				System.out.println("[dragStart] e : " + e.detail);
				System.out.println("[dragStart] e : " + e.doit);
				DragSource ds = (DragSource) e.widget;
				if (ds == lDragSource) {
					if (lButt.getText().length() == 0) {
						e.doit = false;
					}
				} else if (ds == rDragSource) {
					if (rButt.getText().length() == 0) {
						e.doit = false;
					}
				} else {
					return;
				}
			}

			public void dragSetData(DragSourceEvent e) {
				// ��û�� Ÿ���� �����͸� �����Ѵ�.
				System.out.println("[dragSetData] e : " + e);
				System.out.println("[dragSetData] e : " + e);
				System.out.println("[dragSetData] e : " + e.widget);
				System.out.println("[dragSetData] e : " + e.detail);
				System.out.println("[dragSetData] e : " + e.doit);
				if (TextTransfer.getInstance().isSupportedType(e.dataType)) {
					DragSource ds = (DragSource) e.widget;
					if (ds == lDragSource) {
						e.data = lButt.getText();
					} else if (ds == rDragSource) {
						e.data = rButt.getText();
					} else {
						return;
					}
				}
			}

			public void dragFinished(DragSourceEvent e) {
				// ����, �������� �̵�(MOVE) �۾��� ����Ǿ��ٸ�,
				// �巡�� ������ ���̺� �������� �̵��� �����͸� �����Ѵ�.
				System.out.println("[dragFinished] e : " + e);
				System.out.println("[dragFinished] e : " + e);
				System.out.println("[dragFinished] e : " + e.widget);
				System.out.println("[dragFinished] e : " + e.detail);
				System.out.println("[dragFinished] e : " + e.doit);
				if (e.detail == DND.DROP_MOVE) {
					DragSource ds = (DragSource) e.widget;
					if (ds == lDragSource) {
						lButt.setText("");
					} else if (ds == rDragSource) {
						rButt.setText("");
					} else {
						return;
					}
				}
			}
		};
		Transfer[] types = new Transfer[]{TextTransfer.getInstance()};
		lDragSource.setTransfer(types);
		lDragSource.addDragListener(dsl);

		rDragSource.setTransfer(types);
		rDragSource.addDragListener(dsl);
	}

	public void dispose() {
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
		DragAndDropTest app = new DragAndDropTest();
		app.run();
	}

}
