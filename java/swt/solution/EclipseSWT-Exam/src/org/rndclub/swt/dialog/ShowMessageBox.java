package org.rndclub.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class ShowMessageBox {
	public static int result = 0;

	public static int showDialog(final Shell shell, final int style,
			final String text, final String msg) {
		result = 0;
		try {
			if (shell != null) {
				// shell.forceFocus();
				shell.getDisplay().syncExec(new Runnable() {
					public void run() {
						MessageBox dialog = new MessageBox(shell, style);
						dialog.setText(text);
						dialog.setMessage(msg);
						result = dialog.open();
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (result);
	}

	public static int showErrorBox(Shell shell, String msg) {
		return showDialog(shell, SWT.OK | SWT.ICON_ERROR, "Error!", msg);
	}

	public static int showWarningBox(Shell shell, String msg) {
		return showDialog(shell, SWT.OK | SWT.ICON_WARNING, "Warning!", msg);
	}

	public static int showInformationBox(Shell shell, String msg) {
		return showDialog(shell, SWT.OK | SWT.ICON_INFORMATION, "Information!",
				msg);
	}

	public static int showOkCancelQuestionBox(Shell shell, String msg) {
		return showDialog(shell, SWT.OK | SWT.CANCEL | SWT.ICON_QUESTION,
				"Question!", msg);
	}

	public static int showYesNoQuestionBox(Shell shell, String msg) {
		return showDialog(shell, SWT.YES | SWT.NO | SWT.ICON_QUESTION,
				"Question!", msg);
	}

	public static int showYesNoCancleQuestionBox(Shell shell, String msg) {
		return showDialog(shell, SWT.YES | SWT.NO | SWT.CANCEL
				| SWT.ICON_QUESTION, "Question!", msg);
	}

	public static int showRetryCancleQuestionBox(Shell shell, String msg) {
		return showDialog(shell, SWT.RETRY | SWT.CANCEL | SWT.ICON_QUESTION,
				"Question!", msg);
	}

	public static int showAbortRetryIgnoreQuestionBox(Shell shell, String msg) {
		return showDialog(shell, SWT.ABORT | SWT.RETRY | SWT.IGNORE
				| SWT.ICON_QUESTION, "Question!", msg);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		System.out.println("" + showErrorBox(shell, "TEST"));
		System.out.println("" + showWarningBox(shell, "TEST"));
		System.out.println("" + showInformationBox(shell, "TEST"));
		System.out.println("" + showOkCancelQuestionBox(shell, "TEST"));
		System.out.println("" + showYesNoQuestionBox(shell, "TEST"));
		System.out.println("" + showYesNoCancleQuestionBox(shell, "TEST"));
		System.out.println("" + showRetryCancleQuestionBox(shell, "TEST"));
		System.out.println("" + showAbortRetryIgnoreQuestionBox(shell, "TEST"));
	}
}
