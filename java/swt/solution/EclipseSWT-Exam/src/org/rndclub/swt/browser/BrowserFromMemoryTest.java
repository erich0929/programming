package org.rndclub.swt.browser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class BrowserFromMemoryTest {
	public static void exit(Shell shell, String message) {
		MessageBox mbox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
		mbox.setText("Error!!!");
		mbox.setMessage("[Browser] e : " + message);
		mbox.open();

		System.exit(-1);
	}

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT Browser Test");

		Browser browser = null;
		try {
			browser = new Browser(shell, SWT.NONE);
			String html = "<html><head><title>SWT ������ ����</title></head><body><h1>SWT ������ ����</h1><br><font color='blue'><b>������ ����</b></font>�� ���������� �Ϻ��� �ü�� �÷������� �����ϴ� <i><b>����Ƽ�� HTML ����������</b></i>�� ����Ѵ�. ����ũ�μ���Ʈ�� <b>������</b>������ <i>���ͳ� �ͽ��÷η�(Internet Explorer)</i>�� HTML ������ �������� ����� ���̰�, <b>������</b>������ <i>������(Mozilla)</i>�� ����ϰ�, <b>�� OS</b>������ <i>���ĸ�(Safari)</i>�� ����Ѵ�. ���� SWT ���ø����̼ǿ����� ������ ������ �̿��Ͽ� <u>�޸�, ����, �Ǵ� URL �� �����ϴ� HTML �������� �����ְ� �̵�</u>�� �� �ִ�.</body></html>";
			browser.setText(html);
			System.out.println("browser.getUrl : '" + browser.getUrl() + "'");
		} catch (SWTError e) {
			e.printStackTrace();

			exit(shell, e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();

			exit(shell, e.getMessage());
		}

		shell.setSize(480, 320);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}
