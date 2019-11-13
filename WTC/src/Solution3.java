import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {

	public static void main(String[] args) {
		
		int[] prices = {32000, 18000, 42500};
		int[] discounts = {50, 20, 65};
		
		int answer = solution(prices, discounts);
		
		System.out.println(answer);
		
	}
	
	public static int solution(int[] prices, int[] discounts) {
        int answer = 0;
        
        Integer[] priceArr = Arrays.stream(prices).boxed().toArray(Integer[]::new);
        Integer[] discountArr = Arrays.stream(discounts).boxed().toArray(Integer[]::new);
        
        Arrays.sort(priceArr, Comparator.reverseOrder());
        Arrays.sort(discountArr, Comparator.reverseOrder());
        
        int length = Math.min(priceArr.length, discountArr.length);
        
        for(int i=0; i<length; ++i) {
        	double discount = discountArr[i] * 0.01;
        	priceArr[i] =  (int) Math.ceil(priceArr[i] * (1-discount));
        }
        
        for(int i=0; i<priceArr.length; ++i) {
        	answer += priceArr[i];
        }
        
        return answer;
    }
	
}
