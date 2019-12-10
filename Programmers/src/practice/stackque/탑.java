package practice.stackque;

import java.util.Arrays;

public class 탑 {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(solution(new int[] {6,9,5,7,4})));
		System.out.println(Arrays.toString(solution(new int[] {3,9,9,3,5,7,2})));
		System.out.println(Arrays.toString(solution(new int[] {1,5,3,6,7,6,5})));
		
	}
	
	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		
		for(int i=heights.length-1; i>=0; --i) {
			for(int j=i-1; j>=0; --j) {
				
				if(heights[i]>=heights[j]) continue;
				
				answer[i] = j+1;
				break;
				
			}
		}
		
		return answer;
	}
	
}
