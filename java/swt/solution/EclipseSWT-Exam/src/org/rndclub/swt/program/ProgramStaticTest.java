package org.rndclub.swt.program;

import org.eclipse.swt.program.*;
import org.eclipse.swt.widgets.*;

public class ProgramStaticTest {

	public static void main(String[] args) {
		Display display = new Display();
		String[] exts = Program.getExtensions();
		for (int i = 0; (exts != null) && (i < exts.length); i++) {
			System.out.println("exts[" + i + "] : " + exts[i]);
		}
		Program[] programs = Program.getPrograms();
		for (int i = 0; (programs != null) && (i < programs.length); i++) {
			System.out
					.println("programs[" + i + "] : " + programs[i].getName());
		}
		display.dispose();
	}
}
