import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2960 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		boolean[] primeNumber = new boolean[N+1];
		
		int k = 1;
		out :
		for(int i=2; i<=N; ++i) {
			
			if(primeNumber[i]) continue;
			
			for(int j=1; i*j<=N; ++j) {
				if(primeNumber[i*j]) continue;
				primeNumber[i*j] = true;
				if(k++ == K) {
					System.out.println(i*j);
					break out;
				}
			}
		}
		
	}
	
}
