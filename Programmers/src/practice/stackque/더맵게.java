package practice.stackque;

import java.util.PriorityQueue;

public class 더맵게 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,9,10,12}, 7));
	}
	
	public static int solution(int[] scoville, int K) {
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<scoville.length; ++i) q.offer(scoville[i]);
		
		int answer = 0;
		while(q.size()>1 && q.peek()<K) {
			q.offer(q.poll() + q.poll()*2);
			answer++;
		}
		
		return (q.peek()>=K)? answer : -1;
		
	}
	
}
