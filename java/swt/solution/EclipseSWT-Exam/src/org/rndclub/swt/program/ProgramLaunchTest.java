package org.rndclub.swt.program;

import org.eclipse.swt.program.*;
import org.eclipse.swt.widgets.*;

public class ProgramLaunchTest {

	public static void main(String[] args) {
		Display display = new Display();

		boolean flag = Program.launch("E:\\temp\\server.xml");
		System.out.println("flag : " + flag);

		display.dispose();
	}
}
