package org.rndclub.registry;

import java.util.Enumeration;

import com.ice.jni.registry.NoSuchValueException;
import com.ice.jni.registry.RegStringValue;
import com.ice.jni.registry.Registry;
import com.ice.jni.registry.RegistryException;
import com.ice.jni.registry.RegistryKey;

public class JNIRegistryTest {
	private static final String REG_SWT_PARAMS = "Software\\RnDClub\\Client\\Params";

	public static final String REG_AMS_KEY_CLASSNAME = "AMS";

	public static final String REG_AMS_KEY_ID = "id";

	public static final String REG_AMS_KEY_DIR_HOME = "home";

	public static final String REG_AMS_KEY_DB_DRIVER = "dbDriver";

	public static final String REG_AMS_KEY_DB_URL = "dbUrl";

	public static final String REG_AMS_KEY_DB_USER = "dbUser";

	public static final String REG_AMS_KEY_DB_PASS = "dbPass";

	private static RegistryKey amsClientParamsRkey = null;

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
					"", RegistryKey.ACCESS_ALL);
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
				amsClientParamsRkey = getCurrentUserRegistryKey(REG_SWT_PARAMS);
			}
			value = amsClientParamsRkey.getStringValue(name);
		} catch (RegistryException e) {
			e.printStackTrace();
		}
		return (value);
	}

	public static void putAmsClientParameter(String name, String str) {
		try {
			if (amsClientParamsRkey == null) {
				amsClientParamsRkey = getCurrentUserRegistryKey(REG_SWT_PARAMS);
			}
			RegStringValue value = new RegStringValue(amsClientParamsRkey,
					name, str);
			amsClientParamsRkey.setValue(name, value);
		} catch (NoSuchValueException e) {
			e.printStackTrace();
		} catch (RegistryException e) {
			e.printStackTrace();
		}
	}

	public static void test() {
		try {
			if (amsClientParamsRkey == null) {
				amsClientParamsRkey = getCurrentUserRegistryKey(REG_SWT_PARAMS);
			}
			System.out.println("getFullName : "
					+ amsClientParamsRkey.getFullName());
			System.out.println("getMaxSubkeyLength : "
					+ amsClientParamsRkey.getMaxSubkeyLength());
			System.out.println("getMaxValueDataLength : "
					+ amsClientParamsRkey.getMaxValueDataLength());
			System.out.println("getMaxValueNameLength : "
					+ amsClientParamsRkey.getMaxValueNameLength());
			System.out.println("getName : " + amsClientParamsRkey.getName());
			System.out.println("getNumberSubkeys : "
					+ amsClientParamsRkey.getNumberSubkeys());
			System.out.println("getNumberValues : "
					+ amsClientParamsRkey.getNumberValues());

			Enumeration e = amsClientParamsRkey.valueElements();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String val = amsClientParamsRkey.getStringValue(key);
				System.out.println("key : " + key + ", val : " + val);
			}
			/*
			 * System.out.println(); for (int i = 0; i <
			 * amsClientParamsRkey.getNumberValues(); i++) { String key =
			 * amsClientParamsRkey.regEnumValue(i); String val =
			 * amsClientParamsRkey.getStringValue(key); System.out.println("[" +
			 * i + "] key : " + key + ", val : " + val); }
			 */
		} catch (RegistryException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		test();

		putAmsClientParameter("server", "127.0.0.1");
		String value = getAmsClientParameter("server");
		System.out.println("server : " + value);

		putAmsClientParameter("dbUrl",
				"jdbc:oracle:thin:@127.0.0.1:1521:opendb");
		value = getAmsClientParameter("dbUrl");
		System.out.println("dbUrl : " + value);

		putAmsClientParameter("workspace", "D:\\workspace");
		value = getAmsClientParameter("workspace");
		System.out.println("workspace : " + value);

		putAmsClientParameter("home", "D:\\Temp\\ams_client");
		value = getAmsClientParameter("home");
		System.out.println("home : " + value);

		putAmsClientParameter("id", "ywoopark");
		value = getAmsClientParameter("id");
		System.out.println("id : " + value);

		value = getDefaultBrowserCommand();
		System.out.println("ie : " + value);
	}
}
