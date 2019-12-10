package practice.stackque;

import java.util.Arrays;

public class 주식가격 {

	public static void main(String[] args) {
		
		int[] prices = {1, 2, 3, 2, 3};
		
		System.out.println(Arrays.toString(solution(prices)));
		
	}
	
	public static int[] solution(int[] prices) {
		
		int len = prices.length;
		int[] answer = new int[len];
		
		for(int i=0; i<len-1; ++i) {
			for(int j=i+1; j<len; ++j) {
				
				answer[i] = j-i;
				
				if(prices[i]>prices[j]) break;
				
			}
		}
		
		return answer;
		
	}
	
}
