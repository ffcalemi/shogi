package shogi.piece;

import shogi.board.GameBoard;
import shogi.board.Position;

import java.util.ArrayList;

/**
 * @author sina
 * @version 1.0.0
 */
public class SilverGeneral extends ChessMen {
	public SilverGeneral(Position pos, roles role, GameBoard gameBoard) {
		super.position = pos;
		super.setPlayerRole(role);
		super.gameBoard = gameBoard;
		super.setNormal(true);

	}

	@Override
	public ArrayList calculatingMoves() {

		ArrayList<Position> allowedMoves = new ArrayList<>();
		if (super.getNormal()) {
			if( this.getPlayerRole()== roles.PLAYER_WHITE_ROLE){
				//	v( 0,1)
				int counter = 1;
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() + counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() + counter));
				}
				//v(-1,-1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() - counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() - counter));
				}

				//v( 1, -1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() - counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() - counter));
				}
				//v(-1,+1)
				if( gameBoard.canGo(this, new Position(this.getPosition().getRow()-counter, this.getPosition().getCol()+counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow()-counter, this.getPosition().getCol()+counter));
				}
				//v(+1,+1)
				if( gameBoard.canGo(this, new Position(this.getPosition().getRow()+counter, this.getPosition().getCol()+counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() + counter));
				}
			}else if ( this.getPlayerRole() == roles.PLAYER_BLACK_ROLE){
				//	v( 0,-1)
				int counter = 1;
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() - counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() - counter));
				}
				//v(-1,-1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() - counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() - counter));
				}

				//v( 1, -1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() - counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() - counter));
				}
				//v(-1,+1)
				if( gameBoard.canGo(this, new Position(this.getPosition().getRow()-counter, this.getPosition().getCol()+counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow()-counter, this.getPosition().getCol()+counter));
				}
				//v(+1,+1)
				if( gameBoard.canGo(this, new Position(this.getPosition().getRow()+counter, this.getPosition().getCol()+counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() + counter));
				}


			}
		} else if (! super.getNormal()) {
			if( this.getPlayerRole() == roles.PLAYER_WHITE_ROLE) {

				//	v( 0,1)
				int counter = 1;
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() + counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() + counter));
				}
				//v(-1,-1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() - counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() - counter));
				}
				//v( 1, -1)
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
				//v(0,-1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() - counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() - counter));
				}
			}
			else if (this.getPlayerRole().equals(roles.PLAYER_BLACK_ROLE)){
				//	v( 0,-1)
				int counter = 1;
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() -counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() - counter));
				}
				//v(-1,+1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() + counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() + counter));
				}
				//v( 1, +1)
				if (gameBoard.canGo(this, new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() + counter))) {
					allowedMoves.add(new Position(this.getPosition().getRow() + counter, this.getPosition().getCol() + counter));
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
		return "SG";
	}
}
