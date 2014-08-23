package org.rndclub.swt.p11x;

/*
 * Program example snippet: invoke an external batch file
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.program.*;
import org.eclipse.swt.widgets.*;

public class InvokeExternalBatchFile {

	public static void main(String[] args) {
		Display display = new Display();
		Program.launch("calc.exe");
		display.dispose();
	}

}
