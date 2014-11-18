/**
 * 
 * @author Steaz
 *
 */
public class Choice {
	private int row;
	private int col;
	
	public Choice(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public boolean conflictedWith(Choice that) {
		// returns true if Queens can capture each other
		
		// check diagonal conflict
		boolean conflictsDiag = true;
		int rowDiff = Math.abs(this.row - that.getRow());
		int colDiff = Math.abs(this.col - that.getCol());
		if(rowDiff != colDiff) {
			conflictsDiag = false;
		}
		
		// check row conflict
		boolean conflictsRow = true;
		if(that.getRow() != this.row) {
			conflictsRow = false;
		}
		// check column conflict
		boolean conflictsCol = true;
		if(that.getCol() != this.col) {
			conflictsCol = false;
		}
		
		return (conflictsDiag || conflictsRow || conflictsCol);
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
}
