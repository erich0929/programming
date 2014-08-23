package org.rndclub.swt.ole;

/*
 * OLE and ActiveX example snippet: browse the typelibinfo for a program id
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleControlSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Shell;

public class OleSetProperty {

	public static void main(String[] args) {

		Shell shell = new Shell();

		OleFrame frame = new OleFrame(shell, SWT.NONE);
		// Allow multiple selection in an embedded Calendar Control
		OleControlSite controlSite = new OleControlSite(frame, SWT.NONE,
				"MSComCtl2.MonthView");
		OleAutomation automation = new OleAutomation(controlSite);
		int[] rgdispid = automation
				.getIDsOfNames(new String[] { "MultiSelect" });
		int dispIdMember = rgdispid[0];
		Variant multiSelect = new Variant((short) 1); // set to true (0 =
														// false)
		automation.setProperty(dispIdMember, multiSelect);

		shell.dispose();
	}
}
