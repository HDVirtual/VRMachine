package registers;
/*
 * @author Haroldas Baltr�nas
 * @author Deividas Frolovas
 */
public class BARRegister {

	private String BAR;

	public BARRegister(String x) {
		this.BAR = x.toUpperCase();
	}

	public String get() {
		return BAR;
	}
	
}
