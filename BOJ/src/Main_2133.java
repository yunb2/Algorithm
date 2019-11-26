import java.util.Scanner;

public class Main_2133 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] D = new int[N+1];
		D[0] = 1;
		if(N>1) D[2] = 3;
		
		for(int i=3; i<=N; i++) {
			D[i] = 3*D[i-2];
			for(int j=i-4; j>=0; j-=2) {
				D[i] += 2*D[j];
			}
		}
		
		System.out.println(D[N]);
		
	}
	
}
