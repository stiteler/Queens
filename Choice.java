/**
 * Choice is a data object that contains information about a given Queen
 * placement (row and column). Additionally, a conflictedWith() method that
 * allows a choice to check itself vs another for conflicts
 * 
 * @author Chris Stiteler
 * 
 */
public class Choice {
	private int row;
	private int col;

	// simple constructor
	public Choice(int row, int col) {
		this.row = row;
		this.col = col;
	}

	// conflictedWith() allows a choice to determine if it can capture
	// an given choice (that). Returns true if Queens can capture eachother
	public boolean conflictedWith(Choice that) {
		// check diagonal conflict
		boolean conflictsDiag = true;
		int rowDiff = Math.abs(this.row - that.getRow());
		int colDiff = Math.abs(this.col - that.getCol());
		if (rowDiff != colDiff) {
			conflictsDiag = false;
		}

		// check row conflict
		boolean conflictsRow = true;
		if (that.getRow() != this.row) {
			conflictsRow = false;
		}
		
		// check column conflict
		boolean conflictsCol = true;
		if (that.getCol() != this.col) {
			conflictsCol = false;
		}

		return (conflictsDiag || conflictsRow || conflictsCol);
	}

	// Setters and Getters:
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
