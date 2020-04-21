package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 나잡아봐라 {

    public static void main(String[] args) {
        System.out.println(solution("11 2"));
        System.out.println(solution("11 1"));
        System.out.println(solution("6 3"));
    }

    public static int solution(String input) {

        final int MIN = 0, MAX = 200000;

        String[] str = input.split(" ");
        int C = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);

        Queue<Integer> q = new LinkedList<>();
        q.offer(B);

        int dist = 0, t = 0;

        while(!q.isEmpty()) {

            t++;

            C += (++dist);

            if(C > MAX) return -1;

            int limit = q.size();

            for(int i=0; i<limit; ++i) {

                int cur = q.poll();
                int[] next = {cur-1, cur+1, 2*cur};

                for(int n : next) {

                    if(n == C) return t;

                    if(n > MAX || n < MIN) continue;

                    q.offer(n);
                }
            }
        }

        return -1;
    }

}
