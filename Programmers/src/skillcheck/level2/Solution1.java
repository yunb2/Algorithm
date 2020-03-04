package skillcheck.level2;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

	public static void main(String[] args) {
		
		
		
	}
	
	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        
        int index = 1, cnt = 1;
        String start = null;
        for(String w : words) {
        	
        	if(start!=null && (!w.startsWith(start) || set.contains(w))) {
        		answer[0] = index;
        		answer[1] = cnt;
        		break;
        	}
        	
        	set.add(w);
        	start = w.charAt(w.length()-1)+"";
        	if(++index > n) {
        		index = 1;
        		cnt++;
        	}
        }
        
        return answer;
    }
	
}
