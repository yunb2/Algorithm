import java.util.Arrays;

public class Solution5 {

	public static void main(String[] args) {
		
		String[] history = {"1.0", "2.0", "1.5"};
//		String[] history = {"1.0", "2.0", "0.0", "1.0"};
		
		int[] result = solution(history);
		
		System.out.println(Arrays.toString(result));
		
	}
	
	public static int[] solution(String[] history) {
		
		for(String cnt : history) {
			if(cnt.equals("1.0")) continue;
			if(cnt.equals("1.5")) continue;
			if(cnt.equals("2.0")) continue;
			if(cnt.equals("2.5")) continue;
			return new int[] {-1};
		}
		
		int[] recipes = {4, 50, 10, 10, 4};
		int[] materials = {5, 100, 10, 5, 2};
		int[] units = {10, 100, 30, 50, 10};
		int[] prices = {10000, 3000, 1000, 2000, 1000};
		
		int[] answer = new int[history.length];
		
		for(int i=0; i<history.length; ++i) {
			
			double servings = Double.parseDouble(history[i]);

			int total = 0;
			
			for(int j=0; j<5; ++j) {
				
				int neededMaterial = (int)(recipes[j] * servings);
				
				if(j==4 && ((servings*10)%10)==5) neededMaterial/=2;
				
				materials[j] -= neededMaterial;
				
				if(materials[j]<0) {
					int material = materials[j]*-1;
					int cnt = (material/units[j])+1;
					total += prices[j]*cnt;
					materials[j] += units[j]*cnt;
				}
				
			}
			
			answer[i] = total;
			
		}
		
        return answer;
    }
	
}
