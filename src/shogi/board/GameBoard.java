package shogi.board;

import shogi.piece.*;

import java.util.ArrayList;

/**
 * @author ahmad
 * @version 1.0.0
 */
public class GameBoard implements Cloneable {
	private ChessMen[][] table;
	private ArrayList<ChessMen> whiteKickedPieces;
	private ArrayList<ChessMen> blackKickedPieces;
	private boolean isWhiteChecked;
	private boolean isBlackChecked;
	private boolean isWhiteTurn;
	private  boolean isAttacked ;
	public GameBoard() {
		this.table = new ChessMen[9][9];
		whiteKickedPieces = new ArrayList<>();
		blackKickedPieces = new ArrayList<>();
		isWhiteChecked = false;
		isBlackChecked = false;
		isWhiteTurn = false;
		putPieces();
	}

	public boolean getWhiteCheckStatus() {
		return isWhiteChecked;
	}

	public boolean getBlackCheckStatus() {
		return isBlackChecked;
	}

	private void putPieces() {
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
		table[0][0] = new Lance(new Position(0, 0), ChessMen.roles.PLAYER_BLACK_ROLE, this);
		table[0][1] = new Knight(new Position(0, 1), ChessMen.roles.PLAYER_BLACK_ROLE, this);
		table[0][2] = new SilverGeneral(new Position(0, 2), ChessMen.roles.PLAYER_BLACK_ROLE, this);
		table[0][3] = new GoldGeneral(new Position(0, 3), ChessMen.roles.PLAYER_BLACK_ROLE, this);
		table[0][4] = new King(new Position(0, 4), ChessMen.roles.PLAYER_BLACK_ROLE, this);
		table[0][5] = new GoldGeneral(new Position(0, 5), ChessMen.roles.PLAYER_BLACK_ROLE, this);
		table[0][6] = new SilverGeneral(new Position(0, 6), ChessMen.roles.PLAYER_BLACK_ROLE, this);
		table[0][7] = new Knight(new Position(0, 7), ChessMen.roles.PLAYER_BLACK_ROLE, this);
		table[0][8] = new Lance(new Position(0, 8), ChessMen.roles.PLAYER_BLACK_ROLE, this);

		table[1][1] = new Rock(new Position(1, 1), ChessMen.roles.PLAYER_BLACK_ROLE, this);
		table[1][7] = new Bishop(new Position(1, 7), ChessMen.roles.PLAYER_BLACK_ROLE, this);

		for (int i = 0; i < 9; i++)
			table[2][i] = new Pawn(new Position(2, i), ChessMen.roles.PLAYER_BLACK_ROLE, this);

//		table[4][4] = new Rock(new Position(4, 4), ChessMen.roles.PLAYER_BLACK_ROLE, this);

		//  White pieces putting
		table[8][0] = new Lance(new Position(8, 0), ChessMen.roles.PLAYER_WHITE_ROLE, this);
		table[8][1] = new Knight(new Position(8, 1), ChessMen.roles.PLAYER_WHITE_ROLE, this);
		table[8][2] = new SilverGeneral(new Position(8, 2), ChessMen.roles.PLAYER_WHITE_ROLE, this);
		table[8][3] = new GoldGeneral(new Position(8, 3), ChessMen.roles.PLAYER_WHITE_ROLE, this);
		table[8][4] = new King(new Position(8, 4), ChessMen.roles.PLAYER_WHITE_ROLE, this);
		table[8][5] = new GoldGeneral(new Position(8, 5), ChessMen.roles.PLAYER_WHITE_ROLE, this);
		table[8][6] = new SilverGeneral(new Position(8, 6), ChessMen.roles.PLAYER_WHITE_ROLE, this);
		table[8][7] = new Knight(new Position(8, 7), ChessMen.roles.PLAYER_WHITE_ROLE, this);
		table[8][8] = new Lance(new Position(8, 8), ChessMen.roles.PLAYER_WHITE_ROLE, this);

		table[7][1] = new Rock(new Position(7, 1), ChessMen.roles.PLAYER_WHITE_ROLE, this);
		table[7][7] = new Bishop(new Position(7, 7), ChessMen.roles.PLAYER_WHITE_ROLE, this);

		for (int i = 0; i < 9; i++)
			table[6][i] = new Pawn(new Position(6, i), ChessMen.roles.PLAYER_WHITE_ROLE, this);
	}

