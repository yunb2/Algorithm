package codingtest.est;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {51,71,17,42}));
        System.out.println(solution(new int[] {42,33,60}));
        System.out.println(solution(new int[] {51,32,43}));
    }

    public static int solution(int[] A) {

        PriorityQueue<Integer>[] digitSums = new PriorityQueue[47];
        for(int i=0; i<47; ++i) digitSums[i] = new PriorityQueue<>(Comparator.reverseOrder());

        for(int a : A) {
            int digitSum = calDigitSum(a);
            digitSums[digitSum].add(a);
        }

        int max = -1;

        for(PriorityQueue q : digitSums) {

            if(q.size() < 2) continue;

            int n1 = (int) q.poll();
            int n2 = (int) q.poll();
            max = Math.max(max, n1 + n2);
        }

        return max;
    }

    public static int calDigitSum(int num) {
        int digitSum = 0;

        while(num > 0) {
            digitSum += num%10;
            num /= 10;
        }

        return digitSum;
    }

}
