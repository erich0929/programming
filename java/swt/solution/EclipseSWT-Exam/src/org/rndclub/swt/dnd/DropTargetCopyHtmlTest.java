package org.rndclub.swt.dnd;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class DropTargetCopyHtmlTest {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("SWT DropTarget Test");

		final Browser browser = new Browser(shell, SWT.NONE);
		try {
			String html = "<html><head><title>SWT ������ ����</title></head><body><h1>SWT ������ ����</h1><br><font color='blue'><b>������ ����</b></font>�� ���������� �Ϻ��� �ü�� �÷������� �����ϴ� <i><b>����Ƽ�� HTML ����������</b></i>�� ����Ѵ�. ����ũ�μ���Ʈ�� <b>������</b>������ <i>���ͳ� �ͽ��÷η�(Internet Explorer)</i>�� HTML ������ �������� ����� ���̰�, <b>������</b>������ <i>������(Mozilla)</i>�� ����ϰ�, <b>�� OS</b>������ <i>���ĸ�(Safari)</i>�� ����Ѵ�. ���� SWT ���ø����̼ǿ����� ������ ������ �̿��Ͽ� <u>�޸�, ����, �Ǵ� URL �� �����ϴ� HTML �������� �����ְ� �̵�</u>�� �� �ִ�.</body></html>";
			browser.setText(html);
			System.out.println("browser.getUrl : '" + browser.getUrl() + "'");
		} catch (SWTError e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		int operations = DND.DROP_DEFAULT | DND.DROP_COPY | DND.DROP_MOVE
				| DND.DROP_LINK;
		Transfer[] types = new Transfer[]{TextTransfer.getInstance()};//,HTMLTransfer.getInstance()};
		DropTarget target = new DropTarget(browser, operations);
		target.setTransfer(types);

		target.addDropListener(new DropTargetAdapter() {
			public void dragEnter(DropTargetEvent e) {
				System.out.println("[dragEnter] e : " + e);
				if (e.detail == DND.DROP_DEFAULT) {
					e.detail = DND.DROP_COPY;
				}
			}

			public void dragOperationChanged(DropTargetEvent e) {
				System.out.println("[dragOperationChanged] e : " + e);
				if (e.detail == DND.DROP_DEFAULT) {
					e.detail = DND.DROP_COPY;
				}
			}

			public void drop(DropTargetEvent e) {
				System.out.println("[drop] e : " + e);
				if (e.data == null) {
					e.detail = DND.DROP_NONE;
					return;
				}
				browser.setText((String) e.data);
			}
		});

		shell.setLocation(display.getBounds().width - 320,
				display.getBounds().height - 240);
		shell.setSize(320, 240);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
