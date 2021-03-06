package game;

import java.util.Scanner;

public class Executor {

	public static void main(String[] args) {
		Game game = new Game();

		Scanner scanner = new Scanner(System.in);
		while (!game.isGameOver()) {
			int x, y;

			System.out.println("Please enter the Y Coordinate");
			y = scanner.nextInt();
			while (!game.validateCoord(y)) {
				System.out.println("The Y coordinate must be 1, 2 or 3");
				y = scanner.nextInt();
			}

			System.out.println("Please enter the X Coordinate");
			x = scanner.nextInt();
			while (!game.validateCoord(x)) {
				System.out.println("The X coordinate must be 1, 2 or 3");
				x = scanner.nextInt();
			}

			x--;
			y--;

			if (game.isValidMove(x, y)) {
				game.playMove(x, y);
			} else {
				System.out.println("Invalid Move, please enter another");
			}
		}
		scanner.close();
	}
}