	/**
	 * This method checks weather a chessman can go to a position or not.
	 * It is used by the chessmen classes to generate their available moves. Available moves are the moves to
	 * the empty cells and the cells filled with the opponent pieces.(To kick that piece)
	 *
	 * @param chessMen The object of the piece class
	 * @param position The target position
	 * @return True if that cell is available and false it it is not.
	 */
	public boolean canGo(ChessMen chessMen, Position position) {
		if ( position.isAvailable() && table[position.getRow()][position.getCol()] == null )
			return true;
		else if (position.isAvailable() && (table[position.getRow()][position.getCol()].getPlayerRole() != chessMen.getPlayerRole()) )
			return true;
		else
			return false;
	}

	public ChessMen[][] getTable() {
		return table;
	}

	public void move(Position source, Position target){
		if (table[target.getRow()][target.getCol()] != null) {    //  A piece shoud be kicked
			if (table[target.getRow()][target.getCol()].getPlayerRole() == ChessMen.roles.PLAYER_BLACK_ROLE) {
				table[target.getRow()][target.getCol()].setPlayerRole(ChessMen.roles.PLAYER_WHITE_ROLE);
				blackKickedPieces.add(table[target.getRow()][target.getCol()]);
			}
			else {
				table[target.getRow()][target.getCol()].setPlayerRole(ChessMen.roles.PLAYER_BLACK_ROLE);
				whiteKickedPieces.add(table[target.getRow()][target.getCol()]);
			}
		}

		table[target.getRow()][target.getCol()] = (ChessMen) table[source.getRow()][source.getCol()].clone();
		table[source.getRow()][source.getCol()] = null;
		isPlayerChecked(table[target.getRow()][target.getCol()].getPlayerRole());
		table[target.getRow()][target.getCol()].setPosition(target);
		isWhiteTurn = !isWhiteTurn;

	}

	public boolean canSelect(Position selectedPos){
		if (table[selectedPos.getRow()][selectedPos.getCol()] == null)
			return false;

		if ((table[selectedPos.getRow()][selectedPos.getCol()].getPlayerRole() == ChessMen.roles.PLAYER_BLACK_ROLE) && (isWhiteTurn == false))
			return true;
		if ((table[selectedPos.getRow()][selectedPos.getCol()].getPlayerRole() == ChessMen.roles.PLAYER_WHITE_ROLE) && (isWhiteTurn == true))
			return true;

		return false;
	}
//	public void adder(Position source , Position target){
//		if (table[target.getRow()][target.getCol()] != null) {    //  A piece shoud be kicked
//			if (table[target.getRow()][target.getCol()].getPlayerRole() == ChessMen.roles.PLAYER_BLACK_ROLE)
//				blackKickedPieces.add(table[target.getRow()][target.getCol()]);
//			else
//				whiteKickedPieces.add(table[target.getRow()][target.getCol()]);
//		}
//
//		table[target.getRow()][target.getCol()] = (ChessMen) table[source.getRow()][source.getCol()].clone();
////
//	}
//	public void remover( Position source){
//		table[source.getRow()][source.getCol()] = null;
//	//	isPlayerChecked(table[target.getRow()][target.getCol()].getPlayerRole());
//
//		isWhiteTurn = !isWhiteTurn;
//
//	}

	public ChessMen.roles getTurn(){
		if (isWhiteTurn)
			return ChessMen.roles.PLAYER_WHITE_ROLE;
		else
			return ChessMen.roles.PLAYER_BLACK_ROLE;
	}

	public boolean canMove(Position source, Position target) {
		if (!source.isAvailable())
			return false;
		if (!target.isAvailable())
			return false;
		if (table[source.getRow()][source.getCol()] == null)
			return false;
		if (table[target.getRow()][target.getCol()] != null)

			if (table[source.getRow()][source.getCol()].getPlayerRole() == table[target.getRow()][target.getCol()].getPlayerRole())
				return false;
		int index = -1;
		for (int i = 0; i < table[source.getRow()][source.getCol()].calculatingMoves().size(); i++) {
			if ((table[source.getRow()][source.getCol()].calculatingMoves().get(i).getCol() == target.getCol()) &&
					(table[source.getRow()][source.getCol()].calculatingMoves().get(i).getRow() == target.getRow()))
				index = i;
		}
		if (index == -1)
			return false;

		GameBoard gameBoard = this.clone();
		gameBoard.move(source,target);
		if (gameBoard.isPlayerChecked(gameBoard.getTable()[target.getRow()][target.getCol()].getPlayerRole()))
			return false;
		if (isWhiteTurn) {
			if (isWhiteChecked && (!gameBoard.isPlayerChecked(gameBoard.getTable()[target.getRow()][target.getCol()].getPlayerRole())))
				return true;
		}else{
			if (isBlackChecked && (!gameBoard.isPlayerChecked(gameBoard.getTable()[target.getRow()][target.getCol()].getPlayerRole())))
				return true;
		}

		return true;
	}

