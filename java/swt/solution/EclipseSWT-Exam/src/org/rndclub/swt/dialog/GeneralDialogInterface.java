package org.rndclub.swt.dialog;

import org.eclipse.swt.widgets.Shell;


public interface GeneralDialogInterface {
	public abstract void init();

	public abstract void createUI();

	public abstract void doLayout();

	public abstract void addListener();

	public abstract boolean open();

	public abstract void dispose();

	public abstract void setFocus();

	public abstract void setEnabled(boolean flag);

	public abstract void moveCenter();

	public abstract void moveCenter(Shell shell);

	public abstract void moveCenter(int x, int y, int w, int h);

	public void setStatus(final String str);
}
