import java.util.Random;


/**
 * 
 * @author Steaz
 * 
 */
public class Queens {
	private static final int ROWS = 8;
	private static final int COLS = 8;

	private ChoiceStack stack;

	public Queens() {
		stack = new ChoiceStack();
		solve();
	}

	private void solve() {
		// generate first choice and push onto stack
		stack.push(new Choice(1,1));
		//stack.push(makeRandomFirstChoice());

		boolean successful = false;

		// while not successful and stack is not empty
		while(!successful && !stack.isEmpty()) {
			// check the stack for capture conflicts
			boolean ok = checkChoiceStack();

			// if there are conflicts, backtrack
			if (!ok) {
					// try to move the queen over by 1 if there's space
					int topCol = stack.stackTop().getCol();
					if(topCol < COLS) {
						incrementTopColumn();
					} else { // a previous choice is preventing success
						
						// if the top column is maxed out, 
						// pop it off the stack shift previos to the right
						while(stack.stackTop().getCol() == COLS) {
							stack.pop();
						}
						incrementTopColumn();
						
					}
			} else if(stack.depth() == ROWS) {
				// if the Queens are happy and we're done, print the board.
				successful = true;
				printBoard();
			} else {
				// put a new queen on the board on the next row, first column
				Choice next = new Choice(stack.depth() + 1, 1);
				stack.push(next);
			}
		
		}
	}
	
	private void incrementTopColumn() {
		Choice topChoice = stack.stackTop();
		topChoice.setCol(topChoice.getCol() + 1);
	}

	private Choice makeRandomFirstChoice() {
		// initial row choices can be random, but columns should be 1 for algorithm.
		Random rand = new Random();
		int choiceRow = rand.nextInt(ROWS) + 1;

		return new Choice(choiceRow, 1);
	}

	private boolean checkChoiceStack() {
		Choice top = stack.stackTop();

		// check most recent choice vs all other choices for capture
		for (int i = 0; i < stack.depth() - 1; i++) {
			if (top.conflictedWith(stack.get(i))) {
				return false;
			}
		}

		return true;
	}

	private void printBoard() {
		// populate a 2D array of bools to rep. where Queens are placed on board
		boolean[][] view = new boolean[ROWS][COLS];
		for (int i = 0; i < stack.capacity(); i++) {
			Choice c = stack.get(i);

			if (c != null) {
				view[c.getRow() - 1][c.getCol() - 1] = true;
			}
		}

		// border template string
		String border = "+---+---+---+---+---+---+---+---+";

		// every row, print a border, new line, and if the view expects
		// a queen for a given row/col, print a Q.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ROWS; i++) {
			sb.append(border + "\n");
			for (int j = 0; j < COLS; j++) {
				if (j == 0) {
					sb.append("| ");
				} else {
					sb.append(" ");
				}
				if (view[i][j]) {
					sb.append("Q");
				} else {
					sb.append(" ");
				}
				sb.append(" |");
			}
			sb.append("\n");
		}
		sb.append(border);
		System.out.println(sb.toString());
	}
}
