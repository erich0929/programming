package org.rndclub.swt.comp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.rndclub.swt.graphics.intro.GraphicsUtil;

public class TableEditorTest {
	static int selectedColumnIndex = -1;

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT TableEditor Test");

		GraphicsUtil.init(display);

		final Table table = new Table(shell, SWT.MULTI | SWT.CHECK
				| SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final int rowCount = 4, columnCount = 8;
		for (int i = 0; i < columnCount; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText("Column " + i);
		}
		for (int i = 0; i < rowCount; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_BIN));
			for (int j = 0; j < columnCount; j++) {
				item.setText(j, "Item " + i + "-" + j);
			}
		}
		for (int i = 0; i < columnCount; i++) {
			table.getColumn(i).pack();
		}

		Point size = table.computeSize(SWT.DEFAULT, 200);
		table.setSize(size);

		// (1) ���̺� �����͸� �����ϰ�,
		// ũ�⸦ ���̺��� �� ũ��� ���� �ϰ�,
		// �ּ� ũ�⸦ 50 �ȼ��� �����Ѵ�.
		final TableEditor editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 50;

		table.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				// (2) ���̺� �����Ϳ� ������ ��Ʈ���� �ִٸ�, �����Ѵ�.
				Control oldEditor = editor.getEditor();
				if (oldEditor != null) {
					oldEditor.dispose();
				}

				// (3) �̺�Ʈ�� �߻��� ���̺� �������� null �̸� �����Ѵ�.
				Point pt = new Point(event.x, event.y);
				TableItem item = table.getItem(pt);
				System.out.println("[Table-Selection] item : " + item);
				if (item == null) {
					return;
				}

				for (int i = 0; i < columnCount; i++) {
					Rectangle rect = item.getBounds(i);
					// (4) �̺�Ʈ�� �߻��� ���̺� ������ ������ (x,y) ����Ʈ�� �ش��ϴ� �÷��� �ε����� ã�´�.
					if (rect.contains(pt)) {
						selectedColumnIndex = i;

						// (5) ���̺� �����Ϳ� ������ �ؽ�Ʈ ������ �ؽ�Ʈ�� �ٲ��, �ش� ����� �ؽ�Ʈ�� �ٲپ�
						// �ش�.
						Text newEditor = new Text(table, SWT.NONE);
						newEditor.setText(item.getText(selectedColumnIndex));
						newEditor.addModifyListener(new ModifyListener() {
							public void modifyText(ModifyEvent e) {
								Text text = (Text) editor.getEditor();
								editor.getItem().setText(selectedColumnIndex,
										text.getText());
							}
						});
						newEditor.selectAll(); // (6) �ؽ�Ʈ ������ ��� �ؽ�Ʈ�� ���õǵ��� �Ѵ�.
						newEditor.setFocus(); // (7) �ؽ�Ʈ ������ ��Ŀ���� ������ �Ѵ�.

						// (8) ���̺� �������� ���ο� �����ͷμ�, �ؽ�Ʈ ������ �����Ѵ�.
						editor.setEditor(newEditor, item, selectedColumnIndex);

						break;
					}
				}
			}
		});

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		GraphicsUtil.dispose();
		display.dispose();
	}
}