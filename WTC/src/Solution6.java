import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution6 {

	public static void main(String[] args) {

		String[][] forms = { 
								{"jm@email.com", "���̿�"}, 
								{"jason@email.com", "���̽�"}, 
								{"woniee@email.com", "����"}, 
								{"mj@email.com", "������"}, 
								{"nowm@email.com", "������"} 
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
