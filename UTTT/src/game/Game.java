package game;

import game.board.Board;

public class Game {

	private Board board = new Board();
	private int player = 0;

	public boolean playMove(int x, int y) {
		selectPlayer();
		return board.playMove(x, y, player);
	}

	private void selectPlayer() {
		if (player == 0 || player == 2) {
			player = 1;
		} else {
			player = 2;
		}
	}

}
