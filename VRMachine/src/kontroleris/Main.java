package kontroleris;

/*
 * @author Haroldas Baltrûnas
 * @author Deividas Frolovas
 */

import java.awt.EventQueue;

import RM.RM;

public class Main {
	/**
	 * Launch the application.
	 */

	public static final int blokoDydis = 16;
	public static final int EMBlokuSkaicius = 16;
	public static final int RMBlokuSkaicius = 256;
	public static final int VMBlokuSkaicius = 16;


	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					final RM os = new RM();
					MainWindow frame = new MainWindow(os);
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void update(){};
}
