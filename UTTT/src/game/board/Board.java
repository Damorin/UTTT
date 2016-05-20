package game.board;

public class Board {

	private static final int BOARD_SIZE = 3;
	private static final int MIN_MOVES_TO_WIN = 4;

	private State[][] squares;
	private boolean playable;
	private int moveCount;

	public Board() {
		initializeBoard();
	}

	private void initializeBoard() {
		playable = true;
		moveCount = 0;
		squares = new State[BOARD_SIZE][BOARD_SIZE];
		for (int y = 0; y < BOARD_SIZE; y++) {
			for (int x = 0; x < BOARD_SIZE; x++) {
				squares[x][y] = State.Blank;
			}
		}
	}

	public boolean playMove(int x, int y, State player) {
		if (squares[x][y] == State.Blank) {
			squares[x][y] = player;

			checkPotentialWinner(x, y, player);

			displayBoard();
			moveCount++;
			return true;
		} else {
			return false;
		}
	}

	private void checkPotentialWinner(int x, int y, State player) {
		State winner = checkWinner(x, y, player);
		if (winner != State.Blank) {
			playable = false;
			System.out.println("The winner is " + winner);
			System.out.println("Unless it was a draw... then it was a draw");
		}
	}

	private State checkWinner(int x, int y, State player) {
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
			return State.Draw;
		}
		return State.Blank;
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
		return squares[x][y] == State.Blank;
	}

}
