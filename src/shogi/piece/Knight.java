package shogi.piece;

import shogi.board.GameBoard;
import shogi.board.Position;

import java.util.ArrayList;

/**
 * @author ahmad
 * @version 1.0.0
 */
public class Knight extends ChessMen {
	public Knight(Position pos, roles role, GameBoard gameBoard) {
		super.position = pos;
		super.setPlayerRole(role);
		super.gameBoard = gameBoard;
	}

	@Override
	public ArrayList<Position> calculatingMoves() {
		ArrayList<Position> allowedMoves = new ArrayList<>();

		return  allowedMoves;
	}

}
