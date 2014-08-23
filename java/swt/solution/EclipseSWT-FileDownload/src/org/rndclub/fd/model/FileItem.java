package org.rndclub.fd.model;

import org.rndclub.fd.util.LoggerModel;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class FileItem {
	String name;

	int size;

	String type;

	String path;

	String url;

	public FileItem() {
		this.name = null;
		this.size = 0;
		this.type = null;
		this.path = null;
		this.url = null;
	}

	public FileItem(String name, int size, String type, String path, String url) {
		this.name = name;
		this.size = size;
		this.type = type;
		this.path = path;
		this.url = url;
	}

	public FileItem(String name, String size, String type, String path,
			String url) {
		this.name = name;
		try {
			this.size = Integer.parseInt(size);
		} catch (Exception e) {
			e.printStackTrace();
			this.size = 0;
		}
		this.type = type;
		this.path = path;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public String getSizeWithComma() {
		StringBuffer strBuf = new StringBuffer();
		String str = "" + size;
		for (int i = 1, n = str.length() - 1; n >= 0; i++, n--) {
			strBuf.insert(0, str.charAt(n));
			if ((i % 3 == 0) && (n > 0)) {
				strBuf.insert(0, ',');
			}
		}

		return strBuf.toString();
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setSize(String size) {
		try {
			this.size = Integer.parseInt(size);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static FileItem makeInstance(Node node) {
		FileItem item = new FileItem();
		if ((node != null) && (node.hasChildNodes())) {
			NodeList nodeList = node.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node n = nodeList.item(i);
				String name = n.getNodeName();
				if ("#text".equals(name)) {
					continue;
				}
				LoggerModel.logln("[FileItem-makeInstance] name : " + name);
				if ("name".equals(name)) {
					String value = n.getFirstChild().getNodeValue();
					LoggerModel.logln("[FileItem-makeInstance] value : "
							+ value);
					item.setName(value);
				} else if ("size".equals(name)) {
					String value = n.getFirstChild().getNodeValue();
					LoggerModel
							.logln("[FileItem-makeInstance] size : " + value);
					item.setSize(value);
				} else if ("type".equals(name)) {
					String value = n.getFirstChild().getNodeValue();
					LoggerModel
							.logln("[FileItem-makeInstance] type : " + value);
					item.setType(value);
				} else if ("path".equals(name)) {
					String value = n.getFirstChild().getNodeValue();
					LoggerModel
							.logln("[FileItem-makeInstance] path : " + value);
					item.setPath(value);
				} else if ("url".equals(name)) {
					String value = n.getFirstChild().getNodeValue();
					LoggerModel.logln("[FileItem-makeInstance] url : " + value);
					item.setUrl(value);
				}
			}
		}
		LoggerModel.logln("[FileItem-makeInstance] item : " + item);
		return (item);
	}

	public String toString() {
		StringBuffer strBuf = new StringBuffer();

		strBuf.append("name=");
		strBuf.append(name);
		strBuf.append(",size=");
		strBuf.append(size);
		strBuf.append(",type=");
		strBuf.append(type);
		strBuf.append(",path=");
		strBuf.append(path);
		strBuf.append(",url=");
		strBuf.append(url);

		return (strBuf.toString());
	}

	public String toXmlString() {
		StringBuffer strBuf = new StringBuffer();

		strBuf.append("<file>\n");
		strBuf.append("  <name>");
		strBuf.append(name);
		strBuf.append("  </name>\n");
		strBuf.append("  <size>");
		strBuf.append(size);
		strBuf.append("  </size>\n");
		strBuf.append("  <type>");
		strBuf.append(type);
		strBuf.append("  </type>\n");
		strBuf.append("  <path>");
		strBuf.append(path);
		strBuf.append("  </path>\n");
		strBuf.append("  <url>");
		strBuf.append(url);
		strBuf.append("  </url>\n");
		strBuf.append("</file>");

		return (strBuf.toString());
	}

	public static void main(String[] args) {
		FileItem fileItem = new FileItem("name", 1, "type", "path", "url");
		System.out.println("Size : " + fileItem.getSizeWithComma());
		fileItem = new FileItem("name", 12, "type", "path", "url");
		System.out.println("Size : " + fileItem.getSizeWithComma());
		fileItem = new FileItem("name", 123, "type", "path", "url");
		System.out.println("Size : " + fileItem.getSizeWithComma());
		fileItem = new FileItem("name", 1234, "type", "path", "url");
		System.out.println("Size : " + fileItem.getSizeWithComma());
		fileItem = new FileItem("name", 12345, "type", "path", "url");
		System.out.println("Size : " + fileItem.getSizeWithComma());
	}
}
