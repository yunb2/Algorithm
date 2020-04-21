package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 라면공장 {

    public static void main(String[] args) {
        System.out.println(solution(4, new int[] {4,10,15}, new int[] {20,5,10}, 30));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {

        int answer = 0, lastDay = stock;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<dates.length && lastDay < k; ++i) {

            if(dates[i] > lastDay) {
                lastDay += q.poll();
                answer++;
            }

            q.offer(supplies[i]);
        }

        while(lastDay < k) {
            lastDay += q.poll();
            answer++;
        }

        return answer;
    }

}
