package org.rndclub.registry;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class RegistryUserTest {
	// 주어진 노드에 키를 포함하고 있는지 체크한다.
	public static boolean contains(Preferences node, String key) {
		return node.get(key, null) != null;
	}

	public static void main(String args[]) throws BackingStoreException {
		Preferences userRootPrefs = Preferences.userRoot();

		String key = "uname";
		if (contains(userRootPrefs, key)) {
			String value = userRootPrefs.get(key, "");
			System.out.println("uname : " + value);
		} else {
			String value = "upark";
			userRootPrefs.put(key, value);
			System.out.println("create uname : " + value);
		}
	}
}
