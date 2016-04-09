package shogi.board;


/**
 * @author ahmad
 * @version 1.0.0
 */
public class Position implements Comparable {

	public int MAX_COL_NUM = 9;
	public int MAX_ROW_NUM = 9;

	private int col;
	private int row;

	public Position(int row,int col){
		this.col = col;
		this.row = row;
	}

	public boolean isAvailable(){
		if ((col >= 0) && (col < MAX_COL_NUM) &&
				(row >= 0) && (row < MAX_ROW_NUM))
			return true;
		else
			return false;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Position){
			Position pos = (Position)o;
			if ((this.getCol() == pos.getCol()) && (this.getRow() == pos.getRow()))
				return 0;
			else
				return 1;
		}else
			return -1;

	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Position) {
			Position pos = (Position)o;
			if ((pos.getCol() == getCol()) && (pos.getRow() == getRow()))
				return true;
			else
				return false;
		} else return false;
	}
}
