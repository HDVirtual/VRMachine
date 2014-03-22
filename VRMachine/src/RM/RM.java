package RM;

import registers.Register;
import registers.ModeRegister;
import registers.PTRRegister;
import registers.TimerRegister;
import registers.IntRegister;
import registers.TimerMechRegister;
import registers.BARRegister;

public class RM {
	public static PTRRegister PTR; 			//puslapiavimo reg
	public static Register AR;				//bendras reg
	public static Register BR;				//bendras reg
	public static Register IP;				//komandu skaitliukas
	public static Register Z;				//nulio flag
	public static Register C;				//pernesimo flag
	public static Register S;				//zenklo flag
	public static Register B;				//baito flag
	public static TimerMechRegister TIMER;  //taimerio reg
	public static IntRegister SI;			//supervizoriaus rezimo perjungimo
	public static IntRegister PI;			//programinio pertraukimo
	public static TimerRegister TI;			//taimerio pertraukimo
	public static IntRegister IOI;			//taimerio pertraukimo
	public static ModeRegister MODE;		//darbo rezimo registras
	public static BARRegister BAR;			//bendros atminties uzimtumo reg
	public static Register CHST;			//kanalu busenos reg
	
	public static RealMemory memory;
	public static ExternalMemory externalMemory;
	public static CommonMemory commonMemory;
	public static int inputKiekis;
	 
	public RM() {
        memory = new RealMemory();
        externalMemory = new ExternalMemory();
        PTR = new PTRRegister(0, 9, 1, 0);
		AR = new Register();
		BR = new Register();
        IP = new Register(000);
        Z = new Register();
        C = new Register();
        S = new Register();
        B = new Register();
        TIMER = new TimerMechRegister(10); 
        TI = new TimerRegister(0);
        IOI = new IntRegister();
        PI = new IntRegister();
        SI = new IntRegister();
        MODE  = new ModeRegister();
        BAR = new BARRegister();
        Register[] CHST = new Register[4];
        
        //InterruptPrograms();
        
        externalMemory.save();
	}
	
	private static String getOpk(String zodis) {
		String result = zodis.substring(0, 2);
		return result;
	}
	
	private static int getAdress(String command) {
		String result = command.substring(2, 4);
		int cell = Integer.parseInt(result, 16);
		return cell;
    }
	
	public static void doCommand(String command) {
		String OPK="";
		int xx;
		OPK = getOpk(command);
		xx = getAdress(command);
		
		switch (OPK) 
		{
            case "LA": 
            {
                LA(xx);
                break;
            }
            case "LB": 
            {
                LB(xx);
                break;
            }
            case "WA": 
            {
                WA(xx);
                break;
            }
            case "WB":
            {
            	WB(xx);
            	break;
            }
            case "AA":
            {
            	AA(xx);
            	break;
            }
            case "AB":
            {
            	AB(xx);
            	break;
            }
            case "SA":
            {
            	SA(xx);
            	break;
            }
            case "SB":
            {
            	SB(xx);
            	break;
            }
            case "CA":
            {
            	CA(xx);
            	break;
            }
            case "CB":
            {
            	CB(xx);
            	break;
            }
            case "JM":
            {
            	JM(xx);
            	break;
            }
            case "JG":
            {
            	JG(xx);
            	break;
            }
            case "JL":
            {
            	JL(xx);
            	break;
            }
            case "JC":
            {
            	JC(xx);
            	break;
            }
            case "JZ":
            {
            	JZ(xx);
            	break;
            }
            case "JN":
            {
            	JN(xx);
            	break;
            }
            case "LP":
            {
            	LP(xx);
            	break;
            }
            case "PD":
            {
            	PD(xx);
            	break;
            }
            case "GD":
            {
            	GD(xx);
            	break;
            }
            case "XA":
            {
            	XA(xx);
            	break;
            }
            case "XB":
            {
            	XB(xx);
            	break;
            }
            case "NA":
            {
            	NA(xx);
            	break;
            }
            case "NB":
            {
            	NB(xx);
            	break;
            }
            case "OA":
            {
            	OA(xx);
            	break;
            }
            case "OB":
            {
            	OB(xx);
            	break;
            }
            case "LX":
            {
            	String result = command.substring(2, 4);
            	switch (result) 
        		{
        			case "ON":
        			{
        				LXON();
        				break;
        			}
        			case "OF":
        			{
        				LXOF();
        				break;
        			}
        			case "CH":
        			{
        				LXCH();
        				break;
        			}
        		}
            	break;
            }
            case "ST":
            {
            	String result = command.substring(2, 4);
            	switch (result) 
        		{
        			case "SB":
        			{
        				STSB();
        				break;
        			}
        		}
            	break;
            }
            case "LD":
            {
            	String result = command.substring(2, 4);
            	switch (result) 
        		{
        			case "SB":
        			{
        				LDSB();
        				break;
        			}
        		}
            	break;
            }
            case "HA":
            {
            	String result = command.substring(2, 4);
            	switch (result) 
        		{
        			case "LT":
        			{
        				HALT();
        				break;
        			}
        		}
            	break;
            }
            default: 
            {
                    	//UI.MainWindow.updateConsole("Komanda '"+OPK+"' neegzistuoja!");
                        IP.set(IP.get()+1);
                        PI.set(1); // Neteisingas OPK
                        MODE.set(1);
                        break;
            }
            //MODE.set(0);
            //VM.VM.updateGUI();
		}
	}
	
