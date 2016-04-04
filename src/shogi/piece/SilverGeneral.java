package shogi.piece;

import shogi.board.GameBoard;
import shogi.board.Position;

import java.util.ArrayList;

/**
 * @author ahmad
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
				if( gameBoard.canGo(this, new Position(this.getPosition().getRow()+counter, this.getPosition().getCol()+counter))){
				allowedMoves.add(new Position(this.getPosition().getRow()+counter, this.getPosition().getCol()+counter));
			}
			} else if (! super.getNormal()) {

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

			return allowedMoves;


	}




}