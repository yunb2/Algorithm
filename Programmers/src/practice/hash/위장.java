package practice.hash;

import java.util.HashMap;

public class ���� {

	public static void main(String[] args) {
		
	}
	
	public int solution(String[][] clothes) {
        
		int answer = 1;
        
		HashMap<String, Integer> map = new HashMap<>();
		
        for(String[] cloth : clothes) map.put(cloth[1], map.getOrDefault(cloth[1], 1)+1);
        for(String key : map.keySet()) answer*=map.get(key);
        
        return answer-1;
        
    }
	
}
