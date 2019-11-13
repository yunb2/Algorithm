import java.util.Stack;

public class Solution1 {

	public static void main(String[] args) {
		int[][] board = {
							{0,0,0,0,0},
							{0,0,1,0,3},
							{0,2,5,0,1},
							{4,2,4,4,2},
							{3,5,1,3,1}
						};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		int answer = solution(board, moves);
		
		System.out.println(answer);
	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<moves.length; ++i) {
        	
        	int index = moves[i]-1;
        	
        	for(int j=0; j<board.length; ++j) {
        		
        		if(board[j][index]==0) continue;
        		
        		int doll = board[j][index];
        		board[j][index] = 0;
        		
        		if(!stack.isEmpty()&&stack.peek()==doll) {
        			stack.pop();
        			answer+=2;
        			break;
        		}
        		
        		stack.push(doll);
        		break;
        		
        	}
        	
        }
        
        return answer;
    }
	
}
