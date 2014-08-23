package org.rndclub.swt.comp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.rndclub.swt.graphics.intro.GraphicsUtil;

public class TreeEditorTest {

	public static void main(String[] args) {
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Tree Editor Test");

		GraphicsUtil.init(display);

		final Tree tree = new Tree(shell, SWT.BORDER);
		for (int i = 0; i < 4; i++) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText("item " + i);
			item.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_OPEN));
			for (int j = 0; j < 3; j++) {
				TreeItem subItem = new TreeItem(item, SWT.NONE);
				subItem.setText("item " + i + " " + j);
				subItem.setImage(GraphicsUtil.getImage(GraphicsUtil.IMAGE_RUN));
			}
		}

		// (1) Ʈ�� �����͸� �����ϰ�, ũ�⸦ Ʈ���� �� ũ��� ���� �ϰ�, �ּ� ũ�⸦ 50 �ȼ��� �����Ѵ�.
		final TreeEditor editor = new TreeEditor(tree);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 50;

		tree.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				// (2) �����Ϳ� ������ ��Ʈ���� �ִٸ�, �����Ѵ�.
				Control oldEditor = editor.getEditor();
				if (oldEditor != null) {
					oldEditor.dispose();
				}

				// (3) �̺�Ʈ�� �߻��� �������� null �̸� �����Ѵ�.
				TreeItem item = (TreeItem) event.item;
				if (item == null) {
					return;
				}

				// (4) ���õ� ��Ʈ�� �ؽ�Ʈ�� ���� �ؽ�Ʈ ������ �����Ѵ�.
				Text newEditor = new Text(tree, SWT.NONE);
				newEditor.setText(item.getText());
				newEditor.addModifyListener(new ModifyListener() {
					// (5) �ؽ�Ʈ ������ �ؽ�Ʈ�� �ٲ��, �ش� ����� �ؽ�Ʈ�� �ٲپ� �ش�.
					public void modifyText(ModifyEvent e) {
						Text text = (Text) editor.getEditor();
						editor.getItem().setText(text.getText());
					}
				});
				newEditor.selectAll(); // (6) �ؽ�Ʈ ������ ��� �ؽ�Ʈ�� ���õǵ��� �Ѵ�.
				newEditor.setFocus(); // (7) �ؽ�Ʈ ������ ��Ŀ���� ������ �Ѵ�.
				editor.setEditor(newEditor, item); // (8) Ʈ�� �������� ���ο� �����ͷμ�,
				// �ؽ�Ʈ ������ �����Ѵ�.
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
