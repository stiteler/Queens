/**
 * 
 * @author Steaz
 *
 */
public class ChoiceStack {
	private int count;
	private Choice[] stack;
	private static final int ARRAY_SIZE = 8;
	
	public ChoiceStack() {
		count = 0;
		stack = new Choice[ARRAY_SIZE];
	}
	
	// stack top function
	public Choice stackTop() {
		if(isEmpty()) {
			return null;
		} else {
			return stack[count - 1];
		}
	}
	
	public void push(Choice c) {
		if(isFull()) {
			return;
		}
		stack[count++] = c;
	}
	
	public Choice pop() {
		Choice rtn = stack[count - 1];
		stack[count - 1] = null;
		count--;
		return rtn;
	}
	
	public boolean isFull() {
		return count == stack.length;
	}
	
	public int capacity() {
		return stack.length;
	}
	
	public int depth() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	//TODO REMOVE AFTER DEBUG
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int[][] view = new int[8][8];
		for (int i = 0; i < this.capacity(); i++) {
			Choice c = this.get(i);

			if (c != null) {
				view[c.getRow() - 1][c.getCol() - 1] = 1;
			}
		}
		
		for(int i = 0; i < 8; i++) {
			sb.append("\n");
			for (int j = 0; j < 8; j++) {
				sb.append("[ " + view[i][j] + " ]");
			}
		}
		return sb.toString();
	}

	
	// in order to walk the stack, an indexed get
	public Choice get(int index) {
		if(index > stack.length - 1 || index < 0) {
			return null;
		}
		
		return stack[index];
	}

}
