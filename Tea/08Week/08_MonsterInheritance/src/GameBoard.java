
public class GameBoard {
	
	private String[][] board;
	private BFF helper;
	
	private Being player;
	private final String emptySquare = "⬜";
	
	public GameBoard(int size) {
		// row-col order
		board = new String[size][size]; //initializes the array itself
		// fill the array spots with the emptySquare
		for(int row = 0; row < board.length; row++) { 
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = emptySquare;
			}
		}
		player = new Player("Cat",10, "🐈");
		helper = new BFF();
	}
	
	public void run() {
		System.out.println("Here is the empty game board");
		printBoard();
		int row = helper.inputInt("What row should I place the player?", 0, board.length-1);
		int col = helper.inputInt("What col should I place the player?", 0, board[0].length-1);
		board[row][col] = player.getEmojiIcon();
		System.out.println("Here is the new board with the player on it");
		printBoard();
		movePlayerLeft(row, col);
		System.out.println("Here is the board after moving player:");
		printBoard();
		
	}

	private void movePlayerLeft(int row, int col) {
	
		// to move left means to decrease the column
		if(col > 0) {
			board[row][col] = emptySquare;
			board[row][col-1] = player.getEmojiIcon();
		}
		else {
			System.out.println("Can't move left");
		}
	}

	private void printBoard() {
		// before printing board, print the TOP label as one row
		String alpha = "abcdefghijk";
		System.out.print(" ");
		for(int col = 0; col < board[0].length; col++) {
			System.out.print(alpha.charAt(col) + "  ");
		}
		System.out.println();
		for(int row = 0; row < board.length; row++) { 
			// as we start each new row, we need the row number
			System.out.print(row + " ");
			for(int col = 0; col < board[row].length; col++) { // every column
				String toDisplay = board[row][col];
				System.out.print(toDisplay + " "); 
			}
			// reach end of current row all the columns
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("Gameboard of size 10");
		GameBoard gb = new GameBoard(10);
		gb.run();
//		System.out.println("Gameboard of size 5");
//		GameBoard gb2= new GameBoard(5);
//		gb2.run();

	}

}
