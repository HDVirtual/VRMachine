package kontroleris;

import java.awt.EventQueue;
import registers.Register;

public class Main{

	////// test//////////////
	public static Register AR;
	public static Register S;
	/////////////////////////
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MainWindow frame = new MainWindow();
				try {
					
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				// test ////////////
				AR = new Register();
				AR.set("FFFF");
				S = new Register();
				S.set("1");
				frame.set("RM_AR",AR.get());
				frame.set("RM_S",S.get());
				System.out.println(frame.get("RM_S"));
				System.out.println(frame.get("RM_AR"));
				////////////////////
			}
		});
	}
}
