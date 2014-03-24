package registers;

public class Register {
	private String reg;
	
	public Register() {
		this.reg = "";
	}
	
	public Register(int x) {
		this.reg = String.valueOf(x);
	}
	
	public Register(String x) {
		this.reg = x;
	}

	public String get() {
		return this.reg;
	}

	public void set(String value) {
		this.reg = value;
	}
	
	public void setHigh(String value) {
		String L = value + this.reg.substring(2, 4);
		this.reg = L;
	}
	
	public void setLow(String value) {
		String L = this.reg.substring(0, 2) + value;
		this.reg = L;
	}
}
