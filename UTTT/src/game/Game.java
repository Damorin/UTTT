package game;

import game.board.Board;
import game.board.STATE;

public class Game {

	private Board board = new Board();
	private STATE player = STATE.Blank;

	public boolean playMove(int x, int y) {
		selectPlayer();
		return board.playMove(x, y, player);
	}

	private void selectPlayer() {
		if (player == STATE.Blank || player == STATE.X) {
			player = STATE.O;
		} else {
			player = STATE.X;
		}
	}

	public boolean isGameOver() {
		return !board.isPlayable();
	}

	public boolean isValidMove(int x, int y) {
		return board.isValidMove(x, y);
	}

	public boolean validateCoord(int coord) {
		if (coord > 0 && coord < 4) {
			return true;
		}
		return false;
	}

}
