package oopIntro;

public class TestClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Board board1= new Board();
		board1.boardSetUp();
		//board1.printBoard();
		
		//System.out.println(board1.columnFull(4));
		board1.addToken(1, "0");
		board1.addToken(3, "2");
		board1.addToken(2, "3");
		board1.addToken(4, "1");
		board1.addToken(5, "0");
		
		board1.addToken(1, "1");
		board1.addToken(3, "1");
		board1.addToken(2, "0");
		board1.addToken(4, "1");
		board1.addToken(5, "0");
		//board1.printBoard();
		//System.out.println(board1.checkHorizontal("Lua"));
		board1.addToken(1, "1");
		board1.addToken(3, "0");
		board1.addToken(2, "1");
		board1.addToken(4, "4");
		board1.addToken(5, "0");
		//board1.printBoard();
		
		board1.addToken(1, "1");
		board1.addToken(3, "1");
		board1.addToken(2, "1");
		board1.addToken(4, "0");
		board1.addToken(5, "0");
				
		board1.addToken(1, "0");
		board1.addToken(3, "0");
		board1.addToken(2, "0");
		board1.addToken(4, "0");
		board1.addToken(5, "1");
		//board1.printBoard();
		
		
		board1.printBoard();
		//System.out.println(board1.RightDiagonal("1"));
		//System.out.println(board1.checkVertical("0"));
		System.out.println(board1.checkRightDiagonal("0"));
	}

}
