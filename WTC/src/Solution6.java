import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution6 {

	public static void main(String[] args) {

		String[][] forms = { 
								{"jm@email.com", "¡¶¿Ãø•"}, 
								{"jason@email.com", "¡¶¿ÃΩº"}, 
								{"woniee@email.com", "øˆ¥œ"}, 
								{"mj@email.com", "ø•¡¶¿Ã"}, 
								{"nowm@email.com", "¿Ã¡¶ø•"} 
						   };
		
		String[] answer = solution(forms);
		
		System.out.println(Arrays.toString(answer));
		
	}
	
	public static String[] solution(String[][] forms) {
        List<String> answer = new LinkedList<>();
  	      
        for(String[] form : forms) {
        	
        	String email = form[0];
        	String nickname = form[1];
        	
        	
        	
        	
        }
        
        
        return (String[])answer.toArray();
    }

}
