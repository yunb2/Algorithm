
public class Solution1 {

	public static void main(String[] args) {

		System.out.println(solution(3000, 5000, 23000));
		
	}

	public static int solution(int a, int b, int budget) {
		int answer = 0;
		
		for(int i=0; a*i<=budget; ++i) {
			boolean isZero = (budget-a*i)%b == 0;
			if(isZero) answer++;
		}
		
		return answer;
	}
	
}
