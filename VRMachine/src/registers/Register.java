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
}
