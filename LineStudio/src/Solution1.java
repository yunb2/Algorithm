import java.util.HashSet;

public class Solution1 {

	public static void main(String[] args) {
		
		System.out.println(solution(new int[] {0,1,3,5,6,8,12,17}));
		System.out.println(solution(new int[] {0,1,2,3,4,8,9,11}));
		
	}

	public static boolean solution(int[] stones) {

		if(stones[0]!=0 || stones[1]!=1) return false;
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int s : stones) set.add(s);
		
		return jump(1, 1, stones[stones.length-1], set);
		
	}
	
	public static boolean jump(int k, int curFloor, int lastFloor, HashSet<Integer> set) {
		
		if(!set.contains(curFloor)) return false;
		
		if(curFloor == lastFloor) return true;
		
		if(k>1 && jump(k-1, curFloor+k-1, lastFloor, set)) return true;
		
		if(jump(k, curFloor+k, lastFloor, set)) return true;
		
		if(jump(k+1, curFloor+k+1, lastFloor, set)) return true;
		
		return false;
		
	}
	
}
