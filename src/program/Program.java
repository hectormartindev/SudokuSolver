package program;

import board.Board;
import board.Number;

public class Program {

	public static void main(String[] args){
		Board b = new Board();
		
		b.getCell(0, 1).setNumber(Number.THREE);
		b.getCell(0, 2).setNumber(Number.EIGHT);
		b.getCell(0, 3).setNumber(Number.FIVE);
		b.getCell(0, 7).setNumber(Number.TWO);
		
		b.getCell(1, 0).setNumber(Number.SIX);
		b.getCell(1, 4).setNumber(Number.ONE);
		b.getCell(1, 6).setNumber(Number.EIGHT);
		
		b.getCell(2, 0).setNumber(Number.FIVE);
		b.getCell(2, 1).setNumber(Number.FOUR);
		b.getCell(2, 2).setNumber(Number.SEVEN);
		b.getCell(2, 4).setNumber(Number.SIX);
		b.getCell(2, 6).setNumber(Number.ONE);
		
		b.getCell(3, 0).setNumber(Number.THREE);
		b.getCell(3, 2).setNumber(Number.FOUR);
		b.getCell(3, 3).setNumber(Number.NINE);
		b.getCell(3, 5).setNumber(Number.ONE);
		
		b.getCell(4, 0).setNumber(Number.NINE);
		b.getCell(4, 1).setNumber(Number.EIGHT);
		b.getCell(4, 2).setNumber(Number.FIVE);
		b.getCell(4, 3).setNumber(Number.TWO);
		b.getCell(4, 7).setNumber(Number.SIX);
		
		b.getCell(5, 2).setNumber(Number.TWO);
		b.getCell(5, 3).setNumber(Number.SIX);
		b.getCell(5, 4).setNumber(Number.FOUR);
		b.getCell(5, 8).setNumber(Number.THREE);
		
		b.getCell(6, 6).setNumber(Number.SIX);
		
		b.getCell(7, 2).setNumber(Number.THREE);
		b.getCell(7, 4).setNumber(Number.FIVE);
		b.getCell(7, 8).setNumber(Number.EIGHT);
		
		b.getCell(8, 1).setNumber(Number.SEVEN);
		b.getCell(8, 8).setNumber(Number.FIVE);

		System.out.println("Sudoku original: ");
		b.paint();
		if(b.solveBackTracking()) {
			System.out.println("Solution found");
		}
		else {
			System.out.println("Solution not found");
		}
		
		b.paint();
		

	}
	
}
