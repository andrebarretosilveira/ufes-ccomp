package Prog3_Trab1;

public class ConsoleInput {
	private String[] args;
	private int flag;
	public static final int NORMAL = 0;
	public static final int READ_ONLY = 1;
	public static final int WRITE_ONLY = 2;
	
	public ConsoleInput(String[] args) {
		this.args = args;
		setFlagOption();
	}
	
	private void setFlagOption() {
		int i = 0;
		while(i < args.length) {
			if(args[i].equals("--read-only")) {
				this.setFlag(READ_ONLY);
				return;
			}
			else if(args[i].equals("--write-only")) {
				this.setFlag(WRITE_ONLY);
				return;
			}
			i++;
		}
		this.setFlag(NORMAL);
	}
	
	public String getFilePath(String parameter) {
		int i = 0;
		while(!args[i].equals(parameter) && i < args.length) i++;
		if(i < args.length-1) {
        	return args[i+1];
		}
		else
			return null;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
