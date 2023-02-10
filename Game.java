package oopIntro;

import java.util.Scanner;

public class Game {
	private Player[] players;
	private Board board;
	private Scanner scanner = new Scanner(System.in);
	
	public Game() {
		
	}
	//This method prompts the user to enter the names of the two players
	public void setUpGame() throws Exception {
		System.out.println( "Enter the name of player1"); 
		String name1=scanner.nextLine();
		
		
//		System.out.println( "Enter the number of player1"); 
//		String number1=scanner.nextLine();
//		Player player1 = new Player(name1, number1);
		
		System.out.println( "Enter the name of player2"); 
		String name2=scanner.nextLine();
		
		if(!name1.equalsIgnoreCase(name2)) {
			board.boardSetUp();
		}
		
//		
//		System.out.println( "Enter the number of player2"); 
//		String number2=scanner.nextLine();
//		Player player2 = new Player(name2, number2);
		
		//players[0]=player1;
		//players[1]=player2;
		
		
	}
	public void printWinner(Player player) {
		System.out.println("The winner is "+player.getName());
	}
	
	public void playerTurn(Player currentPlayer) throws Exception{
	
		int column=currentPlayer.makeMove(); 		//column where player when to play their name
		String[][] board1 = board.getBoard();		//board.boardSetUp();											//returns the board as a 2D array
		int numberOfColumns = board1[0].length; 
		board.printBoard();//returns the number of columns on the board
//		
//		try {
//			if(column > numberOfColumns) {
//				throw new InvalidMoveException();
//			
//			}
//			else if(board.columnFull(column)) { 
//				throw new ColumnFullException();
//			}
//			else {
//				board.addToken(column,currentPlayer.getName());
//				board.printBoard();
//			}
//			
//		}catch(Exception exp) {
//			System.out.println("The exception" + exp + " was handled");
//		}
		
	}
	public void play() {
		
	}
}
