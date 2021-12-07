import java.util.Scanner;

public class LabW11 {
	
	public static long[] array;
	public static String[] words;
	public static long[] workSpace;
	public static String[] wordSpace;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = 5;
		
		words = new String[n];
		array = new long[n];
		workSpace = new long[n];
		wordSpace = new String[n];
		
		for(int i = 0; i < 5; i++) {
			words[i] = in.nextLine();
			array[i] = words[i].chars().sum();
			System.out.println(array[i]);
		}
		
		mergeSort(0, array.length-1);
		
		for(int i = array.length-1; i >= 0; i--) {
			System.out.print(words[i] + ", ");
		}
	}
	
	public static void mergeSort(int left, int right) {
		int mid = (left + right)/2;
		if(left == right)
			return;
		
		mergeSort(left, mid);
		mergeSort(mid+1, right);
		for(int i=left; i<=right;i++) {
			workSpace[i] = array[i];
			wordSpace[i] = words[i];
		}
		int i1 = left;
		int i2 = mid+1;
		
		for(int c = left; c<= right; c++) {
			if(i1 > mid) {
				array[c] = workSpace[i2];
				words[c] = wordSpace[i2];
				i2++;
			} else if(i2 > right) {
				array[c] = workSpace[i1];
				words[c] = wordSpace[i1];
				i1++;
			} else if(workSpace[i1]>workSpace[i2]){
				//System.out.println("top " + wordSpace[i1] + " > " + wordSpace[i2] + "   " + wordSpace[c] + " swapped with " + wordSpace[i1]);
				array[c]=workSpace[i1];
				words[c] = wordSpace[i1];
				i1++;
			} else {
				//System.out.println("bottom " + wordSpace[i2] + " > " + wordSpace[i1] + "   " + wordSpace[c] + " swapped with " + wordSpace[i2]);
				array[c] = workSpace[i2];
				words[c] = wordSpace[i2];
				i2++;
			}
		}
	}
}