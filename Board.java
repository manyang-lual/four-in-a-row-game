package oopIntro;

import java.util.Scanner;
public class Board {
	private String[][] board;
	private Scanner scanner = new Scanner(System.in);
	
	private int numberOfRows;
	private int numberOfColumns;
	
	public Board() {
		/*Every time you create a new board, you prompt the player to enter 
		 * the number of rows and columns they want the board to have
		 * You then create a 2D board with the number of rows and columns given by the player
		 * You then have to populate theboard with - to ensure it is an empty board
		 * 
		 * */
		//prompt player for the number of rows
		//store number of rows in row variable
		//surround the input in a try catch block to make sure it is integer input
		System.out.println("How many rows: ");
		try {
			this.numberOfRows=Integer.parseInt(scanner.nextLine());
		}catch ( Exception ex ){
		      System.out.println("You did not provide a valid input for the number of rows." );
		      System.out.println("Run the program again." );
		} 
		
		//prompt player for the number of rows
		//store number of rows in row variable
		System.out.println("How many columns: ");
		try {
			this.numberOfColumns=Integer.parseInt(scanner.nextLine());
		}catch ( Exception ex ){
		      System.out.println("You did not provide a valid input for the number of columns" );
		      System.out.println("Run the program again." );
		} 
		if(this.numberOfRows <1 || this.numberOfColumns < 1) {
			 System.out.println("You did not provide a valid input for the number of rows/colummns." );
			 System.out.println("Run the program again." );
			 System.exit(1);
		}
		//create a 2D board with rows and columns given by the user
		this.board= new String[numberOfRows][numberOfColumns];
		
		//loop through the entire board and populate it with -. This represents an empty board
		for(int i=0; i<this.numberOfRows; i++) {
			for(int j=0; j<this.numberOfColumns; j++) {
				this.board[i][j]="-";
			}
		}

		
	}
	
	//method to get the board
	public String[][] getBoard() throws Exception{
		return this.board;
	}
	
	public void printBoard() throws Exception {
		
		//loop through the 2D array and print values at each index
		for(int i=0; i<this.board.length; i++) {
			for(int j=0; j<this.board[i].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public boolean columnFull(int column) throws Exception{
		/*if the first row at a given column is not "-", that means that entire column has been 
		 assigned values and it is not empty
		*/
		String[][] board = this.getBoard();
		boolean isFull=true;
		int numColumns= board[0].length;
		
		if(column > numColumns) {
			throw new Exception("Error!! Column not on the board!!!");
		}
		else {
			if(board[0][column-1].equals("-")) {
				isFull=false;
			}
			else {
				isFull=true;
			}
		}
		return isFull;
	}
	public boolean boardFull() throws Exception {
		/* Check to see if every column of first row is full */
		String[][] board = this.getBoard();
		boolean isFull=true;
		for(int i=0; i<board[0].length; i++) {
			if(board[0][i] == "-") {
				isFull=false;
			}
		}
		
		return isFull;
	}
	public void addToken(int colToAdd, String playerName) throws Exception {
		
		/*if the column is valid and not full
		 *get the index of last row and loop through it until first row
		 *insert the data at the first empty space you find 
		 * 
		 */
		
		int lastRow=this.getBoard().length-1;
		
		while(lastRow >=0) {
			if(this.getBoard()[lastRow][(colToAdd-1)].equals("-")) {
				this.getBoard()[lastRow][(colToAdd-1)] = playerName;
				break;
			}
			lastRow--;
		}
	}
	
	public boolean checkVertical(String playerName) throws Exception {
		String[][] board = this.getBoard();
		boolean check = false;
		int lastRow=board.length-1;
		for(int i=lastRow; i>=0; i--) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j].equals(playerName)) {
					int count=0;
					for(int k=i; k>=0; k--) {
						if(board[k][j].equals(playerName)) {
							count++;
							if(count==4) {
								check=true;
								break;
							}
						}
					}
				}
			}
		}
		
		return check;
	}
	public boolean checkHorizontal(String playerName) throws Exception {
		String[][] board = this.getBoard();
		boolean check= false;
		int rows=board.length-1;
		int cols=board[0].length-1;
		
		/*/loop through the board from the bottom and check if there is a column where the playerNamee
		//exist
		 * if the playerName exists on a certain row, loop through the columns of that row and increment counter
		 * if counter is 4, then the player has won, break the loop and return true
		*/
		for(int i=rows; i>=0; i--) {
			for(int j=0; j<=cols; j++) {
				if(board[i][j].equalsIgnoreCase(playerName)) {
					int counter=0;
					for(int k=j; k<=cols; k++) {
						if(board[i][k].equalsIgnoreCase(playerName)) {
							counter++;
						}
						if(counter==4) {
							check=true;
							break;
						}
						
					}
				}
			}
		}
		
		return check;
	}
	public boolean checkLeftDiagonal(String playerName) throws Exception {
		String[][] board = this.getBoard();
		boolean check =false;
		/*Loop through the board starting at the last row and last column
		 * if the name at the current row and column equals the playerName, 
		 * then loop through the rows starting at the current row. Initialized a counter variable with zero and 
		 * increment it if board[row][column] equals playerName
		 * check if counter is 4 and return true
		 * Decrement the column value
		 * */
		int row = board.length;
		int column = board[0].length;
		
		for(int i=row-1; i>=0; i--) {
			for(int j=column-1; j>=0; j--) {
				if(board[i][j].equalsIgnoreCase(playerName)) {
					int counter=0;
					int col=j;
					for(int k=i; k>=0; k--) {
						
						if(col<0) {
							break;
						}
						
						if(board[k][col].equalsIgnoreCase(playerName)) {
							counter++;
						}
						
						if(!board[k][col].equalsIgnoreCase(playerName)) {
							break;
						}
						
						if(counter==4) {
							check=true;
							break;
						}
						col--;
					}
				}
			}
		}
		
		return check;
	}
	public boolean checkRightDiagonal(String playerName) throws Exception {
		String[][] board = this.getBoard();
		boolean check = false;
		/*loop through the board starting at last row column 0.
		 * check if the value at that column equals the playerName, if true
		 * loop through the board to see if the value at the next row one column from current
		 * is equal to playerName
		 * if so, increase counter
		 * check if counter is 4; return true and break loop
		 * 
		 * */
		int row = board.length;
		int col = board[0].length;
		
		for(int i=row-1; i>0; i--) {
			for(int j=0; j<=col-1; j++) {
				if(board[i][j].equalsIgnoreCase(playerName)) {
					int counter=0;
					int column=j;
					for(int k=i; k>=0; k--) {
						
						if(column>col-1) {
							break;
						}
						
						if(board[k][column].equalsIgnoreCase(playerName)) {
							counter++;
						}
						
						if(!board[k][column].equalsIgnoreCase(playerName)) {
							break;;
						}
						
						if(counter==4) {
							check=true;
							break;
						}
						column++;
					}
				}
			}
		}
		return check;
	}
	
	public boolean checkIfPlayerIsTheWinner(String playerName) throws Exception {
		return checkVertical(playerName)||checkHorizontal(playerName) || checkLeftDiagonal(playerName)|| checkRightDiagonal(playerName);
	}
}
