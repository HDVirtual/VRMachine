package RM;
/*
 * @author Haroldas Baltrūnas
 * @author Deividas Frolovas
 */
import kontroleris.Main;
import kontroleris.MainWindow;
import registers.CHST;
import registers.Register;
import registers.ModeRegister;
import registers.PTRRegister;
import registers.TimerRegister;
import registers.IntRegister;
import registers.TimerMechRegister;
import registers.BARRegister;

public class RM {
	public static PTRRegister PTR; // puslapiavimo reg
	public static Register AR; // bendras reg
	public static Register BR; // bendras reg
	public static Register IP; // komandu skaitliukas
	public static Register Z; // nulio flag
	public static Register C; // pernesimo flag
	public static Register S; // zenklo flag
	public static Register B; // baito flag
	public static TimerMechRegister TIMER; // taimerio reg
	public static IntRegister SI; // supervizoriaus rezimo perjungimo
	public static IntRegister PI; // programinio pertraukimo
	public static TimerRegister TI; // taimerio pertraukimo
	public static IntRegister IOI; // taimerio pertraukimo
	public static ModeRegister MODE; // darbo rezimo registras. mode=1 - dirba reali masina; mode=0 - virtuali.
	public static BARRegister BAR; // bendros atminties uzimtumo reg
	public static CHST CHST; // kanalu busenos reg
	public static Lempute lempute;
	public static VA Atmintis;
	public static RealMemory memory;
	public static ExternalMemory externalMemory;
	public static CommonMemory commonMemory;
	
	public static int inputKiekis;

	public static PageTable PageTable;
	
	public RM() {
		memory = new RealMemory(Main.RMBlokuSkaicius);
		externalMemory = new ExternalMemory(Main.EMBlokuSkaicius);
		Atmintis = new VA(Main.VMBlokuSkaicius);
		
		PTR = new PTRRegister("0F00");
		PageTable = new PageTable();
		PTR.setPageTable(PageTable.getAdress());
		AR = new Register(0000);
		BR = new Register(0000);
		IP = new Register(00);
		Z = new Register(0);
		C = new Register(0);
		S = new Register(0);
		B = new Register(0);
		TIMER = new TimerMechRegister(10);
		TI = new TimerRegister(0);
		IOI = new IntRegister();
		PI = new IntRegister();
		SI = new IntRegister();
		MODE = new ModeRegister(1);
		BAR = new BARRegister();
		CHST = new CHST();
		lempute = new Lempute();

		externalMemory.save();
	}

	private static String getOpk(String zodis) {
		try {
			String result = zodis.substring(0, 2); 
			return result;
		} catch (StringIndexOutOfBoundsException e) {
			PI.set(2);
            return "";
		}
	}

	private static int getAdress(String command) {
		try {
			if (command.length() == 4) {
				String result = command.substring(2, 4);
				int cell = Integer.parseInt(result, 16);
				return cell;
			} else {
				if (!command.equals("HALT") && !command.equals("LXON") && !command.equals("LXOF") && !command.equals("LXCH") && !command.equals("STSB") && !command.equals("LDSB")) {
					PI.set(1);
				}
	            return 0;
			}
		} catch (Exception e) {
			if (!command.equals("HALT") && !command.equals("LXON") && !command.equals("LXCH") && !command.equals("LXOF") && !command.equals("STSB") && !command.equals("LDSB")) {
				PI.set(1);
			}
            return 0;
		}
	}

