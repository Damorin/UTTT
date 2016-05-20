package game.board;

public class Board {

	private static final int BOARD_SIZE = 3;

	private STATE[][] squares;
	private boolean playable;
	private int moveCount;

	public Board() {
		initializeBoard();
	}

	private void initializeBoard() {
		playable = true;
		moveCount = 0;
		squares = new STATE[BOARD_SIZE][BOARD_SIZE];
		for (int y = 0; y < BOARD_SIZE; y++) {
			for (int x = 0; x < BOARD_SIZE; x++) {
				squares[x][y] = STATE.Blank;
			}
		}
	}

	public boolean playMove(int x, int y, STATE player) {
		if (squares[x][y] == STATE.Blank) {
			squares[x][y] = player;

			checkPotentialWinner(x, y, player);

			displayBoard();
			moveCount++;
			return true;
		} else {
			return false;
		}
	}

	private void checkPotentialWinner(int x, int y, STATE player) {
		STATE winner = checkWinner(x, y, player);
		if (winner != STATE.Blank) {
			playable = false;
			System.out.println("The winner is " + winner);
			System.out.println("Unless it was a draw... then it was a draw");
		}
	}

	private STATE checkWinner(int x, int y, STATE player) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (squares[x][i] != player)
				break;
			if (i == BOARD_SIZE - 1) {
				return player;
			}
		}

		// check row
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (squares[i][y] != player)
				break;
			if (i == BOARD_SIZE - 1) {
				return player;
			}
		}

		// check diag
		if (x == y) {
			// we're on a diagonal
			for (int i = 0; i < BOARD_SIZE; i++) {
				if (squares[i][i] != player)
					break;
				if (i == BOARD_SIZE - 1) {
					return player;
				}
			}
		}

		// check anti diag
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (squares[i][(BOARD_SIZE - 1) - i] != player)
				break;
			if (i == BOARD_SIZE - 1) {
				return player;
			}
		}

		// check draw
		if (moveCount == (Math.pow(BOARD_SIZE, 2) - 1)) {
			return STATE.Draw;
		}
		return STATE.Blank;
	}

	private void displayBoard() {
		for (int x = 0; x < BOARD_SIZE; x++) {
			for (int y = 0; y < BOARD_SIZE; y++) {
				if (y == 0) {
					System.out.print(squares[x][y]);
				} else
					System.out.print("|" + squares[x][y]);
			}
			System.out.println();
		}
	}

	public boolean isPlayable() {
		return playable;
	}

	public boolean isValidMove(int x, int y) {
		return squares[x][y] == STATE.Blank;
	}

}
