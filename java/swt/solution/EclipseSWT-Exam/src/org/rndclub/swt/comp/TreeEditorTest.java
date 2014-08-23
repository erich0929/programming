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

		// (1) 트리 에디터를 생성하고, 크기를 트리의 셀 크기와 같게 하고, 최소 크기를 50 픽셀로 설정한다.
		final TreeEditor editor = new TreeEditor(tree);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 50;

		tree.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				// (2) 에디터에 기존의 컨트롤이 있다면, 해제한다.
				Control oldEditor = editor.getEditor();
				if (oldEditor != null) {
					oldEditor.dispose();
				}

				// (3) 이벤트가 발생한 아이템이 null 이면 리턴한다.
				TreeItem item = (TreeItem) event.item;
				if (item == null) {
					return;
				}

				// (4) 선택된 노트의 텍스트를 갖는 텍스트 위젯을 생성한다.
				Text newEditor = new Text(tree, SWT.NONE);
				newEditor.setText(item.getText());
				newEditor.addModifyListener(new ModifyListener() {
					// (5) 텍스트 위젯의 텍스트가 바뀌면, 해당 노드의 텍스트도 바꾸어 준다.
					public void modifyText(ModifyEvent e) {
						Text text = (Text) editor.getEditor();
						editor.getItem().setText(text.getText());
					}
				});
				newEditor.selectAll(); // (6) 텍스트 위젯의 모든 텍스트가 선택되도록 한다.
				newEditor.setFocus(); // (7) 텍스트 위젯이 포커스를 갖도록 한다.
				editor.setEditor(newEditor, item); // (8) 트리 에디터의 새로운 에디터로서,
				// 텍스트 위젯을 설정한다.
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