	public static void doCommand(String command) {
		String OPK = "";
		int xx;
		OPK = getOpk(command);
		xx = getAdress(command);

		switch (OPK) {
		case "LA": {
			LA(xx);
			break;
		}
		case "LB": {
			LB(xx);
			break;
		}
		case "WA": {
			WA(xx);
			break;
		}
		case "WB": {
			WB(xx);
			break;
		}
		case "AA": {
			AA(xx);
			break;
		}
		case "AB": {
			AB(xx);
			break;
		}
		case "SA": {
			SA(xx);
			break;
		}
		case "SB": {
			SB(xx);
			break;
		}
		case "CA": {
			CA(xx);
			break;
		}
		case "CB": {
			CB(xx);
			break;
		}
		case "JM": {
			JM(xx);
			break;
		}
		case "JG": {
			JG(xx);
			break;
		}
		case "JL": {
			JL(xx);
			break;
		}
		case "JC": {
			JC(xx);
			break;
		}
		case "JZ": {
			JZ(xx);
			break;
		}
		case "JN": {
			JN(xx);
			break;
		}
		case "LP": {
			LP(xx);
			break;
		}
		case "PD": {
			PD(xx);
			break;
		}
		case "GD": {
			GD(xx);
			break;
		}
		case "XA": {
			XA(xx);
			break;
		}
		case "XB": {
			XB(xx);
			break;
		}
		case "NA": {
			NA(xx);
			break;
		}
		case "NB": {
			NB(xx);
			break;
		}
		case "OA": {
			OA(xx);
			break;
		}
		case "OB": {
			OB(xx);
			break;
		}
		case "LX": {
			String result = command.substring(2, 4);
			switch (result) {
			case "ON": {
				LXON();
				break;
			}
			case "OF": {
				LXOF();
				break;
			}
			case "CH": {
				LXCH();
				break;
			}
			}
			break;
		}
		case "ST": {
			String result = command.substring(2, 4);
			switch (result) {
			case "SB": {
				STSB();
				break;
			}
			}
			break;
		}
		case "LD": {
			String result = command.substring(2, 4);
			switch (result) {
			case "SB": {
				LDSB();
				break;
			}
			}
			break;
		}
		case "HA": {
			String result = command.substring(2, 4);
			switch (result) {
			case "LT": {
				HALT();
				break;
			}
			}
			break;
		}
		default: {
			IP.increase();
			PI.set(2);
			MODE.set(1);
			break;
		}
		}
	}

