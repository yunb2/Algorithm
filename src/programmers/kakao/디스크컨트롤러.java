package programmers.kakao;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0,3}, {4,9}, {4,5}, {5,6}}));
        System.out.println(solution(new int[][] {{0,3}, {1,9}, {2,6}}));
        System.out.println(solution(new int[][] {{24,10},{18,39},{34,20},{37,5},{47,22},{20,47},{15,2},{15,34},{35,43},{26,1}}));
        System.out.println(solution(new int[][] {{24,10},{18,39},{34,20},{37,5},{47,22},{20,47},{15,34},{15,2},{35,43},{26,1}}));
    }

    public static int solution(int[][] jobs) {

        PriorityQueue<int[]> jobQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> waitQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for(int[] j : jobs) jobQueue.offer(j);

        int t = 0, total = 0;

        while(!jobQueue.isEmpty() || !waitQueue.isEmpty()) {

            while(!jobQueue.isEmpty()) {
                if(jobQueue.peek()[0] > t) break;
                waitQueue.offer(jobQueue.poll());
            }

            if(!waitQueue.isEmpty()) {
                int[] next = waitQueue.poll();
                t += next[1];
                total += (t - next[0]);
            } else {
                t++;
            }
        }

        return total / jobs.length;
    }

}
