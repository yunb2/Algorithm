
public class Solution1 {

	public static void main(String[] args) {
		
		
		
	}
	
	public static int solution(int[] restaurant, int[][] riders, int k) {
        int answer = 0;
        
        for(int[] rider : riders) {
        	if(isPossible(restaurant, rider, k)) answer++;
        }
        
        return answer;
    }
	
	public static boolean isPossible(int[] restarant, int[] rider, int k) {
		
		int diffX = restarant[0]-rider[0];
		int diffY = restarant[1]-rider[1];
		int dist = diffX*diffX + diffY*diffY;
		
		return dist<(k*k);
		
	}
	
}