	/**
	 * I�? atminties adresu XX paimama reik�?mę, bei pa�?alinami tarpai
	 * 
	 * @param xx
	 *            Atminties adresas
	 * @return XY Reik�?mė adresu XX
	 */
	public static String getWord(int xx) {
		String Word = Atmintis.get(xx);
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
	 * 
	 * @param xx
	 *            Atminties adresas
	 * @param R
	 *            Nauja reikðmë
	 */
	public static void setWord(int xx, String R) {
		Atmintis.set(xx, R);
		updateGUI();
	}
	
	public static void setHighWord(int xx, String R) {
		String L = R + getWord(xx).substring(2, 4);
		memory.set(xx, L);
		updateGUI();
	}
	
	public static void setLowWord(int xx, String R) {
		String L = getWord(xx).substring(0, 2) + R;
		memory.set(xx, L);
		updateGUI();
	}

	/**
	 * Isorineje atmintyje adresu XX issaugoma R registro reiksme
	 * 
	 * @param xx
	 *            Atminties adresas
	 * @param R
	 *            Registro reik�?me
	 */
	public static void setWordExternal(int xx, String R) {
		externalMemory.set(xx, R);
		updateGUI();
	}

	public static void LA(int xx) {
		AR.set(getWord(xx));
		IP.increase();
		updateGUI();
	}

	public static void LB(int xx) {
		BR.set(getWord(xx));
		IP.increase();
		updateGUI();
	}

	public static void WA(int xx) {
		setWord(xx, AR.get());
		IP.increase();
		updateGUI();
	}

	public static void WB(int xx) {
		setWord(xx, BR.get());
		IP.increase();
		updateGUI();
	}

	public static void AA(int xx) {
		int number = Integer.parseInt(AR.get(), 16)
				+ Integer.parseInt(getWord(xx), 16);
		String hex = Integer.toHexString(number);
		if (hex.length() > 4) {
			C.set("1");
			S.set("0");
			Z.set("0");
			AR.set(hex.substring(1, 5));
		}
		else if (hex.length() <= 4) {
			C.set("0");
			S.set("0");
			Z.set("0");
			AR.set(hex);
		}
		else if (hex == "10000") {
			C.set("1");
			S.set("0");
			Z.set("1");
			AR.set("0");
		}
		IP.increase();
		updateGUI();
	}

	public static void AB(int xx) {
		int number = Integer.parseInt(BR.get(), 16)
				+ Integer.parseInt(getWord(xx), 16);
		String hex = Integer.toHexString(number);
		if (hex.length() > 4) {
			C.set("1");
			S.set("0");
			Z.set("0");
			BR.set(hex.substring(1, 5));
		}
		else if (hex.length() <= 4) {
			C.set("0");
			S.set("0");
			Z.set("0");
			BR.set(hex);
		}
		else if (hex == "10000") {
			C.set("1");
			S.set("0");
			Z.set("1");
			BR.set("0");
		}
		IP.increase();
		updateGUI();
	}

	public static void SA(int xx) {
		int number = Integer.parseInt(AR.get(), 16)
				- Integer.parseInt(getWord(xx), 16);
		String hex = Integer.toHexString(number);
		if (number < 0) {
			C.set("1");
			S.set("1");
			Z.set("0");
			int n = Integer.parseInt("FFFF", 16)
					- Integer.parseInt(getWord(xx), 16)
					+ Integer.parseInt(AR.get(), 16) + 1;
			AR.set(Integer.toHexString(n));
		}
		else if (number > 0) {
			C.set("0");
			S.set("0");
			Z.set("0");
			AR.set(hex);
		}
		else if (hex == "0") {
			C.set("0");
			S.set("0");
			Z.set("1");
			AR.set("0");
		}
		IP.increase();
		updateGUI();
	}

	public static void SB(int xx) {
		int number = Integer.parseInt(BR.get(), 16)
				- Integer.parseInt(getWord(xx), 16);
		String hex = Integer.toHexString(number);
		if (number < 0) {
			C.set("1");
			S.set("1");
			Z.set("0");
			int n = Integer.parseInt("FFFF", 16)
					- Integer.parseInt(getWord(xx), 16)
					+ Integer.parseInt(BR.get(), 16) + 1;
			BR.set(Integer.toHexString(n));
		}
		else if (number > 0) {
			C.set("0");
			S.set("0");
			Z.set("0");
			BR.set(hex);
		}
		else if (hex == "0") {
			C.set("0");
			S.set("0");
			Z.set("1");
			BR.set("0");
		}
		IP.increase();
		updateGUI();
	}

	public static void CA(int xx) {
		int number = Integer.parseInt(AR.get(), 16)
				- Integer.parseInt(getWord(xx), 16);
		if (number == 0) {
			C.set("0");
			S.set("0");
			Z.set("1");
		}
		else if (number > 0) {
			C.set("0");
			S.set("0");
			Z.set("0");
		}
		else if (number < 0) {
			C.set("1");
			S.set("1");
			Z.set("0");
		}
		IP.increase();
		updateGUI();
	}

	public static void CB(int xx) {
		int number = Integer.parseInt(BR.get(), 16)
				- Integer.parseInt(getWord(xx), 16);
		if (number == 0) {
			C.set("0");
			S.set("0");
			Z.set("1");
		}
		else if (number > 0) {
			C.set("0");
			S.set("0");
			Z.set("0");
		}
		else if (number < 0) {
			C.set("1");
			S.set("1");
			Z.set("0");
		}
		IP.increase();
		updateGUI();
	}

	public static void JM(int xx) {
		IP.set(Integer.toHexString(xx));
		updateGUI();
	}

	public static void JG(int xx) {
		if ((C.get() == "0") && (S.get() == "0") && (Z.get() == "0")) {
			IP.set(Integer.toHexString(xx));
		}
		else {
			IP.increase();
		}
		updateGUI();
	}

	public static void JL(int xx) {
		if ((C.get() == "1") && (S.get() == "1") && (Z.get() == "0")) {
			IP.set(Integer.toHexString(xx));
		}
		else {
			IP.increase();
		}
		updateGUI();
	}

	public static void JC(int xx) {
		if (C.get() == "1") {
			IP.set(Integer.toHexString(xx));
		}
		else {
			IP.increase();
		}
		updateGUI();
	}

	public static void JZ(int xx) {
		if (Z.get() == "1") {
			IP.set(Integer.toHexString(xx));
		}
		else {
			IP.increase();
		}
		updateGUI();
	}

	public static void JN(int xx) {
		if (Z.get() == "0") {
			IP.set(Integer.toHexString(xx));
		}
		else {
			IP.increase();
		}
		updateGUI();
	}

	public static void LP(int xx) {
		if (Integer.parseInt(BR.get(), 16) > 0) {
			IP.set(Integer.toHexString(xx));
		}
		else {
			IP.increase();
		}
		updateGUI();
	}

	public static void HALT() {
		MODE.set(1);
		SI.set(3);
		IP.increase();
		updateGUI();
	}

	static public void PD(int xx) {
		MODE.set(1);
		SI.set(2);
		CHST.set(1, 1);
		String text = "";
		for (int i = xx; i < xx + 16; i++) {
			text = text + getWord(i);
		}
		text = text.replaceAll("_", "");
		text = text.replaceAll("-", " ");
		kontroleris.MainWindow.updateConsole("Isvedimas: " + text);
		IP.increase();
		updateGUI();
	}

	public static void GD(int xx) {
		MODE.set(1);
		SI.set(1);
		CHST.set(1, 0);
		kontroleris.MainWindow.updateConsole("Jusu tekstas buvo nuskaitytas!");
		String buffer = MainWindow.readConsole();
		String adress = Integer.toHexString(xx);
		String block = adress.substring(0, 1);
		int blokas = Integer.parseInt(block, 16);
		int pointer = 0;
		for (int i = 0; i < Main.blokoDydis; i++) {
			try {
				setWord(blokas*16+i, buffer.substring(pointer, pointer+4));
				pointer += 4;
			} catch (Exception e) {
				setWord(blokas*16+i, "____");
				pointer += 4;
			}
		}
		IP.increase();
		updateGUI();
	}

	public static void LXON() {
		MODE.set(1);
		SI.set(4);
		CHST.set(1, 3);
		IP.increase();
		updateGUI();
	}

	public static void LXOF() {
		MODE.set(1);
		SI.set(5);
		CHST.set(0, 3);
		IP.increase();
		updateGUI();
	}

	public static void LXCH() {
		if (CHST.get(3) == 1)
			Z.set("1");
		else
			Z.set("0");
		IP.increase();
		updateGUI();
	}

	public static void XA(int xx) {
		int register = Integer.parseInt(AR.get(), 16);
		int memory = Integer.parseInt(getWord(xx), 16);
		int xor = register ^ memory;
		AR.set(Integer.toHexString(xor));
		IP.increase();
		updateGUI();
	}

	public static void XB(int xx) {
		int register = Integer.parseInt(BR.get(), 16);
		int memory = Integer.parseInt(getWord(xx), 16);
		int xor = register ^ memory;
		BR.set(Integer.toHexString(xor));
		IP.increase();
		updateGUI();
	}

	public static void NA(int xx) {
		int register = Integer.parseInt(AR.get(), 16);
		int memory = Integer.parseInt(getWord(xx), 16);
		int and = register & memory;
		AR.set(Integer.toHexString(and));
		IP.increase();
		updateGUI();
	}

	public static void NB(int xx) {
		int register = Integer.parseInt(BR.get(), 16);
		int memory = Integer.parseInt(getWord(xx), 16);
		int and = register & memory;
		BR.set(Integer.toHexString(and));
		IP.increase();
		updateGUI();
	}

	public static void OA(int xx) {
		int register = Integer.parseInt(AR.get(), 16);
		int memory = Integer.parseInt(getWord(xx), 16);
		int or = register | memory;
		AR.set(Integer.toHexString(or));
		IP.increase();
		updateGUI();
	}

	public static void OB(int xx) {
		int register = Integer.parseInt(BR.get(), 16);
		int memory = Integer.parseInt(getWord(xx), 16);
		int or = register | memory;
		BR.set(Integer.toHexString(or));
		IP.increase();
		updateGUI();
	}

	public static void STSB() {
		String AH = AR.get().substring(0, 2);
		String AL = AR.get().substring(2, 4);
		int adress = getAdress(AH);
		if (B.get() == "0") {
			setHighWord(adress, AL);
			B.set("1");
		} else if (B.get() == "1") {
			setLowWord(adress, AL);
			B.set("0");
			AR.setHigh(Integer.toHexString(adress+1));
		}
		IP.increase();
		updateGUI();
	}

	public static void LDSB() {
		String AH = AR.get().substring(0, 2);
		int adress = getAdress(AH);
		String memory = getWord(adress);
		if (B.get() == "0") {
			AR.setLow(memory.substring(0, 2));
			B.set("1");
		} else if (B.get() == "1") {
			AR.setLow(memory.substring(2, 4));
			B.set("0");
			AR.setHigh(Integer.toHexString(adress+1));
		}
		IP.increase();
		updateGUI();
	}

	public static void Interrupt() {
		if (PI.get() != 0) {
			switch (PI.get()) {
			case 1: {
				MainWindow.updateConsole("Bandoma naudoti neteisingą adresą");
				break;
			}
			case 2: {
				MainWindow.updateConsole("Neteisingas operacijos kodas");
				break;
			}
			case 3: {
				MainWindow.updateConsole("Neteisingas priskyrimas.");
				break;
			}
			case 4: {
				MainWindow.updateConsole("Perpildymas.");
				break;
			}
			default: {
				System.out.println("Pertraukimas PI neįvyko.");
				break;
			}
			}
		}
		if (SI.get() != 0) {
			switch (SI.get()) {
			case 1: {
				MainWindow.updateConsole("Pertraukimą iššaukė komanda GD.");
				break;
			}
			case 2: {
				MainWindow.updateConsole("Pertraukimą iššaukė komanda PD.");
				break;
			}
			case 3: {
				MainWindow.updateConsole("Pertraukimą iššaukė komanda HALT.");
				break;
			}
			case 4: {
				MainWindow.updateConsole("Pertraukimą iššaukė komanda LBON.");
				break;
			}
			case 5: {
				MainWindow.updateConsole("Pertraukimą iššaukė komanda LBOF.");
				break;
			}
			default: {
				MainWindow.updateConsole("Pertraukimas SI neįvyko.");
				break;
			}
			}
		}
		if (TI.get() != 0) {
			switch (TI.get()) {
			case 1: {
				MainWindow.updateConsole("Taimerio pertraukimas.");
				break;
			}
			default: {
				MainWindow.updateConsole("Pertraukimas T neįvyko.");
			}
			}
		}
	}
	
	public static void startProgram() {
		do {
			step();
		} while(SI.get() != 3);
		step();
	}
	/**
	 * Vykdomos komandos po þingsn�?
	 */
	public static void startProgramStepByStep() {
			step();
	}
	/**
	 * Komandos vykdymo þingsnis
	 */
	private static void step() {
		updateReg();
		TIMER.set();
		if (TIMER.get() == 0) {
			TI.set(1);
			TIMER.update();
		}
		if(SI.get() != 3) {
			updateGUI();
			String command = Atmintis.get(Integer.parseInt(IP.get(), 16));
			doCommand(command);
			test();
		} else {
			updateGUI();
			MainWindow.updateConsole(">>> Programa baigė darbą!");
			MODE.set(1);
		}
	}
	
	public static void updateReg() {
		MODE.set(0);
		if(SI.get() != 3) { SI.set(0); }
		if (CHST.get(3) != 1) {
			CHST.cleanCHST();
		}
		PI.set(0);
		TI.set(0);
	}
	
	public static boolean test() {
		if (SI.get() + PI.get() + TI.get() != 0) {
			MODE.set(1);
			Interrupt();
			updateGUI();
			return true;
		} else {
			return false;
		}
	}
	
	public static void updateGUI() {
		MainWindow.set("IP",IP.get());
		MainWindow.set("AR",AR.get());
		MainWindow.set("BR",BR.get());
		MainWindow.set("Z",Z.get());
		MainWindow.set("C",C.get());
		MainWindow.set("S",S.get());
		MainWindow.set("B",B.get());
		MainWindow.set("PTR",PTR.get());
		MainWindow.set("TIMER",Integer.toString(TIMER.get()));
		MainWindow.set("SI",Integer.toString(SI.get()));
		MainWindow.set("PI",Integer.toString(PI.get()));
		MainWindow.set("TI",Integer.toString(TI.get()));
		MainWindow.set("MODE",Integer.toString(MODE.get()));
		MainWindow.set("INPUT",Integer.toString(CHST.get(0)));
		MainWindow.set("OUTPUT",Integer.toString(CHST.get(1)));
		MainWindow.set("EMEMORY",Integer.toString(CHST.get(2)));
		MainWindow.set("LEMPUTE",Integer.toString(CHST.get(3)));
		MainWindow.updateListVA(Atmintis);
		MainWindow.updateListRM(RM.memory);
		MainWindow.updateListEM(RM.externalMemory);
		MainWindow.set("cmd",Atmintis.get(Integer.parseInt(IP.get(), 16)));
		if (CHST.get(3) == 1) {
			MainWindow.setLempute(true);
		} else { MainWindow.setLempute(false); }
	}
}