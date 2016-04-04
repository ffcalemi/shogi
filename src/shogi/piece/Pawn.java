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
		ArrayList<Position> allowedMoves = new ArrayList<>();

		if( gameBoard.canGo(this , new Position(this.getPosition().getRow()-1 , this.getPosition().getCol()) ) ) allowedMoves.add(new Position(this.getPosition().getRow()-1 , this.getPosition().getCol()) );
		if( gameBoard.canGo(this , new Position(this.getPosition().getRow()-1 , this.getPosition().getCol()-1))) allowedMoves.add(new Position(this.getPosition().getRow()-1 , this.getPosition().getCol()-1) );
		if( gameBoard.canGo(this , new Position(this.getPosition().getRow() , this.getPosition().getCol()-1))) allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol()-1) );
		if( gameBoard.canGo(this , new Position(this.getPosition().getRow()+1 , this.getPosition().getCol()))) allowedMoves.add(new Position(this.getPosition().getRow()+1 , this.getPosition().getCol()) );
		if( gameBoard.canGo(this , new Position(this.getPosition().getRow()+1 , this.getPosition().getCol()+1))) allowedMoves.add(new Position(this.getPosition().getRow()+1 , this.getPosition().getCol()+1) );
		if( gameBoard.canGo(this , new Position(this.getPosition().getRow() , this.getPosition().getCol()+1))) allowedMoves.add(new Position(this.getPosition().getRow() , this.getPosition().getCol()+1) );
		if( gameBoard.canGo(this , new Position(this.getPosition().getRow()-1 , this.getPosition().getCol()+1)))allowedMoves.add(new Position(this.getPosition().getRow()-1 , this.getPosition().getCol()+1) );
		if( gameBoard.canGo(this , new Position(this.getPosition().getRow()+1 , this.getPosition().getCol()-1))) allowedMoves.add(new Position(this.getPosition().getRow()+1 , this.getPosition().getCol()-1) );

		return allowedMoves;
	}

}
