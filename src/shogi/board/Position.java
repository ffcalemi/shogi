package shogi.board;

/**
 * @author ahmad
 * @version 1.0.0
 */
public class Position {

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
	public String toString() {
		return "Position{" +
				"col=" + col +
				", row=" + row +
				'}';
	}
}
