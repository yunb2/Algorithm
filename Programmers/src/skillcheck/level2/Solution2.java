package skillcheck.level2;

import java.util.PriorityQueue;

public class Solution2 {

	public static void main(String[] args) {
		
		System.out.println(solution("FRANCE", "french"));
		
	}
	
	public static int solution(String str1, String str2) {
		PriorityQueue<String> q1 = setQueue(str1);
		PriorityQueue<String> q2 = setQueue(str2);
		
		if(q1.isEmpty() && q2.isEmpty()) return 65536;
		
		double inter = 0, union = 0;
		
		while(!q1.isEmpty() && !q2.isEmpty()) {
			String s1 = q1.poll();
			String s2 = q2.poll();
			
			int cmp = s1.compareTo(s2);
			
			if(cmp == 0) {
				inter++; 
				union++;
				continue;
			}

			if(cmp < 0) q2.offer(s2);
			else 		q1.offer(s1);
			union++;
		}
		
		union += (q1.size()+q2.size());
		
		return (int)((inter/union)*65536);
	}
	
	public static PriorityQueue<String> setQueue(String str) {
		
		PriorityQueue<String> q = new PriorityQueue<>();
		
		for(int i=0; i<str.length()-1; ++i) {

			String substr = str.substring(i, i+2);
			
			if(!substr.matches("^[a-zA-Z]*$")) continue;
				
			q.add(substr.toUpperCase());
		}
		
		return q;
	}
	
}
