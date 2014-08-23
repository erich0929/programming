package org.rndclub.registry;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class RegistrySystemTest {
	// �־��� ��忡 Ű�� �����ϰ� �ִ��� üũ�Ѵ�.
	public static boolean contains(Preferences node, String key) {
		return node.get(key, null) != null;
	}

	public static void main(String args[]) throws BackingStoreException {
		Preferences systemRootPrefs = Preferences.systemRoot();
		String key = "xname";
		if (contains(systemRootPrefs, key)) {
			String value = systemRootPrefs.get(key, "");
			System.out.println("xname : " + value);
		} else {
			String value = "xpark";
			systemRootPrefs.put(key, value);
			System.out.println("create xname : " + value);
		}
	}
}
