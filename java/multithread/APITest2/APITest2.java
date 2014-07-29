package p1;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings ("serial")
public class APITest2 extends JFrame implements Runnable, ActionListener {
		Thread thrd = null;
		int num = 0;
		JButton btn = new JButton ("Suspend/Resume");
		JLabel label = new JLabel ("7", JLabel.CENTER);
		boolean isRun = true;
		Font fontbig = new Font ("Serf", Font.PLAIN, 64);
		Font fontsmall = new Font ("Serf", Font.PLAIN, 25);

		public APITest2 () {
				label.setFont (fontbig);
				btn.setFont (fontsmall);
				add (label, "Center");
				add (btn, "South");
				btn.addActionListener (this);

				setSize (350, 300);
				setLocation (400, 300);
				setDefaultCloseOperation (EXIT_ON_CLOSE);
				setVisible (true);
		}

		public static void main (String[] argv) {
				APITest2 api = new APITest2 ();
				api.thrd = new Thread (api);
				api.thrd.start ();
		}

		public void run () {
				while (true) {
						num += 1;
						label.setText (""+num);
						try {
								Thread.sleep (400);
						}
						catch (InterruptedException e) {
						}
				}
		}

		public void actionPerformed (ActionEvent e) {
				if (isRun) {
						thrd.suspend (); isRun = false;
				}
				else {
						thrd.resume (); isRun = true;
				}
		}
}
