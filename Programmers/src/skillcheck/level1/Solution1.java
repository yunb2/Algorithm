package skillcheck.level1;

public class Solution1 {

	public static void main(String[] args) {
		
		
		
	}
	
	static boolean solution(String s) {
        int p=0, y=0;
        
        for(char c : s.toCharArray()) {
        	if(c=='p'||c=='P') p++;
        	else if(c=='y'||c=='Y') y++;
        }
        
        return p==y;
    }
	
}
