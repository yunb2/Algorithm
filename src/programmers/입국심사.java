package programmers;

import java.util.Arrays;

public class 입국심사 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[] {7, 10}));
    }

    public static long solution(int n, int[] times) {

        long answer = 0;

        Arrays.sort(times);

        long start = 0;
        long end = (long) times[times.length-1] * (long) n;

        while(start <= end) {

            long mid = (start + end) / 2;
            long sum = 0;

            for(int t : times) {
                if(t > mid) break;
                sum += mid / t;
            }

            if(sum < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }

        }

        return answer;
    }

}
