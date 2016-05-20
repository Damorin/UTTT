package game.board;

public class Board {

	private int[][] squares;
	private boolean playable;

	public Board() {
		initializeBoard();
	}

	private void initializeBoard() {
		playable = true;
		squares = new int[3][3];
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				squares[y][x] = 0;
			}
		}
	}

	public boolean playMove(int x, int y, int player) {
		if (squares[y][x] == 0) {
			squares[y][x] = player;
			displayBoard();
			return true;
		} else {
			return false;
		}
	}

	private void displayBoard() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (y == 0) {
					System.out.print(squares[x][y]);
				} else
					System.out.print("|" + squares[x][y]);
			}
			System.out.println();
			System.out.println("-----");
		}
	}

	public boolean isPlayable() {
		return playable;
	}

}
