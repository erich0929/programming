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
			String html = "<html><head><title>SWT 브라우저 위젯</title></head><body><h1>SWT 브라우저 위젯</h1><br><font color='blue'><b>브라우저 위젯</b></font>은 내부적으로 하부의 운영체제 플랫폼에서 제공하는 <i><b>네이티브 HTML 렌더링엔진</b></i>을 사용한다. 마이크로소프트의 <b>윈도우</b>에서는 <i>인터넷 익스플로러(Internet Explorer)</i>를 HTML 랜더링 엔진으로 사용할 것이고, <b>리눅스</b>에서는 <i>모질라(Mozilla)</i>를 사용하고, <b>맥 OS</b>에서는 <i>사파리(Safari)</i>를 사용한다. 따라서 SWT 어플리케이션에서는 브라우저 위젯을 이용하여 <u>메모리, 파일, 또는 URL 상에 존재하는 HTML 페이지를 보여주고 이동</u>할 수 있다.</body></html>";
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
