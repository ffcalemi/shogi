package shogi.piece;

import shogi.board.GameBoard;
import shogi.board.Position;

import java.util.ArrayList;

/**
 * @author ahmad
 * @version 1.0.0
 */
public class Rock extends ChessMen {
	public Rock(Position pos, ChessMen.roles role, GameBoard gameBoard) {
		super.position = pos;
		super.setPlayerRole(role);
		super.gameBoard = gameBoard;
		super.setNormal(true);
	}

	@Override
	public ArrayList<Position> calculatingMoves() {
		/**
		 * Check the rock direct path until it can go through and after that check the possibility of the
		 * updated rock move
		 */
		ArrayList<Position> allowedMoves = new ArrayList<>();
		Position pos;

		//  Move up
		pos = new Position(this.getPosition().getCol(), this.getPosition().getRow() + 1);
		while (gameBoard.canGo(this, pos)) {
			allowedMoves.add(pos);
			pos = new Position(pos.getCol(), pos.getRow() + 1);
		}

		//  Move down
		pos = new Position(this.getPosition().getCol(), this.getPosition().getRow() - 1);
		while (gameBoard.canGo(this, pos)) {
			allowedMoves.add(pos);
			pos = new Position(pos.getCol(), pos.getRow() - 1);
		}

		//  Move left
		pos = new Position(this.getPosition().getCol() - 1, this.getPosition().getRow());
		while (gameBoard.canGo(this, pos)) {
			allowedMoves.add(pos);
			pos = new Position(pos.getCol() - 1, pos.getRow());
		}

		//  Move right
		pos = new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() + 1);
		while (gameBoard.canGo(this, pos)) {
			allowedMoves.add(pos);
			pos = new Position(pos.getCol() - 1, pos.getRow());
		}
		if (!getNormal()) {
			if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() - 1)))
				allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() - 1));
			if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() + 1)))
				allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() + 1));
			if (gameBoard.canGo(this, new Position(this.getPosition().getCol() + 1, this.getPosition().getRow() + 1)))
				allowedMoves.add(new Position(this.getPosition().getCol() + 1, this.getPosition().getRow() + 1));
			if (gameBoard.canGo(this, new Position(this.getPosition().getCol() + 1, this.getPosition().getRow() - 1)))
				allowedMoves.add(new Position(this.getPosition().getCol() + 1, this.getPosition().getRow() - 1));
		}
		return allowedMoves;
	}

	@Override
	public String toString() {
		return "Ro";
	}
}
