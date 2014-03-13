package kontroleris;

import java.awt.EventQueue;

public class Main{

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
				
				frame.changeField("TEST");
			}
		});
	}
}
