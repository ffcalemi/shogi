package shogi.piece;

import shogi.board.Position;
import shogi.board.GameBoard;

import java.util.ArrayList;

/**
 * @author ahmad
 * @version 1.0.0
 */
public class Pawn extends ChessMen {
	public Pawn(Position pos, ChessMen.roles role) {

	}
	@Override
	public ArrayList<Position> calculatingMoves(){
		/**
		 * First check the role of the pawn and then check whether it is updated or not
		 */
		ArrayList<Position> allowedMoves = new ArrayList<>();
		if
		if (!getNormal()) {
			if (gameBoard.canGo(this, new Position(this.getPosition().getCol()-1, this.getPosition().getRow()))) allowedMoves.add(new Position(this.getPosition().getCol()-1,this.getPosition().getRow()));
			if (gameBoard.canGo(this, new Position(this.getPosition().getCol()-1, this.getPosition().getRow()+1))) allowedMoves.add(new Position(this.getPosition().getCol()-1,this.getPosition().getRow()+1));
			if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow()))) allowedMoves.add(new Position(this.getPosition().getCol(),this.getPosition().getRow()));
			if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow()))) allowedMoves.add(new Position(this.getPosition().getCol(),this.getPosition().getRow()));
			if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow()))) allowedMoves.add(new Position(this.getPosition().getCol(),this.getPosition().getRow()));
		}
		if (gameBoard.canGo(this, new Position(this.getPosition().getCol(), this.getPosition().getRow()))) allowedMoves.add(new Position(this.getPosition().getCol(),this.getPosition().getRow()));
		return allowedMoves;
	}

}
