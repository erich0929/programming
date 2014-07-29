import javax.swing.*;

public class JEditorPaneEx {
	public static void main (String [] argv) {
		JFrame mainFrame = new JFrame ();
		JEditorPane pane = new JEditorPane ();

		pane.setContentType ( "text/html" );
		pane.setEditable ( false );
		pane.setText (
				"<html>" + 
				"<head>" +
				"</head>" + 
				"<body>" +
					"<center><b>Hello</b> <i>World</i></center>" +
				"</body>" + 
				"</html>"
				);

		mainFrame.setContentPane (pane);
		mainFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		mainFrame.pack ();
		mainFrame.show ();
	}
}
