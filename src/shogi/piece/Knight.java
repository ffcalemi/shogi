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
		super.setNormal(true);
	}

	@Override
	public ArrayList<Position> calculatingMoves() {
		/**
		 * First check if it is not updated it can just move forward in L shape or
		 * if it is updated it can have a move like GoldGeneral
		 */
		ArrayList<Position> allowedMoves = new ArrayList<>();
		if (getNormal()) {
			if (getPlayerRole() == roles.PLAYER_BLACK_ROLE) {
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() + 2,this.getPosition().getCol() + 1)))
					allowedMoves.add(new Position(this.getPosition().getCol() + 1, this.getPosition().getRow() + 2));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() + 2)))
					allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() + 2));
			}else {
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() + 1, this.getPosition().getRow() - 2)))
					allowedMoves.add(new Position(this.getPosition().getCol() + 1, this.getPosition().getRow() - 2));
				if (gameBoard.canGo(this, new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() - 2)))
					allowedMoves.add(new Position(this.getPosition().getCol() - 1, this.getPosition().getRow() - 2));
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
		return  allowedMoves;
	}

	@Override
	public String toString() {
		return "Kn";
	}
	@Override
	public Object clone(){
		ChessMen chessMen = new Knight(super.position,getPlayerRole(),gameBoard);
		chessMen.setNormal(getNormal());
		return chessMen;
	}
}
