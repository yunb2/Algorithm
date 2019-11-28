import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10808 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		char[] S = br.readLine().toCharArray();
		
		int[] cnt = new int[26];
		
		for(char c : S) cnt[(int)(c-'a')]++;
		
		for(int c : cnt) System.out.print(c+" ");
		
	}
	
}
