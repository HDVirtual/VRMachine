package registers;

public class Register {
	private String reg;
	
	public Register() {
		this.reg = "";
	}

	public String get() {
		return this.reg;
	}

	public void set(String value) {
		this.reg = value;
	}
}
