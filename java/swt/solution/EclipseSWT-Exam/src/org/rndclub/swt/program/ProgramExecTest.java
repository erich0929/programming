package org.rndclub.swt.program;

import org.eclipse.swt.program.*;
import org.eclipse.swt.widgets.*;

public class ProgramExecTest {

	public static void main(String[] args) {
		Display display = new Display();
		Program p = Program.findProgram(".txt");
		if (p != null) {
			p.execute("c:\\autoexec.bat"); // Windows-specific filename
		}
		display.dispose();
	}
}
