package org.rndclub.registry;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class RegistryUserTest {
	// �־��� ��忡 Ű�� �����ϰ� �ִ��� üũ�Ѵ�.
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
