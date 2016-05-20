package game.controllers;

import game.board.MOVE;

public interface Player {

	MOVE getMove();
	String getStudentName();
	String getStudentID();
}
