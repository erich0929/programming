package org.rndclub.fd.model;

import java.util.Hashtable;

import org.rndclub.fd.util.LoggerModel;

public class Parameters {
	Hashtable hash = null;

	public Parameters() {
		hash = new Hashtable();
	}

	public Parameters(String args[]) {
		hash = new Hashtable();
		parse(args);
	}

	public void parse(String args[]) {
		for (int i = 0; (args != null) && (i < args.length); i++) {
			String str = args[i];
			LoggerModel.logln("[Parameters-parse] str[" + i + "] : " + str);
			int index = str.indexOf('=');
			if (index > 0) {
				String name = str.substring(0, index);
				String value = str.substring(index + 1);
				LoggerModel.logln("[Parameters-parse] name  : " + name
						+ ", value : " + value);
				hash.put(name, value);
			} else {
				hash.put("NOID-" + i, str);
			}
		}
	}

	public String getParameter(String id) {
		return ((String) hash.get(id));
	}

	public void putParameter(String id, String value) {
		hash.put(id, value);
	}

	public String toString() {
		return ((hash == null) ? "null" : hash.toString());
	}

	public static Parameters makeInstance(String args[]) {
		Parameters params = new Parameters(args);

		return (params);
	}

	public static void main(String args[]) {
		args = new String[]{"id=ywpark", "sessionId=12345", "modelId=60PY3DRF",
				"downUrl=http://127.0.0.1:8080/lgepisw/jsp/DownloadList.jsp?id=ywpark"};

		Parameters params = new Parameters(args);
		System.out.println("params : " + params);
	}
}
