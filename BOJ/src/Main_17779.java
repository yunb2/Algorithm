import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17779 {

	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; ++i) {
			String[] str = br.readLine().split(" ");
			for(int j=1; j<=N; ++j) {
				map[i][j] = Integer.parseInt(str[j-1]);
			}
		}

		int min = Integer.MAX_VALUE;
		
		for(int r=1; r<=N; ++r) {
			for(int c=1; c<=N; ++c) {
				
				for(int d1=1; d1<N ; ++d1) {
					for(int d2=1; d2<N; ++d2) {
						
						if((r+d1+d2>N)||(c-d1<1)||(c+d2>N)) continue;
						
						int diff = cal(r,c,d1,d2);
						
						if(diff<min) {
							min = diff;
						}
						
					}
				}
				
			}
		}
		
		System.out.println(min);
		
	}
	
	public static int cal(int r, int c, int d1, int d2) {

		int[] arr = new int[5];
		
		for(int i=1; i<=N; ++i) {
			for(int j=1; j<=N; ++j) {
				
				if((i<r+d1) && (j<=c) && (i+j<r+c)) {
					arr[0] += map[i][j];
				} else if((i<=r+d2) && (j>c) && (i-j < r-c)) {
					arr[1] += map[i][j];
				} else if((i>=r+d1) && (j<c-d1+d2) && (i-j > r-c+2*d1)) {
					arr[2] += map[i][j];
				} else if((i>r+d2) && (j>=c-d1+d2) && (i+j > r+c+2*d2)) {
					arr[3] += map[i][j];
				} else {
					arr[4] += map[i][j];
				}
				
			}
		}

		int max = 0, min = Integer.MAX_VALUE;
		
		for(int i=0; i<5; ++i) {
			if(arr[i]>max) max = arr[i];
			if(arr[i]<min) min = arr[i];
		}
		
		return max-min;
	}
	
	public static void print() {
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
