package registers;
/*
 * @author Haroldas Baltrûnas
 * @author Deividas Frolovas
 */
public class IP {
	private String reg;

	public IP() {
		this.reg = "0";
	}

	public IP(int x) {
		this.reg = Integer.toString(x).toUpperCase();
	}

	public IP(String x) {
		this.reg = x.toUpperCase();
	}

	public String get() {
		return this.reg;
	}

	public String getNext() {
		if (this.reg == "0")
			return "0";
		else 
			return this.reg;
	}

	public void set(int value) {
		this.reg = Integer.toString(value).toUpperCase();
	}

	public void set(String value) {
		this.reg = value.toUpperCase();
	}
	
	public void increase() {
		int register = Integer.parseInt(this.reg, 16);
		register += 1;
		String hex = Integer.toHexString(register);
		this.reg = hex.toUpperCase();
	}
}
