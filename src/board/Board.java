package board;

import java.awt.Point;
import java.util.Vector;

public class Board {

	public static int SIZE = 9;
	/*Attributes*/
	private Vector<Vector<Cell>> board;
	
	/*Builders*/
	public Board() {
		board = new Vector< Vector<Cell>>();
		board.setSize(SIZE);
		for(int i=0;i<SIZE;i++) {
			board.set(i, new Vector<Cell>());
			board.get(i).setSize(SIZE);
			for(int j =0;j<SIZE;j++) {
				board.get(i).set(j,new Cell());
			}
		}
	}
	
	/*Methods*/
	public Cell getCell(int i, int j) {
		return board.get(i).get(j);
	}
	
	
	
	
	
	public boolean isValid(int i, int j) {
		return ( isRowValid(i, j) && isColumnValid(i, j) && isSquareValid(i, j));
	}
	
	/* This ones are not optimal yet because they iterate each and every possibility 
	 * even though they know it is not valid
	 */
	private boolean isRowValid(int i, int j) {
		Number objective = getCell(i,j).getNumber();
		
		for(int k=0;k<SIZE;k++) {
			Number compared = getCell(i,k).getNumber();
			if(compared != Number.BLANK && k!=j) {
				if(objective == compared) {
					return false;
				}
			}
			
		}
		return true;
	}
	
	private boolean isColumnValid(int i, int j){
		Number objective = getCell(i,j).getNumber();
		
		for(int k=0;k<SIZE;k++) {
			Number compared = getCell(k,j).getNumber();
			if(compared != Number.BLANK && k!=i) {
				if(objective == compared) {
					return false;
				}
			}
			
		}
		return true;
	}
	
	private boolean isSquareValid(int i, int j) {
		
		int gridrow = checkGrid(i);
		int gridcolumn = checkGrid(j);
		
		Number objective = getCell(i, j).getNumber();
		
		for(int k=3*gridrow;k<3*gridrow+3;k++) {
			for(int l = 3*gridcolumn;l<3*gridcolumn+3;l++) {
				Number compared = getCell(k, l).getNumber();
				
				if( compared != Number.BLANK && (k!=i && l!=j)) {
					
					if (objective == compared) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private int checkGrid(int value) {
		if( value>5) {
			return 2;
		}
		else if( value>2) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
	public boolean isFilled() {
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if (getCell(i, j).getNumber() == Number.BLANK) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public boolean solveBackTracking() {
		/*
		 * Si esta filled hemos terminado, si no
		 * 		Si:
		 * 			Esta sin rellenar ( es BLANK) asigno numero del 1 al 9
		 * 				Asigno
		 */
		Point coord = getNextUnfilled();
		if (coord.x == -1) {
			return true;
		}
		for(int k=1; k<=SIZE;k++) {
			getCell(coord.x,coord.y).setNumber(Number.values()[k]);
			if(isValid(coord.x, coord.y)) {
				if (solveBackTracking()) {
					return true;
				}
			}
			getCell(coord.x,coord.y).setNumber(Number.BLANK);
			
		}
		return false;
	}

	private Point getNextUnfilled() {
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if (getCell(i, j).getNumber() == Number.BLANK) {
					return new Point(i,j);
				}
			}
		}
		return new Point(-1,-1);
	}
	
	
	public void paint() {
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if(getCell(i, j).getNumber() == Number.BLANK) {
					System.out.print(" # ");
				}
				else {
					System.out.print(" "+getCell(i, j).getNumber().ordinal() +" ");
				}
			}
			System.out.println(" ");
		}
	}
	
}
