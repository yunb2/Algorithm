import java.util.HashMap;

public class Solution3 {

	public static void main(String args[]){
	
	
	    
	    
	}
	
	public String solution(int n, int m, int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int total = factorial((n+m), map)/(factorial(n,map)*factorial(m,map));
		
		if(total<k) return "";
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; ++i ) sb.append('(');
		for(int i=0; i<m; ++i ) sb.append(')');
		return sb.toString();
		
	}

	static int factorial(int number, HashMap<Integer, Integer> map){

		if(map.containsKey(number)) return (int)map.get(number);
		
		if(number<=0) return 1;
		
		int temp = number*factorial(number-1, map);
		map.put(number, temp);
		return temp;
		
	}
}
