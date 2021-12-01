
//Write recursive method computes output of following function
//f(n) = 2 if n = 1
//f(n) = 4*f(n-1) - 3*n if n > 1
/*
import java.util.Scanner;
public class LabW10 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println(f(68));
	}
	
	public static long f(long n) {
		if(n==1) {
			return 2;
		}
		return 4*f(n-1) - 3*n;
	}
	
}
*/

//Write recursive method, takes balance, interest rate, number of years and
//output how much bank account will be worth after inputted years
/*
import java.util.Scanner;
public class LabW10 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int y = in.nextInt();
		double inte = 1+in.nextDouble()/100;
		double amount = in.nextDouble();
		
		double awnser = (f(y, amount, inte));
		System.out.println((double)Math.round(awnser * 100)/100);	
		
	}
	public static double f(int y,double amount, double inte) {	
		if(y==1) {
			return amount * inte;
		}
		return f(y-1, amount, inte) * inte;
	}
	
}
*/


//Write recursive method that finds probability that in a class of n people
//some pair of them will have the same birthday
/*
3)
import java.util.Scanner;
public class LabW10 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println(f(3));
	}
	
	public static double f(double n) {
		if(n==1) {
			return 0;
		}
		return f(n-1) + (n-1)/365;
	}
	
}
*/