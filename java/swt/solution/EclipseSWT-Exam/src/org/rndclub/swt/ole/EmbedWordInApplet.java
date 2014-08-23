package org.rndclub.swt.ole;

/*
 * example snippet: Embed Word in an applet
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.0
 */

import java.applet.Applet;

public class EmbedWordInApplet extends Applet {
	private static final long serialVersionUID = 1L;

	org.eclipse.swt.widgets.Display display;

	org.eclipse.swt.widgets.Shell swtParent;

	java.awt.Canvas awtParent;

	public void init() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				setLayout(new java.awt.GridLayout(1, 1));
				awtParent = new java.awt.Canvas();
				add(awtParent);
				display = new org.eclipse.swt.widgets.Display();
				swtParent = org.eclipse.swt.awt.SWT_AWT.new_Shell(display,
						awtParent);
				swtParent.setLayout(new org.eclipse.swt.layout.FillLayout());
				org.eclipse.swt.ole.win32.OleFrame frame = new org.eclipse.swt.ole.win32.OleFrame(
						swtParent, org.eclipse.swt.SWT.NONE);
				org.eclipse.swt.ole.win32.OleClientSite site;
				try {
					site = new org.eclipse.swt.ole.win32.OleClientSite(frame,
							org.eclipse.swt.SWT.NONE, "Word.Document");
				} catch (org.eclipse.swt.SWTException e) {
					String str = "Create OleClientSite Error" + e.toString();
					System.out.println(str);
					return;
				}
				setSize(500, 500);
				validate();
				site.doVerb(org.eclipse.swt.ole.win32.OLE.OLEIVERB_SHOW);

				while (swtParent != null && !swtParent.isDisposed()) {
					if (!display.readAndDispatch())
						display.sleep();
				}
			}
		});
		thread.start();
	}

	public void stop() {
		if (display != null && !display.isDisposed()) {
			display.syncExec(new Runnable() {
				public void run() {
					if (swtParent != null && !swtParent.isDisposed())
						swtParent.dispose();
					swtParent = null;
					display.dispose();
					display = null;
				}
			});
			remove(awtParent);
			awtParent = null;
		}
	}
}