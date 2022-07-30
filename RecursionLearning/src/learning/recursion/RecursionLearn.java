package learning.recursion;

public class RecursionLearn {
	public static void main(String[] args) {
		
		int a = 0, b = 1;
		System.out.println(a);
		System.out.println(b);
		
		int n = 7; // number of terms to be printed
		
		printFib(a, b, n-2);
		
	}
	
	public static void printFib(int a, int b, int n) {
		
		if(n == 0) return;
		
		int c = a+b;
		
		System.out.println(c);
		printFib(b, c, n-1);
		
	}
	
}
