package program;

import java.io.IOException;
import java.util.Scanner;

import board.Board;
import board.Number;

public class Program {

	private static Board b = new Board();
	private static Scanner s = new Scanner(System.in);;
	public static void main(String[] args){
		
		/*
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
		 */
		
		
		while(true) {
			b.paint();
			options();
			
			System.out.println();
		}
		

	}
	
	private static void options() {
		System.out.println("Sudoku Solver");
		System.out.println("1.- edit a number");
		System.out.println("2.- Solve");
		System.out.println("3.- Exit");
		
		
		int n = s.nextInt();
		getOption(n);
		
	}
	
	private static void getOption(int option) {
		switch(option) {
		case 1:
			editSudoku();
			break;
		case 2:
			b.solveBackTracking();
			break;
		case 3:
			s.close();
			System.exit(0);
			break;
		}
	}
	
	private static void editSudoku() {
		System.out.print("row number: ");
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		
		System.out.print("column number: ");
		int j = s.nextInt();
		
		System.out.print("Value (0 for blank) ");
		int value = s.nextInt();
		
		b.getCell(i, j).setNumber(Number.values()[value]);
		
	}
	
}
