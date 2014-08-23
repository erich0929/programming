package org.rndclub.registry;

import java.util.Enumeration;

import com.ice.jni.registry.NoSuchValueException;
import com.ice.jni.registry.RegStringValue;
import com.ice.jni.registry.Registry;
import com.ice.jni.registry.RegistryException;
import com.ice.jni.registry.RegistryKey;

public class RegistryModel {
	private static final String REG_AMS_CLIENT_PARAMS = "Software\\RnDClub\\Client\\Params";

	private static final String REG_WILY_WS_PARAMS = "Software\\RnDClub\\wily";

	public static final String REG_AMS_KEY_CLASSNAME = "AMS";

	public static final String REG_AMS_KEY_ID = "id";

	public static final String REG_AMS_KEY_DIR_HOME = "home";

	public static final String REG_AMS_KEY_DB_DRIVER = "dbDriver";

	public static final String REG_AMS_KEY_DB_URL = "dbUrl";

	public static final String REG_AMS_KEY_DB_USER = "dbUser";

	public static final String REG_AMS_KEY_DB_PASS = "dbPass";

	private static RegistryKey amsClientParamsRkey = null;

	private static RegistryKey wilyWsParamsRkey = null;
	static {
		amsClientParamsRkey = getCurrentUserRegistryKey(REG_AMS_CLIENT_PARAMS);
		wilyWsParamsRkey = getCurrentUserRegistryKey(REG_WILY_WS_PARAMS);
	}

	public static String getDefaultBrowserCommand() {
		String value = null;
		String name = "http\\shell\\open\\command";
		try {
			RegistryKey rkey = Registry.HKEY_CLASSES_ROOT.createSubKey(name,
					"", RegistryKey.ACCESS_ALL);
			// System.out.println("rkey : " + rkey);
			value = rkey.getStringValue("");
		} catch (RegistryException e) {
			e.printStackTrace();
		}
		return (value);
	}

	public static RegistryKey getCurrentUserRegistryKey(String name) {
		RegistryKey rkey = null;
		try {
			rkey = Registry.HKEY_CURRENT_USER.createSubKey(name,
					REG_AMS_KEY_CLASSNAME, RegistryKey.ACCESS_ALL);
			if (rkey.wasCreated() == true) {
				System.out.println("'" + name + "' rkey was created...");
			}
		} catch (RegistryException e) {
			e.printStackTrace();
		}
		return (rkey);
	}

	public static String getAmsClientParameter(String name) {
		String value = null;
		try {
			if (amsClientParamsRkey == null) {
				amsClientParamsRkey = getCurrentUserRegistryKey(REG_AMS_CLIENT_PARAMS);
			}
			value = amsClientParamsRkey.getStringValue(name);
		} catch (RegistryException e) {
			e.printStackTrace();
		}
		return (value);
	}

	public static void putAmsClientParameter(String name, String str) {
		try {
			RegStringValue value = new RegStringValue(amsClientParamsRkey,
					name, str);
			amsClientParamsRkey.setValue(name, value);
		} catch (NoSuchValueException e) {
			e.printStackTrace();
		} catch (RegistryException e) {
			e.printStackTrace();
		}
	}

	public static String getWilyWsParameter(String name) {
		String value = null;
		try {
			if (wilyWsParamsRkey == null) {
				wilyWsParamsRkey = getCurrentUserRegistryKey(REG_WILY_WS_PARAMS);
			}
			value = wilyWsParamsRkey.getStringValue(name);
		} catch (RegistryException e) {
			e.printStackTrace();
		}
		return (value);
	}

	public static void test() {
		try {
			System.out.println("getFullName 				: "
					+ amsClientParamsRkey.getFullName());
			System.out.println("getMaxSubkeyLength 		: "
					+ amsClientParamsRkey.getMaxSubkeyLength());
			System.out.println("getMaxValueDataLength 	: "
					+ amsClientParamsRkey.getMaxValueDataLength());
			System.out.println("getMaxValueNameLength 	: "
					+ amsClientParamsRkey.getMaxValueNameLength());
			System.out.println("getName 					: "
					+ amsClientParamsRkey.getName());
			System.out.println("getNumberSubkeys 			: "
					+ amsClientParamsRkey.getNumberSubkeys());
			System.out.println("getNumberValues 			: "
					+ amsClientParamsRkey.getNumberValues());

			Enumeration e = amsClientParamsRkey.valueElements();
			System.out.println("e : " + e.toString());
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String val = amsClientParamsRkey.getStringValue(key);
				System.out.println("key : " + key + ", val : " + val);
			}
			for (int i = 0; i < amsClientParamsRkey.getNumberValues(); i++) {
				String key = amsClientParamsRkey.regEnumValue(i);
				String val = amsClientParamsRkey.getStringValue(key);
				System.out.println("key : " + key + ", val : " + val);
			}
		} catch (RegistryException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		test();

		putAmsClientParameter("server", "172.19.99.1");
		String value = getAmsClientParameter("server");
		System.out.println("server : " + value);

		putAmsClientParameter("dbUrl",
				"jdbc:oracle:thin:@172.19.99.1:1521:openview");
		value = getAmsClientParameter("dbUrl");
		System.out.println("dbUrl : " + value);

		putAmsClientParameter("workspace", "D:\\workspace");
		value = getAmsClientParameter("workspace");
		System.out.println("workspace : " + value);

		putAmsClientParameter("home", "D:\\Temp\\ams_client");
		value = getAmsClientParameter("home");
		System.out.println("home : " + value);

		value = getAmsClientParameter("id");
		System.out.println("id : " + value);

		value = getDefaultBrowserCommand();
		System.out.println("ie : " + value);

		value = getWilyWsParameter("Install Path");
		System.out.println("Install Path : " + value);

		 test();
	}
}
