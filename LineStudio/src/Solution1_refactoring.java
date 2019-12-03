import java.util.HashSet;

public class Solution1_refactoring {

	public static void main(String[] args) {
		
		System.out.println(solution(new int[] {0,1,3,5,6,8,12,17}));
		System.out.println(solution(new int[] {0,1,2,3,4,8,9,11}));
		
	}

	static HashSet<Integer> set = new HashSet<>();
	static HashSet<Long> visit = new HashSet<>();
	static int lastFloor;
	
	public static boolean solution(int[] stones) {

		if(stones[0]!=0 || stones[1]!=1) return false;
		
		for(int s : stones) set.add(s);
		lastFloor = stones[stones.length-1];
		
		return jump(1, 1);
		
	}
	
	public static boolean jump(int lastJump, int curFloor) {
		
		if(!set.contains(curFloor)) return false;
		
		long key = (lastJump<<32) + curFloor;
		if(visit.contains(key)) return false;
		visit.add(key);
		
		if(curFloor == lastFloor) return true;
		
		if(lastJump>1 && jump(lastJump-1, curFloor+lastJump-1)) return true;
		
		if(jump(lastJump, curFloor+lastJump)) return true;
		
		if(jump(lastJump+1, curFloor+lastJump+1)) return true;
		
		return false;
		
	}
	
}
