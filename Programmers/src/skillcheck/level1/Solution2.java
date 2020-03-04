package skillcheck.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {

	public static void main(String[] args) {
		
	}
	
	public static int[] solution(int[] arr, int divisor) {
		Arrays.sort(arr);
		List<Integer> list = new LinkedList<>();
		for(int i : arr) if(i%divisor==0) list.add(i);

		int[] answer;
		if(list.isEmpty()) {
			answer = new int[1];
			answer[0] = -1;
		}else {
			answer = new int[list.size()];
			for(int i=0; i<list.size(); ++i) answer[i] = list.get(i);
		}
		
		return answer;
	}
	
}
