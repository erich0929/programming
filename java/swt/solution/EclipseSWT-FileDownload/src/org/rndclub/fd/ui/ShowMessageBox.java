package org.rndclub.fd.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.rndclub.fd.util.LoggerModel;


public class ShowMessageBox {
	public static String MSG_PLAY_FINISHED = "";

	public static int result = 0;

	public static int showDialog(final Shell shell, final int style,
			final String text, final String msg) {
		result = 0;
		try {
			if (shell != null) {
				//				shell.forceFocus();
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
			LoggerModel.log(e);
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

	public static int showYesNoCancleCancleQuestionBox(Shell shell, String msg) {
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
		LoggerModel.stdout(true);

		Display display = new Display();
		Shell shell = new Shell(display);
		GraphicsModel.init(display);

		LoggerModel.logln("" + showErrorBox(shell, "TEST"));
		LoggerModel.logln("" + showWarningBox(shell, "TEST"));
		LoggerModel.logln("" + showInformationBox(shell, "TEST"));
		LoggerModel.logln("" + showOkCancelQuestionBox(shell, "TEST"));
		LoggerModel.logln("" + showYesNoCancleCancleQuestionBox(shell, "TEST"));
		LoggerModel.logln("" + showRetryCancleQuestionBox(shell, "TEST"));
		LoggerModel.logln("" + showAbortRetryIgnoreQuestionBox(shell, "TEST"));
	}
}
