package practice.hash;

import java.util.HashSet;

public class 전화번호목록 {

	public static void main(String[] args) {
		
		String[][] phone_book = {
				{"97674223", "1195524421", "119"},
				{"123", "456", "789"},
				{"12", "123", "1235", "567", "88"}
		};
		
		boolean[] returns = {false, true, false};
		
		for(int t=0; t<3; ++t) {
			System.out.println("#"+(t+1)+" "+(solution(phone_book[t])==returns[t]));
		}
		
	}
	
	public static boolean solution(String[] phone_book) {
        
		HashSet<String> set = new HashSet<>();
		
		for(String num : phone_book) set.add(num);
		for(String num : phone_book) {
			
			StringBuilder sb = new StringBuilder();
			
			for(char c : num.toCharArray()) {
				sb.append(c);
				if(sb.length()==num.length()) break;
				if(set.contains(sb.toString())) return false;
			}
			
		}
        
		return true;
		
    }
	
}
