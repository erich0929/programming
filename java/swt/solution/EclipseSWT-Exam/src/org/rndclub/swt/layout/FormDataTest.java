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

		FormData data = new FormData(); // (1) 폼 데이터 객체를 생성한다.
		data.width = 200; // (2) 컨트롤의 너비를 200 픽셀로 설정한다. 
		data.height = 40; // (3) 컨트롤의 높이를 40 픽셀로 설정한다. 
		data.top = new FormAttachment(0, 10); // (4) 컨트롤의 위쪽 측면 공간을 위한 폼 어태치먼트
		// 객체를 설정한다.
		data.bottom = new FormAttachment(90, -20); // (5) 컨트롤의 아래쪽 측면 공간을 위한 폼
		// 어태치먼트 객체를 설정한다.
		data.left = new FormAttachment(0, 30); // (6) 컨트롤의 왼쪽 측면 공간을 위한 폼 어태치먼트
		// 객체를 설정한다.
		data.right = new FormAttachment(90, -40); // (7) 컨트롤의 오른쪽 측면 공간을 위한 폼
		// 어태치먼트 객체를 설정한다.
		button.setLayoutData(data); // (8) 컨트롤의 폼 데이터 객체를 설정한다.

		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
