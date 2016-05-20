package game;

import java.util.Scanner;

public class Executor {

	public static void main(String[] args) {
		Game game = new Game();

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			int x, y;

			x = scanner.nextInt();
			while (!validateCoord(x)) {
				System.out.println("The x coordinate must be 1, 2 or 3");
				x = scanner.nextInt();
			}

			y = scanner.nextInt();
			while (!validateCoord(y)) {
				System.out.println("The y coordinate must be 1, 2 or 3");
				y = scanner.nextInt();
			}

			validateCoord(y);
			game.playMove(--x, --y);
		}
		scanner.close();
	}

	private static boolean validateCoord(int coord) {
		if (coord > 0 && coord < 4) {
			return true;
		}
		return false;
	}

}
