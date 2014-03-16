package kontroleris;

import java.awt.EventQueue;

import registers.ARegister;

public class Main{

	public static ARegister AR;
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
				// AR = new ARegister();
				// AR.set(30);
				frame.set("RM_AR",4848);
				frame.set("RM_S",1);
				frame.set("TIMER",3);
				System.out.println(frame.get("RM_S"));
				System.out.println(frame.get("RM_AR"));
				System.out.println(frame.get("TIMER"));
				////////////////////
			}
		});
	}
}