	/**
	 * Iš atminties adresu XX paimama reikšmę, bei pašalinami tarpai
	 * @param xx Atminties adresas
	 * @return XY Reikšmė adresu XX
	 */
	public static String getWord(int xx) {
		String Word = memory.getWord(xx);
		Word = Word.replaceAll("\\s", "");
		return Word;
	}
	public static String getWordExternal(int xx) {
		String Word = externalMemory.getWord(xx);
		Word = Word.replaceAll("\\s", "");
		return Word;
	}
	/**
	 * Atminties vietai adresu XX nustatoma nauja reikðmë
	 * @param xx Atminties adresas
	 * @param R Nauja reikðmë
	 */
	public static void setWord(int xx, String R) {
		memory.set(xx, R);
	}
	/**
	 * Isorineje atmintyje adresu XX issaugoma R registro reiksme
	 * @param xx Atminties adresas
	 * @param R Registro reikšme
	 */
	public static void setWordExternal(int xx, String R) {
		externalMemory.set(xx, R);
	}
	
	public static void LA(int xx) {
		AR.set(getWord(xx));
		IP.set(IP.get()+1);
	}
	
	public static void LB(int xx) {
		BR.set(getWord(xx));
		IP.set(IP.get()+1);
	}
	
	public static void WA(int xx) {
		setWord(xx, AR.get());
		IP.set(IP.get()+1);
	}
	
	public static void WB(int xx) {
		setWord(xx, BR.get());
		IP.set(IP.get()+1);
	}
	
	public static void AA(int xx) {
		int number = Integer.parseInt(AR.get(), 16) + Integer.parseInt(getWord(xx), 16);
		String hex = Integer.toHexString(number);
		if (hex.length() > 4) {
			C.set("1");
			S.set("0");
			Z.set("0");
			AR.set(hex.substring(1, 5));
		} else if (hex.length() <= 4) {
			C.set("0");
			S.set("0");
			Z.set("0");
			AR.set(hex);
		} else if (hex == "10000") {
			C.set("1");
			S.set("0");
			Z.set("1");
			AR.set("0");
		}
		IP.set(IP.get()+1);
	}
	
	public static void AB(int xx) {
		int number = Integer.parseInt(BR.get(), 16) + Integer.parseInt(getWord(xx), 16);
		String hex = Integer.toHexString(number);
		if (hex.length() > 4) {
			C.set("1");
			S.set("0");
			Z.set("0");
			BR.set(hex.substring(1, 5));
		} else if (hex.length() <= 4) {
			C.set("0");
			S.set("0");
			Z.set("0");
			BR.set(hex);
		} else if (hex == "10000") {
			C.set("1");
			S.set("0");
			Z.set("1");
			BR.set("0");
		}
		IP.set(IP.get()+1);
	}
	
	public static void SA(int xx) {
		int number = Integer.parseInt(AR.get(), 16) - Integer.parseInt(getWord(xx), 16);
		String hex = Integer.toHexString(number);
		if (number < 0) {
			C.set("1");
			S.set("1");
			Z.set("0");
			int n = Integer.parseInt("FFFF", 16) - Integer.parseInt(getWord(xx), 16) + Integer.parseInt(AR.get(), 16) +1;
			AR.set(Integer.toHexString(n));
		} else if (number > 0) {
			C.set("0");
			S.set("0");
			Z.set("0");
			AR.set(hex);
		} else if (hex == "0") {
			C.set("0");
			S.set("0");
			Z.set("1");
			AR.set("0");
		}
		IP.set(IP.get()+1);
	}
	
