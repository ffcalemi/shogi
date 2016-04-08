package shogi.piece;

import shogi.board.GameBoard;
import shogi.board.Position;

import java.util.ArrayList;

/**
 * @author sina
 * @version 1.0.0
 */
public class Bishop extends ChessMen{
	public Bishop(Position pos, ChessMen.roles role, GameBoard gameBoard) {

		super.position = pos;
		super.setPlayerRole(role);
		super.gameBoard = gameBoard;
		super.setNormal(true);
	}

	@Override
	public ArrayList<Position>  calculatingMoves() {
		ArrayList<Position> allowedMoves = new ArrayList<>();
		boolean isOpponent = false;
		if(super.getNormal()){
			// v(1,1)
			int counter =1;
			while ( gameBoard.canGo(this,new Position(this.getPosition().getRow()+counter,this.getPosition().getCol()+counter))){
				if(gameBoard.getTable()[this.position.getRow()+counter][this.getPosition().getCol()+counter] !=null)
				isOpponent= true;
					allowedMoves.add(new Position(this.getPosition().getRow()+counter,this.getPosition().getCol()+counter));
				if(isOpponent)
					break;
				counter ++ ;
			}
			//V( 1,-1)
			isOpponent = false;
			counter=1;
			while ( gameBoard.canGo(this,new Position(this.getPosition().getRow()+counter,this.getPosition().getCol()-counter))){
				if(gameBoard.getTable()[this.position.getRow()+counter][this.getPosition().getCol()-counter] !=null)
					isOpponent=true;
				allowedMoves.add(new Position(this.getPosition().getRow()+counter,this.getPosition().getCol()-counter));
				if (isOpponent)
					break;

				counter ++ ;
			}
			isOpponent=false;
			//V( -1,1)
			counter=1;
			while ( gameBoard.canGo(this,new Position(this.getPosition().getRow()- counter,this.getPosition().getCol()+counter))){
				if(gameBoard.getTable()[this.position.getRow()-counter][this.getPosition().getCol()+counter] !=null)
					isOpponent=true;


				allowedMoves.add(new Position(this.getPosition().getRow()-counter,this.getPosition().getCol()+counter));
				if(isOpponent)
					break;
				counter ++ ;
			}
			//v(-1,-1_
			counter=1;
			isOpponent=false;
			while ( gameBoard.canGo(this,new Position(this.getPosition().getRow()-counter,this.getPosition().getCol()-counter))) {

				if(gameBoard.getTable()[this.position.getRow()-counter][this.getPosition().getCol()-counter] !=null)
					isOpponent=true;
				allowedMoves.add(new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() - counter));
				if(isOpponent)
					break;
				counter++;
			}
		}else if( ! super.getNormal()){
			// v(1,1)
			int counter =1;
			isOpponent=false;
			while ( gameBoard.canGo(this,new Position(this.getPosition().getRow()+counter,this.getPosition().getCol()+counter))){
				if(gameBoard.getTable()[this.position.getRow()+counter][this.getPosition().getCol()+counter] !=null)
					isOpponent=true;

				allowedMoves.add(new Position(this.getPosition().getRow()+counter,this.getPosition().getCol()+counter));
				if (isOpponent)
					break;
				counter ++ ;
			}
			//V( 1,-1)
			counter=1;
			isOpponent=false;
			while ( gameBoard.canGo(this,new Position(this.getPosition().getRow()+counter,this.getPosition().getCol()-counter))){
				if(gameBoard.getTable()[this.position.getRow()+counter][this.getPosition().getCol()-counter] !=null)
					isOpponent=true;
				allowedMoves.add(new Position(this.getPosition().getRow()+counter,this.getPosition().getCol()-counter));
				if(isOpponent)
					break;
				counter ++ ;
			}
			//V( -1,1)
			counter=1;
			isOpponent=false;
			while ( gameBoard.canGo(this,new Position(this.getPosition().getRow()- counter,this.getPosition().getCol()+counter))){
				if(gameBoard.getTable()[this.position.getRow()-counter][this.getPosition().getCol()+counter] !=null)
					isOpponent=true;
				allowedMoves.add(new Position(this.getPosition().getRow()-counter,this.getPosition().getCol()+counter));
				if(isOpponent)
					break;
				counter ++ ;
			}
			//v(-1,-1_
			counter=1;
			isOpponent=false;
			while ( gameBoard.canGo(this,new Position(this.getPosition().getRow()-counter,this.getPosition().getCol()-counter))) {
				if(gameBoard.getTable()[this.position.getRow()-counter][this.getPosition().getCol()-counter] !=null)
					isOpponent=true;
				allowedMoves.add(new Position(this.getPosition().getRow() - counter, this.getPosition().getCol() - counter));
				if(isOpponent)
					break;
				counter++;
			}
			if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() - 1)))
				allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() - 1));

			if (gameBoard.canGo(this, new Position(this.getPosition().getRow() - 1, this.getPosition().getCol())))
				allowedMoves.add(new Position(this.getPosition().getRow() - 1, this.getPosition().getCol()));
			if (gameBoard.canGo(this, new Position(this.getPosition().getRow() + 1, this.getPosition().getCol())))
				allowedMoves.add(new Position(this.getPosition().getRow() + 1, this.getPosition().getCol()));
			if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() + 1)))
				allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() + 1));

		}

		return allowedMoves;
	}

	@Override
	public String toString() {
		return "Bi";
	}
}
