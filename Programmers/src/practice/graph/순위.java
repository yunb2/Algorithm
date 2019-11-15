package practice.graph;

public class ¼øÀ§ {

	public static void main(String[] args) {
		
		int n = 5;
		int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		
		int answer = solution(n, results);
		
		System.out.println(answer);
		
	}
	
	public static int solution(int n, int[][] results) {
		
		int[][] adj = new int[n][n];

		for(int[] result : results) adj[result[0]-1][result[1]-1] = 1;
		
		for(int k=0; k<n; ++k) {
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j) {
					
					if(i==j) continue;
					
					if(adj[i][k]>0 && adj[k][j]>0) adj[i][j] = 1; 
					
				}
			}
		}

		int answer = 0;
		
		for(int i=0; i<n; ++i) {
			int sum = 0;
			for(int j=0; j<n; ++j) sum += (adj[i][j]+adj[j][i]);
			if(sum==n-1) answer++;
		}
		
        return answer;
        
    }
	
}
