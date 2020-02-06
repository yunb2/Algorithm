
public class Solution2 {

	public static void main(String[] args) {
		System.out.println(solution(2322));
	}
	
	public static int solution(long n) {
		int answer = 0;
		boolean[] check = new boolean[10];
		char[] nChars = Long.toString(n).toCharArray();
		
		for(int i=0; i<nChars.length; ++i) {
			int mod = Integer.parseInt(nChars[i]+"");
			if(mod==0 || check[mod]) continue;
			check[mod] = true;
			if(n%mod==0) answer++;
		}
		
		return answer;
	}
	
}
