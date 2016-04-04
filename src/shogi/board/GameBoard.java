package shogi.board;
import shogi.piece.ChessMen;
import shogi.piece.Lance;

/**
 * @author sina
 * @version 1.0.0
 */
public class GameBoard {
	ChessMen[][] table;

	public GameBoard() {
		this.table = new ChessMen[9][9];
		putPieces();
	}

	private void putPieces(){
	}

	public boolean canGo(ChessMen chessMen, Position position){
		if (table[position.getRow()][position.getCol()] == null && position.isAvailable())
			return true;
		else if (table[position.getRow()][position.getCol()].getPlayerRole() != chessMen.getPlayerRole()&& position.isAvailable())
			return true;
		else
			return false;
	}
}