package shogi.piece;

import shogi.board.Position;
import shogi.board.GameBoard;

import java.util.ArrayList;

/**
 * @author ahmad
 * @version 1.0.0
 */
public class Pawn extends ChessMen {
	public Pawn(Position pos, roles role, GameBoard gameBoard) {
		super.position = pos;
		super.setPlayerRole(role);
		super.gameBoard = gameBoard;
	}
	@Override
	public ArrayList<Position> calculatingMoves(){
		/**
		 * First check the role of the pawn and then check whether it is updated or not
		 */
		/**
		 * + n +
		 * + P +
		 * - + -
		 */
		ArrayList<Position> allowedMoves = new ArrayList<>();
		if(getPlayerRole() == roles.PLAYER_BLACK_ROLE) {
			if (!getNormal()) {
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow()-1)))
					allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow()-1));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow())))
					allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow()));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol()+1, this.getPosition().getRow())))
					allowedMoves.add(new Position(this.getPosition().getCol()+1, this.getPosition().getRow()));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol()+1, this.getPosition().getRow()+1)))
					allowedMoves.add(new Position(this.getPosition().getCol()+1, this.getPosition().getRow()+1));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow()-1)))
					allowedMoves.add(new Position(this.getPosition().getCol(), this.getPosition().getRow()-1));
			}
			if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow()+1)))
				allowedMoves.add(new Position(this.getPosition().getCol(), this.getPosition().getRow()+1));
		}else {
			if (!getNormal()) {
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow()+1)))
					allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow()+1));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow())))
					allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow()));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol()+1, this.getPosition().getRow())))
					allowedMoves.add(new Position(this.getPosition().getCol()+1, this.getPosition().getRow()));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol()+1, this.getPosition().getRow()-1)))
					allowedMoves.add(new Position(this.getPosition().getCol()+1, this.getPosition().getRow()-1));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow()+1)))
					allowedMoves.add(new Position(this.getPosition().getCol(), this.getPosition().getRow()+1));
			}
			if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow()-1)))
				allowedMoves.add(new Position(this.getPosition().getCol(), this.getPosition().getRow()-1));
		}
		return allowedMoves;
	}

}