	public ArrayList<ChessMen> getWhiteKickedPieces() {
		return whiteKickedPieces;
	}

	public ArrayList<ChessMen> getBlackKickedPieces() {
		return blackKickedPieces;
	}

	public void setBlackKickedPieces(ArrayList<ChessMen> blackKickedPieces) {
		this.blackKickedPieces = blackKickedPieces;
	}

	/**
	 * Returns the ChessMen object located in the position in the array
	 *
	 * @param position The position of the desired ChessMen objec
	 * @return The ChessMen object located in the position
	 */
	public ChessMen getChessMan(Position position) {

		/**
		 * Checks whether the taken position is available(in the array range) or not
		 * If it is not so, an critical error has happened and it should be exited.
		 */
		if (position.isAvailable()) {
			return table[position.getRow()][position.getCol()];
		} else {
			System.err.println("The cell selected is not in the array range");
			System.exit(0);
			return null;
		}
	}

	public boolean isPlayerChecked(ChessMen.roles role) {
		boolean isChecked = false;

		Position posOfCheckedKing = new Position(-1, -1);
		//  Finding the position of the king of the player with the role role
		for (int i = 0; i < 9 * 9; i++) {
			if (table[i / 9][i % 9] != null) {
				if (table[i / 9][i % 9] instanceof King) {
					if (table[i / 9][i % 9].getPlayerRole() == role) {
						posOfCheckedKing = new Position(i / 9, i % 9);
						break;
					}
				}
			}
		}

		if ((posOfCheckedKing.getCol() == -1) && (posOfCheckedKing.getRow() == -1)) {
			System.err.println("No king is existed in the board :D");
			System.exit(-1);
		}

		for (int i = 0; i < 9 * 9; i++) {
			if (table[i / 9][i % 9] != null) {
				if (table[i / 9][i % 9].getPlayerRole() != role) {
					int index = -1;
					for (int j = 0; j < table[i / 9][i % 9].calculatingMoves().size(); j++) {
						if ((table[i / 9][i % 9].calculatingMoves().get(j).getRow() == posOfCheckedKing.getRow()) &&
								(table[i / 9][i % 9].calculatingMoves().get(j).getCol() == posOfCheckedKing.getCol()))
							index = j;
					}
					if (index != -1) {    // The piece can kick the king and it means it is checked
						isChecked = true;
						break;
					}
				}
			}
		}

		if (role == ChessMen.roles.PLAYER_BLACK_ROLE)
			isBlackChecked = true;
		if (role == ChessMen.roles.PLAYER_WHITE_ROLE)
			isWhiteChecked = true;
		return isChecked;
	}

