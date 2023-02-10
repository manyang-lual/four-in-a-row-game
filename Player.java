package oopIntro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
	private String name;
	private String playerNumber;
	private static Scanner scanner = new Scanner(System.in);
	
	public Player(String name, String playerNumber) {
		this.name=name;
		this.playerNumber=playerNumber;
	}
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return playerNumber;
	}
	public int makeMove() {
		System.out.println("What column do you want to place your token");
		int column=0;
		
		try
	    { 
	      column   = scanner.nextInt();      
	      System.out.println("The column is "+column );
	    } 

	    catch ( InputMismatchException ex )
	    { 
	      System.out.println("You entered bad data." );
	      System.out.println("Run the program again." );
	    } 
		
		return column;
	}
	public String toString() {
		return "Player "+playerNumber+" is "+name;
	}
}