	public static void SB(int xx) {
		int number = Integer.parseInt(BR.get(), 16) - Integer.parseInt(getWord(xx), 16);
		String hex = Integer.toHexString(number);
		if (number < 0) {
			C.set("1");
			S.set("1");
			Z.set("0");
			int n = Integer.parseInt("FFFF", 16) - Integer.parseInt(getWord(xx), 16) + Integer.parseInt(BR.get(), 16) +1;
			BR.set(Integer.toHexString(n));
		} else if (number > 0) {
			C.set("0");
			S.set("0");
			Z.set("0");
			BR.set(hex);
		} else if (hex == "0") {
			C.set("0");
			S.set("0");
			Z.set("1");
			BR.set("0");
		}
		IP.set(IP.get()+1);
	}
	
	public static void CA(int xx) {
		int number = Integer.parseInt(AR.get(), 16) - Integer.parseInt(getWord(xx), 16);
		if (number == 0) {
			C.set("0");
			S.set("0");
			Z.set("1");
		} else if (number > 0) {
			C.set("0");
			S.set("0");
			Z.set("0");
		} else if (number < 0) {
			C.set("1");
			S.set("1");
			Z.set("0");
		}
		IP.set(IP.get()+1);
	}
	
	public static void CB(int xx) {
		int number = Integer.parseInt(BR.get(), 16) - Integer.parseInt(getWord(xx), 16);
		if (number == 0) {
			C.set("0");
			S.set("0");
			Z.set("1");
		} else if (number > 0) {
			C.set("0");
			S.set("0");
			Z.set("0");
		} else if (number < 0) {
			C.set("1");
			S.set("1");
			Z.set("0");
		}
		IP.set(IP.get()+1);
	}
	
	public static void JM(int xx) {
		IP.set(Integer.toHexString(xx));
	}
	
	public static void JG(int xx) {
		if ((C.get() == "0") && (S.get() == "0") && (Z.get() == "0")) {
			IP.set(Integer.toHexString(xx));
		} else { 
			IP.set(IP.get()+1); 
			}
	}
	
	public static void JL(int xx) {
		if ((C.get() == "1") && (S.get() == "1") && (Z.get() == "0")) {
			IP.set(Integer.toHexString(xx));
		} else { 
			IP.set(IP.get()+1); 
			}
	}
	
	public static void JC(int xx) {
		if (C.get() == "1") {
			IP.set(Integer.toHexString(xx));
		} else { 
			IP.set(IP.get()+1); 
			}
	}
	
	public static void JZ(int xx) {
		if (Z.get() == "1") {
			IP.set(Integer.toHexString(xx));
		} else { 
			IP.set(IP.get()+1); 
			}
	}
	
	public static void JN(int xx) {
		if (Z.get() == "0") {
			IP.set(Integer.toHexString(xx));
		} else { 
			IP.set(IP.get()+1); 
			}
	}
	
	public static void LP(int xx) {
		if (Integer.parseInt(BR.get(), 16) > 0) {
			IP.set(Integer.toHexString(xx));
		} else { 
			IP.set(IP.get()+1); 
			}
	}
	
	public static void HALT() {
		MODE.set(1);
		SI.set(3);
	}
	
	static public void PD(int xx) {
		String text="";
		for(int i=xx; i<xx+16; i++) {
			text = text + memory.getWord(i);
		}
		IP.set(IP.get()+1);
		MODE.set(0);
		kontroleris.MainWindow.updateConsole(text);
	}
	
	public static void GD(int xx) {
		
		IP.set(IP.get()+1);
	}
	
	public static void LXON() {
		
		IP.set(IP.get()+1);
	}
	
	public static void LXOF() {
		
		IP.set(IP.get()+1);
	}
	
	public static void LXCH() {
		
		IP.set(IP.get()+1);
	}
	
	public static void XA(int xx) {
		
		IP.set(IP.get()+1);
	}
	
	public static void XB(int xx) {
		
		IP.set(IP.get()+1);
	}
	
	public static void NA(int xx) {
		
		IP.set(IP.get()+1);
	}
	
	public static void NB(int xx) {
		
		IP.set(IP.get()+1);
	}
	
	public static void OA(int xx) {
		
		IP.set(IP.get()+1);
	}
	
	public static void OB(int xx) {
		
		IP.set(IP.get()+1);
	}
	
	public static void STSB() {
		
		IP.set(IP.get()+1);
	}

	public static void LDSB() {
	
	IP.set(IP.get()+1);
}
	
}