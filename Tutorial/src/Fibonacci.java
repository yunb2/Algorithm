
public class Fibonacci {

	public static int[] D;
	
	public static int fibonacci(int n) {
		if(D[n]>0) return D[n];
		if(n>2) return D[n] = fibonacci(n-1) + fibonacci(n-2);
		return 1;
	}
	
	public static void main(String[] args) {
		
		D = new int[21];
		
		System.out.println(fibonacci(20));
		
	}
	
}
