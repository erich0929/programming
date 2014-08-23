package org.rndclub.swt.program;

import org.eclipse.swt.program.*;
import org.eclipse.swt.widgets.*;

public class InvokeExternalBatchFile {

	public static void main(String[] args) {
		Display display = new Display();
		Program.launch("calc.exe");
		display.dispose();
	}
}
