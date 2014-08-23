package org.rndclub.fd.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.rndclub.fd.http.HttpGet;
import org.rndclub.fd.main.FileDownload;
import org.rndclub.fd.ui.ShowMessageBox;
import org.rndclub.fd.util.LoggerModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class FileList {
	ArrayList list = null;

	public FileList() {
		list = new ArrayList();
	}

	public boolean contains(FileItem item) {
		if (list == null) {
			return (false);
		}
		return (list.contains(item));
	}

	public FileItem get(int i) {
		if (list == null) {
			return null;
		}
		return ((FileItem) list.get(i));
	}

	public boolean add(FileItem item) {
		if (list == null) {
			list = new ArrayList();
		} else {
			if (list.contains(item)) {
				return (false);
			}
		}
		list.add(item);
		return (true);
	}

	public boolean remove(FileItem item) {
		if (list == null) {
			return (false);
		}
		return (list.remove(item));
	}

	public void clear() {
		if (list != null) {
			list.clear();
		}
	}

	public int size() {
		if (list == null) {
			return (-1);
		}
		return (list.size());
	}

	public static FileList makeInstance(InputStream is) {
		FileList list = new FileList();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(is);
			Element root = document.getDocumentElement();
			LoggerModel.logln("[FileList-makeInstance] root : " + root);
            
			if ((root != null) && (root.hasChildNodes())) {
				NodeList nodeList = root.getChildNodes();
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					LoggerModel.logln("[FileList-makeInstance(is)] node[" + i
							+ "] : " + node);
					FileItem item = FileItem.makeInstance(node);
					list.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerModel.log(e);

			ShowMessageBox.showErrorBox(FileDownload.shell,
					"[FileList-makeInstance(is)] '" + e.getMessage() + "'");
		}
		return (list);
	}

	public static FileList makeInstance(String url) {
		FileList list = new FileList();
		try {
            String xml = HttpGet.getContents(FileDownload.client, url);
            LoggerModel.logln("[FileList#makeInstance] url -----------------\n"+xml);
            InputStream is = new ByteArrayInputStream(xml.getBytes());

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setIgnoringComments(false);
			factory.setIgnoringElementContentWhitespace(false);

			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(is);
			Element root = document.getDocumentElement();
			LoggerModel.logln("[FileList-makeInstance] root : " + root);
			if ((root != null) && (root.hasChildNodes())) {
				NodeList nodeList = root.getChildNodes();
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					String name = node.getNodeName();
					if ("#text".equals(name)) {
						continue;
					}
					LoggerModel.logln("[FileItem-makeInstance] name : " + name);
					if ("file".equals(name)) {
						LoggerModel.logln("[FileList-makeInstance(url)] node["
								+ i + "] : " + node);
						FileItem item = FileItem.makeInstance(node);
						list.add(item);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerModel.log(e);

			ShowMessageBox.showErrorBox(FileDownload.shell,
					"[FileList-makeInstance(url)] " + e.getMessage());
		}
		return (list);
	}

	public static void main(String[] args) {
		LoggerModel.init();
		LoggerModel.stdout(true);

		String url = "http://127.0.0.1:8080/lgepisw/jsp/DownloadList.jsp";
		FileList fileList = FileList.makeInstance(url);
		for (int i = 0; i < fileList.size(); i++) {
			FileItem item = (FileItem) fileList.get(i);
			System.out.println("item : " + item);
		}
	}
}
