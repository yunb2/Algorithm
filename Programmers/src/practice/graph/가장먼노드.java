package practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

	public static void main(String[] args) {
		
		int n = 6;
		int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		
		int answer = solution(n, edge);
		
		System.out.println(answer);
		
	}
	
	public static int solution(int n, int[][] edge) {
        
		int answer = 0;
		boolean[] visit  = new boolean[n+1];
		boolean[][] table = new boolean[n+1][n+1];
		
		for(int[] line : edge) table[line[0]][line[1]] = table[line[1]][line[0]] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visit[1] = true;
		
		while(!q.isEmpty()) {
			
			answer = q.size();
			
			for(int i=0; i<answer; ++i) {
				
				int cur = q.poll();
				
				for(int nxt=1; nxt<=n; ++nxt) {
					
					if(visit[nxt]) continue;
					
					if(!table[cur][nxt]) continue;
					
					q.offer(nxt);
					visit[nxt] = true;
					
				}
				
			}
			
		}
		
        return answer;
        
    }
	
}
