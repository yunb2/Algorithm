package programmers.kakao;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 무지의먹방라이브 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {7, 2, 4}, 12));
        System.out.println(solution(new int[] {3, 1, 1, 1, 2, 4, 3}, 12));
        System.out.println(solution(new int[] {4, 3, 5, 6, 2}, 7));
        System.out.println(solution(new int[] {4, 1, 1, 5}, 7));
    }

    public static int solution(int[] food_times, long k) {
        long min = Arrays.stream(food_times).min().getAsInt();
        long cnt = food_times.length;

        while(k > (min * cnt)) {

            k -= (min * cnt);

            for(int i=0; i<food_times.length; ++i) {
                if(food_times[i] > 0) food_times[i] -= min;
            }

            cnt = Arrays.stream(food_times).filter(t -> t > 0).count();
            min = Arrays.stream(food_times).filter(t -> t > 0).min().orElse(0);
            if(min == 0) return -1;
        }

        return nextFood(food_times, k);
    }

    public static int nextFood(int[] foods, long t) {
        int i = 0;
        while(t-- > 0) {
            foods[i]--;
            i = IntStream.range(i+1, foods.length+i+1)
                                .filter(j -> foods[j % foods.length] > 0)
                                .findFirst()
                                .orElse(-1) % foods.length;

            if(i < 0) return -1;
        }

        return i + 1;
    }

}
