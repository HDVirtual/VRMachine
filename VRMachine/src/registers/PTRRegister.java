package registers;

public class PTRRegister {

	private String PTR;

	public PTRRegister(String x) {
		this.PTR = x;
	}

	public String get() {
		return PTR;
	}

	public int getPageTable() {
		String block = PTR.substring(2, 4);
		return Integer.parseInt(block, 16);
	}

	public void setProgramSize(int N) {
		String Hex = Integer.toHexString(N);
		String L = Hex + PTR.substring(1, 4);
		this.PTR = L;
	}

	public void setPageTable(int adress) {
		String Hex = Integer.toHexString(adress);
		String L = PTR.substring(0, 2) + Hex;
		this.PTR = L;
	}
}
