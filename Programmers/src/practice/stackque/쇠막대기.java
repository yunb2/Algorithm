package practice.stackque;

public class 쇠막대기 {

	public static void main(String[] args) {
		
		String arrangement = "()(((()())(())()))(())";
		
		System.out.println(solution(arrangement));
		
	}
	
	public static int solution(String arrangement) {
		int answer = 0, open = 0;
		boolean isLaser = false;
		
		for(int i=0; i<arrangement.length(); ++i) {
			char bracket = arrangement.charAt(i);
			if(bracket == '(') {
				open++;
				isLaser = true;
			}else if(isLaser) {
				answer += (--open);
				isLaser = false;
			}else {
				open--;
				answer++;
			}
		}
		
		return answer;
	}
	
}
