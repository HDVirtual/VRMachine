package registers;

public class ARegister {
	private int AR;
	
	public ARegister() {
		this.AR = 0;
	}

	public int get() {
		return this.AR;
	}

	public void set(int AR) {
		this.AR = AR;
	}
}
