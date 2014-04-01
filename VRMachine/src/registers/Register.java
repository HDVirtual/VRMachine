package registers;
/*
 * @author Haroldas Baltrûnas
 * @author Deividas Frolovas
 */
public class Register {
	private String reg;

	public Register() {
		this.reg = "0";
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

	public void increase() {
		int register = Integer.parseInt(this.reg, 16);
		register += 1;
		String hex = Integer.toHexString(register);
		this.reg = hex;
	}
}
