package shogi.piece;

import shogi.board.GameBoard;
import shogi.board.Position;

import java.util.ArrayList;

/**
 * @author ahmad
 * @version 1.0.0
 */
public class Lance extends ChessMen {
	public Lance(Position pos, roles role, GameBoard gameBoard) {
		super.position = pos;
		super.setPlayerRole(role);
		super.gameBoard = gameBoard;
	}

	@Override
	public ArrayList<Position> calculatingMoves() {
		/**
		 * First check if it is not updated it can just move forward or
		 * if it is updated it can have a move like GoldGeneral
		 */
		ArrayList<Position> allowedMoves = new ArrayList<>();
		if (getNormal()) {
			Position pos;
			int step;
			if (getPlayerRole() == roles.PLAYER_BLACK_ROLE)
				step = 1;
			else
				step = -1;
			//  Move up
			pos = new Position(this.getPosition().getCol(), this.getPosition().getRow() + step);
			while (gameBoard.canGo(this, pos)) {
				allowedMoves.add(pos);
				pos = new Position(pos.getCol(), pos.getRow() + step);
			}
		} else {
			if (getPlayerRole() == roles.PLAYER_BLACK_ROLE) {
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() - 1)))
					allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() - 1));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow())))
					allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow()));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() + 1, this.getPosition().getRow())))
					allowedMoves.add(new Position(this.getPosition().getCol() + 1, this.getPosition().getRow()));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() + 1, this.getPosition().getRow() + 1)))
					allowedMoves.add(new Position(this.getPosition().getCol() + 1, this.getPosition().getRow() + 1));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow() - 1)))
					allowedMoves.add(new Position(this.getPosition().getCol(), this.getPosition().getRow() - 1));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow() + 1)))
					allowedMoves.add(new Position(this.getPosition().getCol(), this.getPosition().getRow() + 1));
			} else {
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() + 1)))
					allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() + 1));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow())))
					allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow()));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() + 1, this.getPosition().getRow())))
					allowedMoves.add(new Position(this.getPosition().getCol() + 1, this.getPosition().getRow()));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() + 1, this.getPosition().getRow() - 1)))
					allowedMoves.add(new Position(this.getPosition().getCol() + 1, this.getPosition().getRow() - 1));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow() + 1)))
					allowedMoves.add(new Position(this.getPosition().getCol(), this.getPosition().getRow() + 1));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow() - 1)))
					allowedMoves.add(new Position(this.getPosition().getCol(), this.getPosition().getRow() - 1));
			}
		}
		return allowedMoves;
	}

	@Override
	public String toString() {
		return "La";
	}
	@Override
	public Object clone(){
		ChessMen chessMen = new Lance(super.position,getPlayerRole(),gameBoard);
		chessMen.setNormal(getNormal());
		return chessMen;
	}
}
