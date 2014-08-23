package org.rndclub.fd.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Hashtable;

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


public class LabelList {
	Hashtable hash = null;

	public LabelList() {
		hash = new Hashtable();
		defaultInit();
	}

	public void defaultInit() {
		put("shell.title", "Eclipse SWT FileDownload by Java Web Start");
		put("button.change", "CHANGE");
		put("button.refresh", "REFRESH");
		put("button.start", "START");
		put("button.stop", "STOP");
		put("button.close", "CLOSE");
	}

	public String get(String id) {
		if (hash == null) {
			return null;
		}
		return ((String) hash.get(id));
	}

	public void put(String id, String name) {
		if (hash == null) {
			hash = new Hashtable();
		}
		hash.put(id, name);
	}

	public Object remove(String id) {
		if (hash == null) {
			return (null);
		}
		return (hash.remove(id));
	}

	public void clear() {
		if (hash != null) {
			hash.clear();
		}
	}

	public int size() {
		if (hash == null) {
			return (-1);
		}
		return (hash.size());
	}

	public String toString() {
		if (hash == null) {
			return (null);
		}
		return (hash.toString());
	}

	public static LabelList makeInstance(InputStream is) {
		LabelList list = new LabelList();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(is);
			Element root = document.getDocumentElement();
			LoggerModel.logln("[LabelList-makeInstance] root : " + root);
			if ((root != null) && (root.hasChildNodes())) {
				NodeList nodeList = root.getChildNodes();
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					LoggerModel.logln("[LabelList-makeInstance(is)] node[" + i
							+ "] : " + node);
					LabelItem item = LabelItem.makeInstance(node);
					list.put(item.getId(), item.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerModel.log(e);

			ShowMessageBox.showErrorBox(FileDownload.shell,
					"[LabelList-makeInstance(is)] '" + e.getMessage() + "'");
		}
		return (list);
	}

	public static LabelList makeInstance(String url) {
		LabelList list = new LabelList();
		try {
			String xml = HttpGet.getContents(FileDownload.client, url);
			LoggerModel.logln("[LabelList] xmlxmlxmlxmlx==>\n" + xml);
			InputStream is = new ByteArrayInputStream(xml.getBytes());

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setIgnoringComments(false);
			factory.setIgnoringElementContentWhitespace(false);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(is);

			Element root = document.getDocumentElement();
			LoggerModel.logln("[LabelList-makeInstance] root : " + root);
			if ((root != null) && (root.hasChildNodes())) {
				NodeList nodeList = root.getChildNodes();
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					String name = node.getNodeName();
					if ("#text".equals(name)) {
						continue;
					}
					LoggerModel
							.logln("[LabelList-makeInstance] name : " + name);
					if ("label".equals(name)) {
						LoggerModel.logln("[LabelList-makeInstance(url)] node["
								+ i + "] : " + node);
						LabelItem item = LabelItem.makeInstance(node);
						list.put(item.getId(), item.getName());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerModel.log(e);

			ShowMessageBox.showErrorBox(FileDownload.shell,
					"[LabelList-makeInstance(url)] " + e.getMessage());
		}
		return (list);
	}

	public static void main(String[] args) {
		LoggerModel.init();
		LoggerModel.stdout(true);

		String url = "http://127.0.0.1:8080/lgepisw/jsp/CodeList.jsp";
		LabelList labelList = LabelList.makeInstance(url);
		System.out.println("labelList : " + labelList);
	}
}
