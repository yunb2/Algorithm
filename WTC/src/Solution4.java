import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {

	public static void main(String[] args) {
		
		String[] infos = {"kim password", "lee abc"};
		String[] actions = {
							    "ADD 30", 
							    "LOGIN kim abc", 
							    "LOGIN lee password", 
							    "LOGIN kim password", 
							    "LOGIN kim password", 
							    "ADD 30", 
							    "ORDER",
							    "ORDER",
							    "ADD 40",
							    "ADD 50"
							};
		
		boolean[] answer = solution(infos, actions);
		
		System.out.println(Arrays.toString(answer));
		
	}
	
	public static boolean[] solution(String[] infos, String[] actions) {
        boolean[] answer = new boolean[actions.length];
        
        boolean isLogin = false;
        List<String> cart = new LinkedList<>();
        
        for(int i=0; i<actions.length; ++i) {
        	
        	String[] parsedAction = actions[i].split(" ");
        	String command = parsedAction[0];
        	
        	switch(command) {
        	case "ADD":
        		
        		if(!isLogin) break;
        		
        		cart.add(parsedAction[1]);
        		answer[i] = true;
        		
        		break;
        		
        	case "LOGIN":
        		
        		if(isLogin) break;
        		
        		String loginInfo = parsedAction[1]+" "+parsedAction[2];
        		for(String info : infos) {
        			
        			if(!loginInfo.equals(info)) continue;
        			
        			isLogin = true;
    				answer[i] = true;
    				
    				break;
    				
        		}
        		
        		break;
        		
        	case "ORDER":
        		
        		if(cart.isEmpty()) break;
        		
        		answer[i] = true;
        		cart.clear();
        		
        		break;
        	}
        	
        	
        }
        
        return answer;
    }
	
}
