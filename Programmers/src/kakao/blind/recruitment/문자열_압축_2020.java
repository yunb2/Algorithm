package kakao.blind.recruitment;

public class 문자열_압축_2020 {

	public static void main(String[] args) {
		
		String[] str = {
				"aabbaccc",
				"ababcdcdababcdcd",
				"abcabcdede",
				"abcabcabcabcdededededede",
				"xababcdcdababcdcd"
		};
		
//		for(String s : str) System.out.println(solution(s));
		System.out.println(solution(str[4]));
	}
	
	public static int solution(String s) {
		
		int answer = s.length();
		
		for(int len=answer/2; len>0; --len) {
			
			StringBuilder sb = new StringBuilder();
			int start = 0;
			int cnt = 1;
			String s1 = "";
			
			while(start<=s.length()-2*len) {
				
				s1 = s.substring(start, start+len);
				cnt = 1;
				
				for(int next=start+len; next<=s.length()-len; next+=len) {
					
					String s2 = s.substring(next, next+len);
					
					if(s1.equals(s2)) { cnt++; continue; }
					
					if(cnt>1) {
						start = next-1;
						sb.append(cnt+s1);
					}else {
						sb.append(s1.charAt(0));
					}
					break;
				}
				start++;
			}
			
			if(cnt>1) sb.append(cnt+s1);
			else sb.append(s.substring(start));
			
			System.out.println(sb.toString());
			answer = (answer>sb.length())? sb.length() : answer;
			
		}
		
		return answer;
	}
	
	public static boolean isEqual(String s1, String s2) {
		return s1.equals(s2);
	}
	
}
