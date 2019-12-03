public class Solution2_refactoring {

	public static int index = 0, open = 0;

	public static void main(String[] args) {
		
		System.out.println(solution("2{b3{ab}1{tc}}"));
		index = 0; open = 0;
		System.out.println(solution("a1{abc}"));
		index = 0; open = 0;
		System.out.println(solution("2{3{ab}2{d}}"));
		index = 0; open = 0;
		System.out.println(solution("abcd"));
		index = 0; open = 0;
		System.out.println(solution("abd2{ab}"));
		
	}
	
	public static String solution(String ecryptedString) {

		try {
			
			StringBuilder decryptedString = new StringBuilder();
			StringBuilder strCnt = new StringBuilder();
			int intCnt = 0;
			
			while(index<ecryptedString.length()) {
				char c = ecryptedString.charAt(index++);
				int ascii = (int)c;
				
				if(c=='{') {
					
					open++;
					
					String s = solution(ecryptedString);
					
					if(s.equals("ERROR")) return "ERROR";
					if(strCnt.toString().equals("")) return "ERROR";
					
					intCnt = Integer.parseInt(strCnt.toString());
					if(intCnt<1 || intCnt>99) return "ERROR";
					
					strCnt.delete(0, strCnt.length());
					
					for(int i=0; i<intCnt; ++i) decryptedString.append(s);
					
				}else if(c=='}') {
					open--;
					return decryptedString.toString().equals("")? "ERROR" : decryptedString.toString();
				}else if(ascii>=48 && ascii<=57) {
					strCnt.append(c);
				}else if(ascii>=97 && ascii<=122){
					decryptedString.append(c);
				}else return "ERROR";
				
			}
			
			return (open!=0)? "ERROR" : decryptedString.toString();
			
		} catch(Exception e) {
			return "ERROR";
		}
		
	}
	
}
