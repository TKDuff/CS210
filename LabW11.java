import java.util.Scanner;

/*
Sort a list of words by the total sum of their ASCII values for each character in the word. The words printed first will be 
this with the lowest ASCII sum.
For words of the exact same ASCII sum (e.g "dog" and "god") these should be sorted reverse alphabetically  (so "god" would come before "dog")

{"this","dog","is","thomas","god","hotmas","test"} -> {"is","god","dog","this","test","thomas","hotmas"}
*/

public class LabW11 {
	
	public static String[] words;
	public static String[] wordSpace;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the amount of words: ");
		int n = Integer.parseInt(in.nextLine());;

		words = new String[n];
		wordSpace = new String[n];
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter word: " + i);
			words[i] = in.nextLine();
		}
		
		mergeSort(0, words.length-1);
		
		for(int i = n-1; i >= 0; i--) {
			System.out.println(words[i] + " " + words[i].chars().sum());
		}
	} 
	
	public static void mergeSort(int left, int right) {
		int mid = (left + right)/2;
		if(left == right)
			return;
		
		mergeSort(left, mid);
		mergeSort(mid+1, right);
		for(int i=left; i<=right;i++) {
			wordSpace[i] = words[i];
		}
		int i1 = left;
		int i2 = mid+1;
		
		for(int c = left; c<= right; c++) {
			if(i1 > mid) {
				words[c] = wordSpace[i2];
				i2++;
			} else if(i2 > right) {
				words[c] = wordSpace[i1];
				i1++;
			} else if(wordSpace[i1].chars().sum() > wordSpace[i2].chars().sum()){
				words[c] = wordSpace[i1];
				i1++;
			} else if(wordSpace[i1].chars().sum() < wordSpace[i2].chars().sum()){
				words[c] = wordSpace[i2];
				i2++;
			} else if(wordSpace[i1].chars().sum() == wordSpace[i2].chars().sum()){
				if(wordSpace[i1].compareTo(wordSpace[i2]) < 0) {
					words[c] = wordSpace[i1];
					i1++;
				} else {
					words[c] = wordSpace[i2];
					i2++;
				}
			}
		}
	}
}
