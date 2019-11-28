public class Solution3 {

	public static void main(String[] args) throws Exception {
	
		System.out.println(solution(new int[] {3,1,2,3,4,1,1,2}));
		
	}
	
	public static int solution(int[] hList) {
		
		int answer = 0;
		
		boolean isTop = false;
		int height = 0;
		
		while(!isTop) {
			
			isTop = true;
			int cnt = 0;
			
			for(int h : hList) {
				
				if(isTop && h-height>0) isTop = false;
				
				if(!isTop) {
					if(h-height<=0) {
						cnt++;
					}else {
						answer += cnt;
						cnt = 0;
					}
				}
				
			}
			
			height++;
		}
		
		return answer;
		
	}
	
}
