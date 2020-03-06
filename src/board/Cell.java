package board;

public class Cell {

	/*Attributes*/
	private Number number;
	
	/*Builders*/
	public Cell() {
		number = Number.BLANK;
	}
	
	public Cell(Number n) {
		number = n;
	}
	
	/*Methods*/
	public Number getNumber() {
		return number;
	}
	
	public void setNumber(Number n) {
		number = n;
	}
}
