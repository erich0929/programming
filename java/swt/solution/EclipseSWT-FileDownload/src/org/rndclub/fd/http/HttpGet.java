package org.rndclub.fd.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.URIUtil;
import org.rndclub.fd.main.FileDownload;
import org.rndclub.fd.ui.ShowMessageBox;
import org.rndclub.fd.util.LoggerModel;

public class HttpGet {
	// private static String urlDownload =
	private static String urlDownload = "http://127.0.0.1:8080/fd/down/A20070331.jpg";
	// private static String urlLabel =
	// "http://127.0.0.1:8080/fd/jsp/LabelList.jsp";
	// private static String urlLogin =
	// "http://127.0.0.1:8080/fd/jsp/Login.jsp";

	public static boolean login(HttpClient client, String url, String id,
			String pass) {
		if (client == null) {
			return (false);
		}

		HttpMethod method = null;
		try {
			// Instantiate a GET HTTP method
			method = new GetMethod(url);
			LoggerModel.logln("url  : " + url);

			// Define name-value pairs to set into the QueryString
			NameValuePair idPair = new NameValuePair("id", id);
			NameValuePair passPair = new NameValuePair("pass", pass);

			method.setQueryString(new NameValuePair[]{idPair, passPair});

			int status = client.executeMethod(method);
			String res = method.getResponseBodyAsString();

			LoggerModel.logln("Query  : " + method.getQueryString());
			LoggerModel.logln("Status : " + HttpStatus.getStatusText(status));
			LoggerModel.logln("ResponseBody >>>\n" + res);
			return (true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (method != null) {
				method.releaseConnection();
			}
		}
		return (false);
	}

	public static String getContents(HttpClient client, String url) {
		HttpMethod method = null;
		try {
			LoggerModel.logln("[DownloadFile#getContents] url=>" + url);
			// url = URIUtil.encodePath(url);
			method = new GetMethod(url);

			int statusCode = client.executeMethod(method);

			LoggerModel.logln("[getContents] QueryString>>> "
					+ method.getQueryString());
			LoggerModel.logln("[getContents] Status Text>>>"
					+ HttpStatus.getStatusText(statusCode));

			String res = method.getResponseBodyAsString();
			return (res);
		} catch (Exception e) {
			e.printStackTrace();
			LoggerModel.log(e);

			ShowMessageBox.showErrorBox(FileDownload.shell,
					"[DownloadFile-getList] " + e.getMessage());
		} finally {
			if (method != null) {
				method.releaseConnection();
			}
		}
		return (null);
	}

	public static boolean download(HttpClient client, IProgress iprog,
			String url, String filename) {
		HttpMethod method = null;
		try {
			LoggerModel.logln("[DownloadFile#download] filename=>" + filename);
			LoggerModel.logln("[DownloadFile#download] url=>" + url);

			File file = new File(filename);
			url = URIUtil.encodePath(url);
			method = new GetMethod(url);

			int statusCode = client.executeMethod(method);

			LoggerModel.logln("[download] QueryString>>> "
					+ method.getQueryString());
			LoggerModel.logln("[download] Status Text>>>"
					+ HttpStatus.getStatusText(statusCode));

			InputStream is = method.getResponseBodyAsStream();

			FileOutputStream out = new FileOutputStream(file);
			byte buf[] = new byte[1024];
			while (true) {
				int len = is.read(buf);
				if (len > 0) {
					out.write(buf, 0, len);
				}
				if (len < 0) {
					break;
				}
				if (iprog != null) {
					iprog.incP(len);
				}
				LoggerModel.logln("[download] " + len);
				// Thread.sleep(1);
			}
			out.close();

			return (true);
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
		return (false);
	}

	public static void main(String[] args) throws IOException {
		LoggerModel.setDir("E:\\temp");
		LoggerModel.enable(true);
		LoggerModel.stdout(true);

		HttpClient client = new HttpClient();

		HttpGet.download(client, null, urlDownload, "E:\\temp\\º¸¼º³ìÂ÷¹ç.jpg");
		// HttpGet.login(client, urlLogin, "ywpark", "1234");
		// String str = HttpGet.getContents(client, urlLabel);
		// System.out.println("str : " + str);
	}
}