	@Override
	protected GameBoard clone(){
		try {
			super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		GameBoard cloned = new GameBoard();
		//	Cloning array
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.table[i][j] != null){
					if (this.table[i][j] instanceof Pawn)
						cloned.table[i][j] = new Pawn(table[i][j].getPosition(),table[i][j].getPlayerRole(),this);
					else if (this.table[i][j] instanceof Rock)
						cloned.table[i][j] = new Rock(table[i][j].getPosition(),table[i][j].getPlayerRole(),this);
					else if (this.table[i][j] instanceof SilverGeneral)
						cloned.table[i][j] = new SilverGeneral(table[i][j].getPosition(),table[i][j].getPlayerRole(),this);
					else if (this.table[i][j] instanceof Lance)
						cloned.table[i][j] = new Lance(table[i][j].getPosition(),table[i][j].getPlayerRole(),this);
					else if (this.table[i][j] instanceof Knight)
						cloned.table[i][j] = new Knight(table[i][j].getPosition(),table[i][j].getPlayerRole(),this);
					else if (this.table[i][j] instanceof King)
						cloned.table[i][j] = new King(table[i][j].getPosition(),table[i][j].getPlayerRole(),this);
					else if (this.table[i][j] instanceof GoldGeneral)
						cloned.table[i][j] = new GoldGeneral(table[i][j].getPosition(),table[i][j].getPlayerRole(),this);
					else if (this.table[i][j] instanceof Bishop)
						cloned.table[i][j] = new Bishop(table[i][j].getPosition(),table[i][j].getPlayerRole(),this);
				}else
					cloned.table[i][j] = null;
			}
		}
		cloned.blackKickedPieces = (ArrayList<ChessMen>) this.blackKickedPieces.clone();
		cloned.whiteKickedPieces = (ArrayList<ChessMen>) this.whiteKickedPieces.clone();
		cloned.isBlackChecked = this.isBlackChecked;
		cloned.isWhiteChecked = this.isWhiteChecked;
		cloned.isWhiteTurn = this.isWhiteTurn;

		return cloned;
	}

	public ChessMen getWhiteKickedPieceIndex(int index) {
		System.out.println("index is \t "+ index);
		return whiteKickedPieces.get(index);
	}
	public ChessMen getBlackKickedPieceIndex(int index) {
		return blackKickedPieces.get(index);
	}
	public void setBlackKickedPiceIndex(ChessMen ch){
		this.blackKickedPieces.add(ch);
	}
	public void setWhiteKickedPieceIndex(ChessMen ch){
		this.whiteKickedPieces.add(ch);
	}
	public void setWhiteKickedPieces(ArrayList<ChessMen> whiteKickedPieces) {
		this.whiteKickedPieces = whiteKickedPieces;
	}

	public ArrayList<Position> calculatingPuts(ChessMen  ch){
		ArrayList<Position> res = new ArrayList<>();
		if ( ch.getPlayerRole() == ChessMen.roles.PLAYER_BLACK_ROLE && this.getTurn() == ChessMen.roles.PLAYER_BLACK_ROLE){
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 9; j++) {
					if( table[i][j] == null)
						res.add(new Position(i,j));


				}

			}
		}
		else if ( ch.getPlayerRole() == ChessMen.roles.PLAYER_WHITE_ROLE && this.getTurn() == ChessMen.roles.PLAYER_WHITE_ROLE){
			for (int i = 8; i > 2 ; i--) {
				for (int j = 0; j < 9; j++) {
					if ( table[i][j] == null)
						res.add(new Position(i,j));
				}

			}
		}
		return  res;

	}
	public boolean canPut(Position position, ChessMen chessMan){
		boolean isSame = false;

		for ( Position pos : this.calculatingPuts(chessMan)){
			if( pos.getRow() == position.getRow() && pos.getCol() == position.getCol()){
				isSame = true;
				break;
			}

		}
		return isSame;
	}
	public void puttingNewChessManInMap(Position position , ChessMen chessMen){
		chessMen.setPosition(position);
		table[chessMen.getPosition().getRow()][chessMen.getPosition().getCol()] =chessMen;
		isWhiteTurn = !isWhiteTurn;

	}
	public boolean canUpgrade(ChessMen chessMen){
		if( chessMen.getClass().getSimpleName().equals("GoldenGeneral") || chessMen.getClass().getSimpleName().equals("King"))return  false;
		if( chessMen.getPlayerRole() == ChessMen.roles.PLAYER_WHITE_ROLE){
			if( chessMen.getPosition().getRow() ==0 || chessMen.getPosition().getRow() == 1 || chessMen.getPosition().getRow()==2  )
				return true;
			else return false;
		}
		else if( chessMen.getPlayerRole() == ChessMen.roles.PLAYER_BLACK_ROLE){
			if ( chessMen.getPosition().getRow() == 8 || chessMen.getPosition().getRow()==7 || chessMen.getPosition().getRow()==6)
				return true;
			else return  false;
		}
		return false;


	}
	public void doUpgrade(Position position){
		ChessMen chessMen = table[position.getRow()][position.getCol()];
		chessMen.setNormal(false);
		isWhiteTurn = !isWhiteTurn;
	}
	public boolean mustUpgrade(ChessMen chessMen){
		if (chessMen.getClass().getSimpleName().equals("Pawn") || chessMen.getClass().getSimpleName().equals("Lance")){
			if( chessMen.getPlayerRole() == ChessMen.roles.PLAYER_WHITE_ROLE){
				if( chessMen.getPosition().getRow()==0) return true;
				else return false;
			}else{
				if( chessMen.getPosition().getRow()== 8) return true;
				else return false;
			}

		}else if( chessMen.getClass().getSimpleName().equals("Knight")){
			if( chessMen.getPlayerRole() == ChessMen.roles.PLAYER_WHITE_ROLE) {
				if (chessMen.getPosition().getRow() == 0 || chessMen.getPosition().getRow() == 1) return true;
				else return false;
			}else {
					if(chessMen.getPosition().getRow() == 8 || chessMen.getPosition().getRow() == 7) return  true;
					else return  false;
				}


		}
		else return  false;
	}
	@Override
	public String toString() {
		String result = new String();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (table[i][j] == null)
					result += "  ";
				else
					result += table[i][j];
			}
			result += "\n";
		}

		return result;
	}
}