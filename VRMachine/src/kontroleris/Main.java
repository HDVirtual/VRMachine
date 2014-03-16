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
				AR = new ARegister();
				AR.set(16);
				frame.setText_reg_RM_AR(String.format("%02X", AR.get()));
			}
		});
	}
}
