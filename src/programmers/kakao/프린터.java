package programmers.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,1,9,1,1,1}, 0));
    }

    public static int solution(int[] priorities, int location) {

        Queue<Priority> q = new LinkedList<>();
        for(int i=0; i<priorities.length; ++i) q.add(new Priority(i, priorities[i]));

        int answer = 1;

        while(q.size() > 1) {

            Priority cur = q.poll();
            Priority max = q.stream().max(Priority::compareTo).orElse(null);

            if(max.v > cur.v) {
                q.add(cur);
                continue;
            }

            if(cur.i == location) break;

            answer++;
        }

        return answer;
    }

    static class Priority implements Comparable<Priority> {
        int i, v;

        public Priority(int i, int v) {
            this.i = i;
            this.v = v;
        }

        @Override
        public int compareTo(Priority o) {
            return this.v - o.v;
        }
    }

}
