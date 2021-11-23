import java.util.*;
public class LabW09 {
//have to check if linkedlist is 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int num = Integer.parseInt(in.nextLine());
		Link[] array = new Link[num];
		
		for(int i = 0; i < num; i++) {
			array[i] = new Link(Integer.parseInt(in.nextLine()));
		}
		while(in.hasNext()) {
			int select = in.nextInt();
			int previous = in.nextInt();
			int next = in.nextInt();
			if(previous != -1) {
				array[select].previous = array[previous];
			}
			if(next !=-1) {
				array[select].next=array[next];
			}
			
		}
		LinkedList myList = new LinkedList();
		
		if(num>0) {
			myList.first=array[0];
			myList.last=array[num-1];
		}
		
			System.out.println(search(myList, num));
		
		
	}

	public static int search(LinkedList myList, int num) {
		if(myList.first == myList.last || myList.isEmpty()) {
			return -1;
		} else {
		int[] array = new int[num];
		Link current = myList.first;	
		for(int i = 0; i < num; i++) {
			array[i] = current.data;
			current = current.next;
		}	
		int min;
		for(int outer = 0; outer < array.length; outer++) {
			min = outer;
			for(int i = outer+1; i < array.length; i++) {
				if(array[i] < array[min]) {
					min = i;
				}
			}
			int temp = array[outer];
			array[outer] = array[min];
			array[min] = temp;
			
		}
		return (array[1]);
		}
	}

}

class Link{
	public int data;
	public Link next;
	public Link previous;
	
	public Link(int input) {
		data = input;
		next = null;
		previous =null;
	}
}

class LinkedList{
	public Link first;
	public Link last;
	
	public LinkedList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return (first==null);
	}
	
	public void insertHead(Link insert) {
		if(isEmpty()) {
			first = insert;
			last = insert;
		} else {
			first.previous=insert;
			insert.next=first;
			first=insert;
		}
	}
} 
