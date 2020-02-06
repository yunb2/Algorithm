public class Solution4 {

	public static void main(String[] args) {
		System.out.println(solution(2,2));
		System.out.println(solution(3,2));
	}

	public static final int MOD = 10007;
	public static boolean[] checkCol;
	public static int total;
	
	public static int solution(int n, int k) {
		if(k>n) return 0;
		
		checkCol = new boolean[n];
		
		for(int r=0; r<n; ++r) {
			for(int c=0; c<n; ++c) {
				play(r,c,n,k,0);
			}
		}
		
		return total;
	}
	
	public static void play(int row, int col, int n, int k, int cnt) {
		
		if(k==cnt) {
			total = (total+1)%MOD;
			return;
		}
		
		if(checkCol[col]) return;
		checkCol[col] = true;
		
		for(int r=row+1; r<n; ++r) {
			for(int c=0; c<n; ++c) {
				play(r,c,n,k,cnt+1);
			}
		}
		
		checkCol[col] = false;
		
	}
	
}
