import java.util.Scanner;

/*
manipulate a queue according to the given insert and remove commands and then output the string that is in the middle of the queue
If there is an even number of strings in the queue, thus two middle strings, output the one which is nearest to the front.
If a remove command is issued for an empty queue then nothing should happen
*/

public class LabW08 {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	int count = 0; //determines size of qeueu array
	String input = ""; //stores inputs
	
	while(in.hasNextLine()) { 						//takes input until ide stops taking input (ctrl-d on linux eclipse)
		input = input + "+" + in.nextLine(); 				//store current input, adding + to note end
		count++; 									//increase size of array
		if(input.substring(input.length()-6, input.length()).equals("REMOVE")) { 		//check if remove command issued
			count--; 		//removing an item means the size of the array can be reduced
		}
	}
	input += "+"; //add + to end to signify end of input string
	
	Queue q = new Queue(count); //create queue using counter 
		
	//this splits large input string into separate commands
	int start = 0; 					//starting position of command
	for(int i = 0; i < input.length();i++) {	//goes through each letter
		if(input.charAt(i) == '+') {			//if letter is '+'
			String command = input.substring(start, i);	//take substring between the 2 +, "+INSERT this+" is now "INSERT this"
			start = i+1; 						//increment starting point for next command
			if(command.split(" ")[0].equals("INSERT")) { //check command instruction
				q.insert(command.split(" ")[1]);				//if insert split string to insert the word
			} else if(command.split(" ")[0].equals("REMOVE")) {//check command instruction
				q.remove();							//remove front item from queue
			}
		}
	}

	System.out.println(q.get()); //gets middle item
	}

}
	

class Queue{
	private int maxSize;
	private String[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int s) {
		maxSize = s;
		queArray = new String[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public boolean insert(String j) {
		if(isFull()) return false;
		if(rear == maxSize-1)
			rear = -1;
		rear++;
		queArray[rear] = j;
		nItems++;
		return true;
	}
	
	public String remove() {
		if(isEmpty()) return (String) null;
		String temp = queArray[front];
		front++;
		if(front == maxSize)
			front = 0;
		nItems--;
		return temp;
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	public int size() {
		return nItems;
	}
	
	public String peekFront() {
		return queArray[front];
	}
		
	public String get() {
		if(nItems == 0) {return "empty";} //if empty string return empty
		if(nItems % 2 == 0) { //if number of items is even
			return queArray[front+ (nItems/2)-1]; //divide N by 2 and subtract 1 to find the middle value
		} else {
			return queArray[front + nItems/2];//in case not even just divide by 2 to find middle value
		}
	} 
	
} 
