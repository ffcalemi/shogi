package shogi.piece;

import shogi.board.GameBoard;
import shogi.board.Position;

import java.util.ArrayList;

/**
 * @author sina
 * @version 1.0.0
 */
public class King extends ChessMen{


	public King(Position pos, roles role, GameBoard gameBoard) {
		super.position = pos;
		super.setPlayerRole(role);
		super.gameBoard = gameBoard;
		super.setNormal(true);
	}

	@Override
	public ArrayList<Position> calculatingMoves(){
		ArrayList<Position> allowedMoves = new ArrayList<>();
		if(super.getNormal()) {
			if (gameBoard.canGo(this, new Position(this.getPosition().getRow() - 1, this.getPosition().getCol())))
				allowedMoves.add(new Position(this.getPosition().getRow() - 1, this.getPosition().getCol()));
			if (gameBoard.canGo(this, new Position(this.getPosition().getRow() - 1, this.getPosition().getCol() - 1)))
				allowedMoves.add(new Position(this.getPosition().getRow() - 1, this.getPosition().getCol() - 1));
			if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() - 1)))
				allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() - 1));
			if (gameBoard.canGo(this, new Position(this.getPosition().getRow() + 1, this.getPosition().getCol())))
				allowedMoves.add(new Position(this.getPosition().getRow() + 1, this.getPosition().getCol()));
			if (gameBoard.canGo(this, new Position(this.getPosition().getRow() + 1, this.getPosition().getCol() + 1)))
				allowedMoves.add(new Position(this.getPosition().getRow() + 1, this.getPosition().getCol() + 1));
			if (gameBoard.canGo(this, new Position(this.getPosition().getRow(), this.getPosition().getCol() + 1)))
				allowedMoves.add(new Position(this.getPosition().getRow(), this.getPosition().getCol() + 1));
			if (gameBoard.canGo(this, new Position(this.getPosition().getRow() - 1, this.getPosition().getCol() + 1)))
				allowedMoves.add(new Position(this.getPosition().getRow() - 1, this.getPosition().getCol() + 1));
			if (gameBoard.canGo(this, new Position(this.getPosition().getRow() + 1, this.getPosition().getCol() - 1)))
				allowedMoves.add(new Position(this.getPosition().getRow() + 1, this.getPosition().getCol() - 1));
		}
		else{
			System.out.println("king cannot be upgraded");
			System.exit(0);
		}
		return allowedMoves;
	}

	@Override
	public String toString() {
		return "Ki";
	}
	@Override
	public Object clone(){
		ChessMen chessMen = new King(super.position,getPlayerRole(),gameBoard);
		chessMen.setNormal(getNormal());
		return chessMen;
	}
}
