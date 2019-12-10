package practice.stackque;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 기능개발 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {93,30,55}, new int[] {1,30,5})));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		
		int[] days = new int[progresses.length];
		for(int i=0; i<progresses.length; ++i) {
			days[i] = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
		}

		List<Integer> list = new LinkedList<>();
		int cnt = 1, day = days[0];
		for(int i=1; i<progresses.length; ++i) {
			if(days[i]>day) {
				list.add(cnt);
				day = days[i];
				cnt = 1;
			}else {
				cnt++;
			}
		}
		list.add(cnt);
		
		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); ++i) answer[i] = list.get(i);
		
		return answer;
	}
	
}