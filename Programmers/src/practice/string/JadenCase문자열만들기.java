package practice.string;

public class JadenCase문자열만들기 {

	public static void main(String[] args) {
	
		System.out.println(solution("1a 2bB"));
		System.out.println(solution("3people unFollowed me "));
		System.out.println(solution("for the last week"));
		
	}

	public static String solution(String s) {
		StringBuilder answer = new StringBuilder();
        String[] chs = s.toLowerCase().split("");
        boolean isInitial = true;

        for(String ch : chs) {
        	answer.append((isInitial)? ch.toUpperCase() : ch);
            isInitial = ch.equals(" ") ? true : false;
        }

        return answer.toString();
	}
	
//	public static String solution(String s) {
//		StringBuilder answer = new StringBuilder();
//		String[] words = s.split(" ");
//		
//		for(int i=0; i<words.length; ++i) {
//			for(int j=0; j<words[i].length(); ++j) {
//				char ch = words[i].charAt(j);
//				if(j==0 && ch>='a' && ch<='z') {
//					ch = Character.toUpperCase(ch);
//				}else if(j>0 && ch>='A' && ch<='Z') {
//					ch = Character.toLowerCase(ch);
//				}
//				answer.append(ch);
//			}
//			if(i==words.length-1 && s.charAt(s.length()-1)!=' ') break;
//			answer.append(" ");
//		}
//		
//		return answer.toString();
//	}
	
}
