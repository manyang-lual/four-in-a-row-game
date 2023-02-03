package oopIntro;

import java.util.Scanner;

public class Game {
	private Player[] players;
	private Board board;
	private Scanner scanner = new Scanner(System.in);
	
	public Game() {
		
	}
	//This method prompts the user to enter the names of the two players
	public void setUpGame() {
		System.out.println( "enter the names of the two players");
		String name1=scanner.nextLine();
		String name2=scanner.nextLine();
	}
}
