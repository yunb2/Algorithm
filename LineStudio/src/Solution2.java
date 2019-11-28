public class Solution2 {


	public static void main(String[] args) {
		
		System.out.println(solution("2{b3{ab}1{tc}}"));
		
	}
	
	public static int index = 0, open = 0;
	
	public static String solution(String ecryptedString) {

		try {
			
			StringBuilder sb = new StringBuilder();
			StringBuilder num = new StringBuilder();
			int cnt = 0;
			
			while(index<ecryptedString.length()) {
				char c = ecryptedString.charAt(index++);
				int ascii = (int)c;
				
				if(c=='{') {
					
					open++;
					
					String s = solution(ecryptedString);
					
					if(s.equals("ERROR")) return "ERROR";
					if(num.toString().equals("")) return "ERROR";
					
					cnt = Integer.parseInt(num.toString());
					if(cnt<1 || cnt>99) return "ERROR";
					
					num.delete(0, num.length());
					
					for(int i=0; i<cnt; ++i) sb.append(s);
					
				}else if(c=='}') {
					open--;
					return sb.toString().equals("")? "ERROR" : sb.toString();
				}else if(ascii>=48 && ascii<=57) {
					num.append(c);
				}else if(ascii>=97 && ascii<=122){
					sb.append(c);
				}else return "ERROR";
				
			}
			
			return (open!=0)? "ERROR" : sb.toString();
			
		} catch(Exception e) {
			return "ERROR";
		}
		
	}
	
}
