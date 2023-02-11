package oopIntro;

import java.util.Scanner;
public class Game {
	private Player[] players;
	private Board board;
	private Scanner scanner = new Scanner(System.in);
	
	public Game() {
//		//every time you create a new Game, you prompt the user to enter names of two players
//		//You have to make sure the two names are unique
//		//if the names are unique, set up the board, by calling new board
//		System.out.println( "Enter the name of player1"); 
//		String player1Name=scanner.nextLine();
//		
//		System.out.println( "Enter the name of player2"); 
//		String player2Name=scanner.nextLine();
//		
//		//Make sure the two players have unique names
//		if(player1Name.equalsIgnoreCase(player2Name)) {
//			System.out.println("The two palyers have the same name. \nRun the game again");
//			System.exit(1);
//		}
//		else {
//			players = new Player[2];
//			players[0]= new Player(player1Name,null);
//			players[1]= new Player(player2Name,null);
//			this.board = new Board();
//		}
	}
	public void setUpGame() {
		//every time you create a new Game, you prompt the user to enter names of two players
		//You have to make sure the two names are unique
		//if the names are unique, set up the board, by calling new board
		System.out.println( "Enter the name of player1"); 
		String player1Name=scanner.nextLine();
		
		System.out.println( "Enter the name of player2"); 
		String player2Name=scanner.nextLine();
		
		//Make sure the two players have unique names
		if(player1Name.equalsIgnoreCase(player2Name)) {
			System.out.println("The two palyers have the same name. \nRun the game again");
			System.exit(1);
		}
		else {
			players = new Player[2];
			players[0]= new Player(player1Name,null);
			players[1]= new Player(player2Name,null);
			this.board = new Board();
		}
	}
	public Player getPlayer1() {
		return this.players[0];
	}
	public Player getPlayer2() {
		return this.players[1];
	}
	public void printWinner(Player player) {
		System.out.println("The winner is "+player.getName());
	}
	
	public void playerTurn(Player currentPlayer) throws Exception, InvalidMoveException, ColumnFullException{
		
		int column=currentPlayer.makeMove(); 		//column where player when to play their name
		
		String[][] board1 = board.getBoard();		//returns the 2D array that is initialize with -											//returns the board as a 2D array
		int numberOfColumns = board1[0].length; 	//Get you the number of columns you board has
		
		try {
			if(column > numberOfColumns) {
				throw new InvalidMoveException("The column number exceeds the number of columns on the board. ");
			
			}
			else if(board.columnFull(column)) { 
				throw new ColumnFullException("The selected column is full and cannot accept any more tokens.. ");
			}
			else {
				board.addToken(column,currentPlayer.getName());
				board.printBoard();
			}
			
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println("Run the program again." );
		}
		
	}
	public void play() throws Exception {
		boolean noWinner = true;
		this.setUpGame();
		int currentPlayerIndex = 0;
		while(noWinner) {
			if(this.board.boardFull()) {
				System.out.println("Board is now full. Game Ends.");
				System.exit(1);
			}
			else {
				Player currentPlayer=players[currentPlayerIndex];
				System.out.println("It is player " + currentPlayer.getName()+" turn to play");
				this.playerTurn(currentPlayer);
				
				if(board.checkIfPlayerIsTheWinner(currentPlayer.getName())) {
					this.printWinner(currentPlayer);
					noWinner=false;
				}
				else {
					currentPlayerIndex++;
					currentPlayerIndex%=players.length;
				}
			}
		}
	}
}
