import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14852 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] D = new long[N+1];
		
		D[0] = 1; 
		D[1] = 2;
		
		long sum = D[0]+D[1];
		final int MOD = 1000000007;
		
		for(int n=2; n<=N; ++n) {
			D[n] = (2*sum + D[n-2])%MOD;
			sum+=D[n];
		}
		
		System.out.println(D[N]);
		
	}
	
}
