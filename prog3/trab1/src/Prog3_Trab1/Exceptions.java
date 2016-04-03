package Prog3_Trab1;

class ProgramException extends Exception {
	private static final long serialVersionUID = 1L;
}

final class InconsistentDataException extends ProgramException {
	private String col;
	private String value;
	private static final long serialVersionUID = 1L;
	
	public InconsistentDataException(String col, String value) {
		this.col = col;
		this.value = value;
	}
	
	public String getDataLocation() {
		return "(" + this.col + ": " + this.value + ")";
	}
	
}
final class DataFormatException extends ProgramException {
	private static final long serialVersionUID = 1L;
}