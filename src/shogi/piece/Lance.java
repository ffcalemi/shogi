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
		super.setNormal(true);
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
			pos = new Position(this.getPosition().getRow() + step,this.getPosition().getCol());
			while (gameBoard.canGo(this, pos)) {
				allowedMoves.add(pos);
				pos = new Position(pos.getCol(), pos.getRow() + step);
			}
		} else {
			if( this.getPlayerRole()== roles.PLAYER_WHITE_ROLE) {
				//	v( 0,1)
				int counter = 1;
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() + counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() + counter));
				}
				//v(-1,-1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() - counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() - counter));
				}
				//v( -1, +1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() -counter, this.getPosition().getCol() + counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() -counter, this.getPosition().getCol() +counter));
				}
				// v( -1,0)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() - counter, this.getPosition().getCol()))) {
					allowedMoves.add(new Position(this.getPosition().getRow() - counter, this.getPosition().getCol()));
				}
				//v( +1,0)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() +counter, this.getPosition().getCol()))) {
					allowedMoves.add(new Position(this.getPosition().getRow() + counter, this.getPosition().getCol()));
				}
				//v(0,-1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() - counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() - counter));
				}
			}else if( this.getPlayerRole()== roles.PLAYER_BLACK_ROLE){
				//	v( 0,-1)
				int counter = 1;
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() -counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() - counter));
				}
				//v(+1,+1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() + counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() + counter));
				}
				//v(+ 1, -1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() - counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() - counter));
				}
				// v( -1,0)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() - counter, this.getPosition().getCol()))) {
					allowedMoves.add(new Position(this.getPosition().getRow() - counter, this.getPosition().getCol()));
				}
				//v( 1,0)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() + counter, this.getPosition().getCol()))) {
					allowedMoves.add(new Position(this.getPosition().getRow() + counter, this.getPosition().getCol()));
				}
				//v(0,+1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() + counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() +counter));
				}


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
