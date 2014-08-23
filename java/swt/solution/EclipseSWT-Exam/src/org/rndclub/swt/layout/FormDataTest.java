package org.rndclub.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FormDataTest {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT FormData Test");

		FormLayout formLayout = new FormLayout();
		shell.setLayout(formLayout);

		Button button = new Button(shell, SWT.PUSH);
		button.setText("Button");

		FormData data = new FormData(); // (1) �� ������ ��ü�� �����Ѵ�.
		data.width = 200; // (2) ��Ʈ���� �ʺ� 200 �ȼ��� �����Ѵ�. 
		data.height = 40; // (3) ��Ʈ���� ���̸� 40 �ȼ��� �����Ѵ�. 
		data.top = new FormAttachment(0, 10); // (4) ��Ʈ���� ���� ���� ������ ���� �� ����ġ��Ʈ
		// ��ü�� �����Ѵ�.
		data.bottom = new FormAttachment(90, -20); // (5) ��Ʈ���� �Ʒ��� ���� ������ ���� ��
		// ����ġ��Ʈ ��ü�� �����Ѵ�.
		data.left = new FormAttachment(0, 30); // (6) ��Ʈ���� ���� ���� ������ ���� �� ����ġ��Ʈ
		// ��ü�� �����Ѵ�.
		data.right = new FormAttachment(90, -40); // (7) ��Ʈ���� ������ ���� ������ ���� ��
		// ����ġ��Ʈ ��ü�� �����Ѵ�.
		button.setLayoutData(data); // (8) ��Ʈ���� �� ������ ��ü�� �����Ѵ�.

		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
