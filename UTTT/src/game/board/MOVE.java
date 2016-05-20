package game.board;

public enum MOVE {
	TopL(1, 1), TopM(1, 2), TopR(1, 3), MidL(2, 1), Mid(2, 2), MidR(2, 3), BotL(3, 1), BotM(3, 2), BotR(3, 3);

	private final int x;
	private final int y;

	MOVE(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
