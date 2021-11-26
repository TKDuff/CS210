import java.util.Scanner;
public class LabW07 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
			
		int length = in.nextInt(); //How many commands
		theStack myStack = new theStack(length);
		
		for(int i = 0; i <= length; i++) {
			String command = in.nextLine();
			if(command.split(" ")[0].equals("PUSH")) { //if PUSH command
				myStack.push(Integer.parseInt(command.split(" ")[1])); //push integer past of command
			} else if(command.split(" ")[0].equals("POP")) {
				myStack.pop();
			} else if (command.split(" ")[0].equals("POP") && myStack.isEmpty()) { //if pop on empty stack
				
			}
			
			}
		System.out.println(myStack.peek());
		}

}

class theStack{
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public theStack(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	
	public void push(long j) {
		top++;
		stackArray[top] = j;   // increment top, insert item​
	}
	
	public long pop() {
		return stackArray[top--]; //access item, decrement top​
	}
	
	public long peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() { //true if stack empty
		return (top == -1);
	}
}
