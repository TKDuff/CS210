import java.util.Scanner;

public class LabW10 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Select which function recursive function to pick: ");
		int question = in.nextInt();
		long param1;
		double param2;
		double param3;
		
		switch(question) {
		case 1:
			param1 = in.nextInt();
			System.out.println(function1(param1));
			break;
		case 2:
			System.out.println("Enter the number of years");
			param1 = in.nextInt();
			System.out.println("Enter the bank balance");
			param2 = in.nextDouble();
			System.out.println("Enter the interest rate");
			param3 = 1+in.nextDouble()/100;
			System.out.println(String.format( "%.2f", function2(param1, param2, param3)));
			break;
		case 3:
			param1 = in.nextInt();
			System.out.println(String.format( "%.3f", (1-function3(param1))));	
			break;
		default:
			System.out.println("Wrong input or something");
		}
	
	}
	
	/*
	 * Write recursive method computes output of following function
	 * f(n) = 2 if n = 1
	 * f(n) = 4*f(n-1) - 3*n if n > 1
	*/
	public static long function1(long n) {
		if(n==1) {
			return 2;
		}
		return 4*function1(n-1) - 3*n;
	}
	
	/* function 2
	 * Write recursive method, takes balance, interest rate, number of years and
	 * output how much bank account will be worth after inputed years 
	*/
	public static double function2(long y,double amount, double inte) {	
		if(y==1) {
			return amount * inte;
		}
		return function2(y-1, amount, inte) * inte;
	}
	
	/* function 3
	* Write recursive method that finds probability that in a class of n people
	* some pair of them will have the same birthday
	*/
	public static double function3(long n) {
		if(n<=1){
            return 1;
        } 
        float number = (365-(n-1));
        float value = number/365;
        return (value*function3(n-1));
    }
	
}
