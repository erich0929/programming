package org.rndclub.fd.main;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.rndclub.fd.model.LabelList;
import org.rndclub.fd.model.Parameters;
import org.rndclub.fd.ui.ClientCompoDesign;
import org.rndclub.fd.ui.GraphicsModel;
import org.rndclub.fd.ui.Loader;
import org.rndclub.fd.ui.ShowMessageBox;
import org.rndclub.fd.util.LoggerModel;

public class FileDownload {

	public static HttpClient client = null;

	public static Display display = null;

	public static Shell shell = null;

	public static Parameters params = null;

	public static LabelList labels = null;

	ClientCompoDesign clientUI = null;
	// ClientCompoRaw clientUI = null;

	public FileDownload(String[] args) {
		display = new Display();
		GraphicsModel.init(display);
		shell = new Shell(display, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL
				| SWT.CENTER);
		int w = display.getBounds().width;// toolkit.getScreenSize().width;
		int h = display.getBounds().height;// toolkit.getScreenSize().height;
		shell.setLocation(w / 2, h / 2);
		shell.setSize(1, 1);
		shell.open();

		Loader.init(shell, 100);
		Loader.setSelection(10);
		try {
			params = Parameters.makeInstance(args);
			Loader.setSelection(20);
			connectSession();
			Loader.setSelection(40);

			String url = params.getParameter("serverUrl")
					+ params.getParameter("labelUrl");
			labels = LabelList.makeInstance(url);
		} catch (Exception e) {
			e.printStackTrace();
			LoggerModel.log(e);
		}
		Loader.setSelection(70);

		shell.setText(FileDownload.labels.get("shell.title"));
		shell.setImage(GraphicsModel.getImage(GraphicsModel.IMAGE_ICON));

		createUi();
		Loader.setSelection(80);
		doLayout();
		Loader.setSelection(90);
		addListener();
		Loader.setSelection(100);
	}
	public void createUi() {
		clientUI = new ClientCompoDesign(shell, SWT.NONE);
		// clientUI = new ClientCompoRaw(shell, SWT.NONE);
	}

	public void doLayout() {
		shell.setLayout(new FillLayout());
	}

	public void addListener() {
		shell.addShellListener(new ShellAdapter() {

			public void shellClosed(ShellEvent e) {
				String title = "Confirm!!!";
				String message = "Exit?";
				int style = SWT.OK | SWT.CANCEL | SWT.ICON_QUESTION;
				MessageBox dialog = new MessageBox(shell, style);
				dialog.setText(title);
				dialog.setMessage(message);

				int flag = dialog.open();
				if (flag == SWT.OK) {
					e.doit = true;
				} else {
					e.doit = false;
				}
			}
		});
	}

	public static void connectSession() {
		client = new HttpClient();

		HttpMethod method = null;
		try {
			HttpConnectionManager manager = client.getHttpConnectionManager();
			HttpConnectionManagerParams params = manager.getParams();
			params.setConnectionTimeout(8000);

			String qs = "?sysname="
					+ FileDownload.params.getParameter("sysname") + "&id="
					+ FileDownload.params.getParameter("id") + "&sid="
					+ FileDownload.params.getParameter("sessionId") + "&pass="
					+ FileDownload.params.getParameter("pass");

			String url = (String) FileDownload.params.getParameter("serverUrl")
					+ FileDownload.params.getParameter("loginUrl") + qs;
			LoggerModel.logln("[FileDownload#connectSession] url => " + url);
			method = new GetMethod(url);

			int statusCode = client.executeMethod(method);
			LoggerModel.logln("[FileDownload#connectSession] QueryString>>> "
					+ method.getQueryString());
			LoggerModel.logln("[FileDownload#connectSession] Status Text>>>"
					+ HttpStatus.getStatusText(statusCode));

			String result = method.getResponseBodyAsString();
			LoggerModel.logln("[FileDownload#connectSession] result==>"
					+ result);
		} catch (Exception e) {
			e.printStackTrace();
			LoggerModel.log(e);

			ShowMessageBox.showErrorBox(FileDownload.shell,
					"[DownloadFile-download] " + e.getMessage());
		} finally {
			if (method != null) {
				method.releaseConnection();
			}
		}
	}

	public boolean init() {
		return clientUI.init();
	}

	public void dispose() {
		GraphicsModel.dispose();
		if ((display != null) && (!display.isDisposed())) {
			display.dispose();
		}
	}

	public void run() {
		Loader.destroy();

		int w = display.getBounds().width;// toolkit.getScreenSize().width;
		int h = display.getBounds().height;// toolkit.getScreenSize().height;
		shell.setSize(432 + 6, 454 + 32);
		shell.setLocation((int) ((w - (432 + 6)) / 2),
				(int) ((h - (454 + 32)) / 2));

		// shell.pack();
		shell.setFocus();
		shell.forceFocus();
		shell.setActive();

		if (init() == true) {
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		}

		dispose();
	}
	public static void main(String[] args) {
		LoggerModel.setDir("E:\\Temp");
		LoggerModel.enable(true);
		LoggerModel.stdout(true);

		if ((args == null) || (args.length < 1)) {
			args = new String[]{"id=dmadmin", "sessionId=12345",
					"serverUrl=http://127.0.0.1:8080",
					"downUrl=/fd/jsp/DownloadList.jsp",
					"labelUrl=/fd/jsp/LabelList.jsp",
					"loginUrl=/fd/jsp/Login.jsp"};
		}

		for (int i = 0; i < args.length; i++) {
			LoggerModel.logln("args[" + i + "] : " + args[i]);
		}

		FileDownload photoUpload = new FileDownload(args);
		photoUpload.run();

		LoggerModel.close();
		System.exit(0);
	}
}
