package org.rndclub.registry;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class RegistrySystemTest {
	// 주어진 노드에 키를 포함하고 있는지 체크한다.
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
