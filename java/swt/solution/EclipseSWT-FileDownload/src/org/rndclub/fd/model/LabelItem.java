package org.rndclub.fd.model;

import org.rndclub.fd.util.LoggerModel;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class LabelItem {
	String id;

	String name;

	public LabelItem() {
		this.id = null;
		this.name = null;
	}

	public LabelItem(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static LabelItem makeInstance(Node node) {
		LabelItem item = new LabelItem();
		if ((node != null) && (node.hasChildNodes())) {
			NodeList nodeList = node.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node n = nodeList.item(i);
				String name = n.getNodeName();
				if ("#text".equals(name)) {
					continue;
				}
				LoggerModel.logln("[LabelItem-makeInstance] name : " + name);
				if ("id".equals(name)) {
					String value = n.getFirstChild().getNodeValue();
					LoggerModel.logln("[LabelItem-makeInstance] value : "
							+ value);
					item.setId(value);
				} else if ("name".equals(name)) {
					String value = n.getFirstChild().getNodeValue();
					LoggerModel.logln("[LabelItem-makeInstance] size : "
							+ value);
					item.setName(value);
				}
			}
		}
		LoggerModel.logln("[LabelItem-makeInstance] item : " + item);
		return (item);
	}

	public String toString() {
		StringBuffer strBuf = new StringBuffer();

		strBuf.append("id=");
		strBuf.append(id);
		strBuf.append(",name=");
		strBuf.append(name);

		return (strBuf.toString());
	}

	public String toXmlString() {
		StringBuffer strBuf = new StringBuffer();

		strBuf.append("<label>\n");
		strBuf.append("  <id>");
		strBuf.append(id);
		strBuf.append("  </id>\n");
		strBuf.append("  <name>");
		strBuf.append(name);
		strBuf.append("  </name>\n");
		strBuf.append("</label>");

		return (strBuf.toString());
	}

	public static void main(String[] args) {
		LabelItem fileItem = new LabelItem("id", "name");
		LoggerModel.logln("item : " + fileItem.toString());
	}
}
