import java.util.Stack;

public class Solution4 {

	public static void main(String[] args) {
		
		System.out.println(solution(new int[] {5, 3, 1, -1, -1}));
		
	}
	
	public static int temp = 0;
	
	public static int solution(int[] inputList) {
        
		int cur = 0;
		boolean flag = false;
        Stack<Integer> stack = new Stack<>();
        stack.push(cur);
		for(int cnt : inputList) {
			
			if(cur == 5 || cur == 10) flag = true;
			
			if(cnt<0) {
				stack.pop();
				cur = stack.peek();
			}
			
			for(int i=0; i<cnt; ++i) {
				cur = go(cur, flag);
				stack.push(cur);
			}
			
			flag = false;
			if(cur==0) break;
		}
		
        return cur;
        
    }
	
	public static int go(int cur, boolean flag) {
		
		int next = cur;
		
		switch(cur) {
		case 5:
			next = flag? 20 : 6;
			break;
		case 10:
			next = flag? 25 : 11;
			break;
		case 19:case 28:
			next = 0;
			break;
		case 22:
			next = 27;
			break;
		case 26:
			next = 22;
			break;
		default:
			next = cur+1;
			break;
		}
		
		return next;
		
	}
	
}
