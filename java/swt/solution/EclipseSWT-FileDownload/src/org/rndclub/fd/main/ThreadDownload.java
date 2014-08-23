package org.rndclub.fd.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.util.URIUtil;
import org.eclipse.swt.SWT;
import org.rndclub.fd.http.IProgress;
import org.rndclub.fd.model.FileItem;
import org.rndclub.fd.ui.ShowMessageBox;
import org.rndclub.fd.util.LoggerModel;


public class ThreadDownload extends Thread {
	HttpClient client;

	IProgress iprog;

	String dir;

	ArrayList fileList;

	boolean alive = false;

	public ThreadDownload(HttpClient client, IProgress iprog, String dir,
			ArrayList fileList) {
		this.client = client;
		this.iprog = iprog;
		this.dir = dir;
		this.fileList = fileList;
	}

	public boolean running() {
		return (alive);
	}

	public void kill() {
		alive = false;
		LoggerModel.logln("[ThreadDownload-kill] KILL...");
	}

	public void run() {
		alive = true;
		if (fileList == null) {
			alive = false;
			iprog.finish();
			return;
		}

		int n = fileList.size();
		for (int i = 0; (alive == true) && (i < n); i++) {
			FileItem item = (FileItem) fileList.get(i);

			String url = item.getUrl();
			int size = item.getSize();
			String filename = item.getName();
			LoggerModel.logln("[ThreadDownload-run] url : " + url);
			LoggerModel.logln("[ThreadDownload-run] size : " + size);
			LoggerModel.logln("[ThreadDownload-run] filename : " + filename);

			iprog.initStatge(0, size);

			HttpMethod method = null;
			FileOutputStream out = null;
			try {
				HttpConnectionManager manager = client
						.getHttpConnectionManager();
				HttpConnectionManagerParams params = manager.getParams();
				params.setConnectionTimeout(8000);

				File file = null;
				if (dir == null) {
					file = new File(filename);
				} else {
					file = new File(new File(dir), filename);
				}
				long offset = 0;
				boolean append = false;
				if (file.exists()) {
					int flag = ShowMessageBox.showYesNoCancleCancleQuestionBox(
							FileDownload.shell, "Continue?");
					if (flag == SWT.YES) {
						offset = file.length();
						append = true;
						if (iprog != null) {
							iprog.incP((int) offset);
						}
					} else if (flag == SWT.NO) {
						file.delete();
						if (dir == null) {
							file = new File(filename);
						} else {
							file = new File(new File(dir), filename);
						}
					} else if (flag == SWT.CANCEL) {
					}
				}
				if (url.indexOf('?') >= 0) {
					url += "&offset=" + offset;
				}

				if (url.indexOf('?') < 0) {
					url = URIUtil.encodePath(url);
				}
				LoggerModel.logln("[ThreadDownload-run] url : " + url);
				method = new GetMethod(url);

				int statusCode = client.executeMethod(method);

				LoggerModel.logln("[ThreadDownload-run] QueryString : "
						+ method.getQueryString());
				LoggerModel.logln("[ThreadDownload-run] StatusText : "
						+ HttpStatus.getStatusText(statusCode));

				InputStream is = method.getResponseBodyAsStream();

				out = new FileOutputStream(file, append);
				byte buf[] = new byte[1024];
				while (alive == true) {
					int len = is.read(buf);
					// LoggerModel.logln("[download] " + len);
					if (len > 0) {
						out.write(buf, 0, len);
					}
					if (len < 0) {
						break;
					}
					if (iprog != null) {
						iprog.incP(len);
					}
					// Thread.sleep(1);
				}
				LoggerModel.logln("[ThreadDownload-run-while] FINISH");
			} catch (Exception e) {
				e.printStackTrace();
				LoggerModel.log(e);

				ShowMessageBox.showErrorBox(FileDownload.shell,
						"[ThreadDownload-run] " + e.getMessage());
			} finally {
				if (method != null) {
					method.releaseConnection();
				}
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
						LoggerModel.log(e);

						ShowMessageBox.showErrorBox(FileDownload.shell,
								"[ThreadDownload-run] " + e.getMessage());
					}
				}
			}

			LoggerModel.logln("[ThreadDownload-run] i : '" + i + "'");
		}
		alive = false;
		iprog.finish();

		LoggerModel.logln("[ThreadDownload-run] FINISH...");
	}
}
