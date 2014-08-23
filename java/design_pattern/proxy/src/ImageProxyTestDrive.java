package headfirst.proxy.virtualproxy;

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ImageProxyTestDrive {
	ImageComponent imageComponent;
	JFrame frame = new JFrame ("CD Cover Viewer");
	JMenu menu;
	JMenuBar menubar;
	Hashtable cds = new Hashtable ();

	public static void main (String[] args) throws Exception {
		ImageProxyTestDrive testDrive = new ImageProxyTestDrive ();
	}

	public ImageProxyTestDrive () throws Exception {
		cds.put ("Ambient: Music for Airports", "http://images.amazon.com/images/P/B000003S2K.01.LZZZZZZZ.jgp");
		cds.put ("Buddha Bar", "http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");

		URL initialURL = new URL ((String) cds.get ("Ambient: Music for Airports"));
		menubar = new JMenuBar ();
		menu = new JMenu ("Favorite CDs");
		menubar.add (menu);
		frame.setJMenuBar (menubar);

		for (Enumeration e = cds.keys (); e.hasMoreElements (); ) {
			String name = (String) e.nextElement ();
			JMenuItem menuitem = new JMenuItem (name);
			menu.add (menuitem);
			menuitem.addActionListener (new ActionListener () {
				public void actionPerformed (ActionEvent event) {
					imageComponent.setIcon (new ImageProxy (getCDUrl (event.getActionCommand ())));
					frame.repaint ();
				}
			});
		}

		Icon icon = new ImageProxy (initialURL);
		imageComponent = new ImageComponent (icon);
		frame.getContentPane ().add (imageComponent);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setSize (800, 600);
		frame.setVisible (true);
	}

	URL getCDUrl (String name) {
		try {
			return new URL ((String) cds.get (name));
		} catch (MalformedURLException e) {
			e.printStackTrace ();
			return null;
		}
	}
}
