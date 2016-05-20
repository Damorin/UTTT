package game;

import game.board.Board;
import game.board.State;

public class Game {

	private Board board = new Board();
	private State player = State.Blank;

	public boolean playMove(int x, int y) {
		selectPlayer();
		return board.playMove(x, y, player);
	}

	private void selectPlayer() {
		if (player == State.Blank || player == State.X) {
			player = State.O;
		} else {
			player = State.X;
		}
	}

	public boolean isGameOver() {
		return !board.isPlayable();
	}

	public boolean isValidMove(int x, int y) {
		return board.isValidMove(x, y);
	}

}
