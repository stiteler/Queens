/**
 * ChoiceStack is our data structure containing our choices.
 * It is an array based stack of Choices with a method for
 * getting an index of the stack (in order to walk the stack)
 * 
 * @author Chris Stiteler
 * 
 */
public class ChoiceStack {
	private int count;
	// array backend
	private Choice[] stack;
	// stack size constant
	private static final int ARRAY_SIZE = 8;
	
	// constructor
	public ChoiceStack() {
		count = 0;
		stack = new Choice[ARRAY_SIZE];
	}
	
	// stackTop() returns the choice at the top of the stack
	// WITHOUT removing said item (not a pop).
	public Choice stackTop() {
		if(isEmpty()) {
			return null;
		} else {
			return stack[count - 1];
		}
	}
	
	// push() adds a choice to the top of the stack
	public void push(Choice c) {
		if(isFull()) {
			return;
		}
		stack[count++] = c;
	}
	
	// pop() removes a choice from the top of the stack
	public Choice pop() {
		Choice rtn = stack[count - 1];
		stack[count - 1] = null;
		count--;
		return rtn;
	}
	
	// isFull returns true if stack is full.
	public boolean isFull() {
		return count == stack.length;
	}
	
	// capacity returns the total capacity of the stack
	public int capacity() {
		return stack.length;
	}
	
	// depth returns the current count of the stack
	public int depth() {
		return count;
	}
	
	// isEmpty() returns true if stack is empty, false otherwise
	public boolean isEmpty() {
		return count == 0;
	}
	
	//toString() allows for a stack to be printed out.
	// I wrote this method solely to help visualize the stack while
	// using the debugger
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

	
	// get() returns the Choice at a given index of the stack
	// this can be used to walk the stack.
	public Choice get(int index) {
		if(index > stack.length - 1 || index < 0) {
			return null;
		}
		
		return stack[index];
	}

}
