package shogi.board;
import shogi.piece.*;

/**
 * @author ahmad
 * @version 1.0.0
 */
public class GameBoard {
	ChessMen[][] table;

	public GameBoard() {
		this.table = new ChessMen[9][9];
		putPieces();
	}

	public ChessMen[][] getTable() {
		return table;
	}

	private void putPieces(){
		/**
		 * We contract out to put the white pieces at the bottom of the table(at the [8][] and [7][] indexes)
		 * and put the black pieces at the top of the table(at [0][] and [1][] indexes)
		 */
		/**
		 * L K S G K G S K L
		 * - R - - - - - B -
		 * P P P P P P P P P
		 * - - - - - - - - -
		 * - - - - - - - - -
		 * - - - - - - - - -
		 * P P P P P P P P P
		 * - B - - - - - R -
		 * L K S G K G S K L
		 */

		//  Black pieces putting
		table[0][0] = new Lance         (new Position(0,0), ChessMen.roles.PLAYER_BLACK_ROLE,this);
		table[0][1] = new Knight        (new Position(0,1), ChessMen.roles.PLAYER_BLACK_ROLE,this);
		table[0][2] = new SilverGeneral (new Position(0,2), ChessMen.roles.PLAYER_BLACK_ROLE,this);
		table[0][3] = new GoldGeneral   (new Position(0,3), ChessMen.roles.PLAYER_BLACK_ROLE,this);
		table[0][4] = new King          (new Position(0,4), ChessMen.roles.PLAYER_BLACK_ROLE,this);
		table[0][5] = new GoldGeneral   (new Position(0,5), ChessMen.roles.PLAYER_BLACK_ROLE,this);
		table[0][6] = new SilverGeneral (new Position(0,6), ChessMen.roles.PLAYER_BLACK_ROLE,this);
		table[0][7] = new Knight        (new Position(0,7), ChessMen.roles.PLAYER_BLACK_ROLE,this);
		table[0][8] = new Lance         (new Position(0,8), ChessMen.roles.PLAYER_BLACK_ROLE,this);

		table[1][1] = new Rock          (new Position(1,1), ChessMen.roles.PLAYER_BLACK_ROLE,this);
		table[1][7] = new Bishop        (new Position(1,7), ChessMen.roles.PLAYER_BLACK_ROLE,this);

		for (int i = 0; i < 9; i++)
			table[2][i] = new Pawn      (new Position(2,i), ChessMen.roles.PLAYER_BLACK_ROLE,this);

		//  White pieces putting
		table[8][0] = new Lance         (new Position(8,0), ChessMen.roles.PLAYER_WHITE_ROLE,this);
		table[8][1] = new Knight        (new Position(8,1), ChessMen.roles.PLAYER_WHITE_ROLE,this);
		table[8][2] = new SilverGeneral (new Position(8,2), ChessMen.roles.PLAYER_WHITE_ROLE,this);
		table[8][3] = new GoldGeneral   (new Position(8,3), ChessMen.roles.PLAYER_WHITE_ROLE,this);
		table[8][4] = new King          (new Position(8,4), ChessMen.roles.PLAYER_WHITE_ROLE,this);
		table[8][5] = new GoldGeneral   (new Position(8,5), ChessMen.roles.PLAYER_WHITE_ROLE,this);
		table[8][6] = new SilverGeneral (new Position(8,6), ChessMen.roles.PLAYER_WHITE_ROLE,this);
		table[8][7] = new Knight        (new Position(8,7), ChessMen.roles.PLAYER_WHITE_ROLE,this);
		table[8][8] = new Lance         (new Position(8,8), ChessMen.roles.PLAYER_WHITE_ROLE,this);

		table[7][1] = new Rock          (new Position(7,1), ChessMen.roles.PLAYER_WHITE_ROLE,this);
		table[7][7] = new Bishop        (new Position(7,7), ChessMen.roles.PLAYER_WHITE_ROLE,this);

		for (int i = 0; i < 9; i++)
			table[6][i] = new           Pawn(new Position(6,i), ChessMen.roles.PLAYER_WHITE_ROLE,this);
	}

	/**
	 * This method checks weather a chessman can go to a position or not.
	 * It is used by the chessmen classes to generate their available moves. Available moves are the moves to
	 * the empty cells and the cells filled with the opponent pieces.(To kick that piece)
	 * @param chessMen The object of the piece class
	 * @param position The target position
	 * @return  True if that cell is available and false it it is not.
	 */
	public boolean canGo(ChessMen chessMen, Position position){
		if (table[position.getRow()][position.getCol()] == null && position.isAvailable())
			return true;
		else if ((table[position.getRow()][position.getCol()].getPlayerRole() != chessMen.getPlayerRole()) && position.isAvailable())
			return true;
		else
			return false;
	}

	/**
	 * Returns the ChessMen object located in the position in the array
	 * @param position The position of the desired ChessMen objec
	 * @return The ChessMen object located in the position
	 */
	public ChessMen getChessMan(Position position){
		/**
		 * Checks whether the taken position is available(in the array range) or not
		 * If it is not so, an critical error has happened and it should be exited.
		 */
		if (position.isAvailable()){
			return table[position.getRow()][position.getCol()];
		}else {
			System.err.println("The cell selected is not in the array range");
			System.exit(0);
			return null;
		}
	}
}