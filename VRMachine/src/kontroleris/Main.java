package kontroleris;

import java.awt.EventQueue;

///// test /////////////////
import RM.ExternalMemory;
import RM.RM;
import RM.RealMemory;
import registers.Register;

////////////////////////////

public class Main {

	// //// test//////////////
	public static Register AR;
	public static Register S;
	public static RealMemory Rmemory;
	public static ExternalMemory Ememory;
	// ///////////////////////
	/**
	 * Launch the application.
	 */

	public static int blokoDydis = 16;
	public static int EMBlokuSkaicius = 16;
	public static int RMBlokuSkaicius = 256;

	// -----ATMINTIES-LENTELES-STRUKTURA----
	public static Object[] EMcolumnNames;
	public static Object[][] EMdata;
	public static Object[] RMcolumnNames;
	public static Object[][] RMdata;
	// -------------------------------------

	public static void main(String[] args) {
		// ---ISORINE-ATMINTIS---
		EMcolumnNames = new Object[blokoDydis + 1];
		EMcolumnNames[0] = "Blokas";
		for (int i = 0; i < blokoDydis; i++) {
			EMcolumnNames[i + 1] = String.format("%01X", i);
		}
		EMdata = new Object[EMBlokuSkaicius][blokoDydis];
		for (int i = 0; i < EMBlokuSkaicius; i++) {
			EMdata[i][0] = String.format("%01X", i) + ":";
			for (int j = 1; j < blokoDydis; j++) {
				EMdata[i][j] = "____";
			}
		}
		//------
		
		// ---REALI-ATMINTIS---
		RMcolumnNames = new Object[blokoDydis + 1];
		RMcolumnNames[0] = "Blokas";
		for (int i = 0; i < blokoDydis; i++) {
			RMcolumnNames[i + 1] = String.format("%01X", i);
		}
		RMdata = new Object[RMBlokuSkaicius][blokoDydis];
		for (int i = 0; i < RMBlokuSkaicius; i++) {
			RMdata[i][0] = String.format("%01X", i) + ":";
			for (int j = 1; j < blokoDydis; j++) {
				RMdata[i][j] = "____";
			}
		}
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					final RM os = new RM(Rmemory);
					MainWindow frame = new MainWindow(os);
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
				Rmemory = new RealMemory();
				Ememory = new ExternalMemory();
				Ememory.set("0003", "AA12");
				// System.out.println(Ememory.getWord("CC18"));
				Ememory.save();
				// //////////////////
			}
		});
	}
}
