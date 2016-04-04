package shogi.piece;

import shogi.board.GameBoard;
import shogi.board.Position;
import java.util.ArrayList;

/**
 * @author sina
 * @version 1.0.0
 */
public class GoldGeneral extends ChessMen {
	public GoldGeneral(Position pos, roles role, GameBoard gameBoard) {
		super.position = pos;
		super.setPlayerRole(role);
		super.gameBoard = gameBoard;
		super.setNormal(true);
	}

	@Override
	public ArrayList<Position> calculatingMoves() {
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


		} else if (!super.getNormal()) {
			System.out.println("Golden General cannot be upgraded");
			System.exit(0);
		}

		return allowedMoves;
	}
}