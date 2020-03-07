package programmers.kakao;

import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 뉴스클러스터링 {

    public static void main(String[] args) {

        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));

    }

    public static int solution(String str1, String str2) {
        PriorityQueue<String> q1 = setQueue(str1);
        PriorityQueue<String> q2 = setQueue(str2);

        if(q1.isEmpty() && q2.isEmpty()) return 65536;

        double inter = 0, union = 0;
        while(!q1.isEmpty() && !q2.isEmpty()) {
            String s1 = q1.poll();
            String s2 = q2.poll();

            int cmp = s1.compareTo(s2);
            if(cmp == 0) inter++;
            else if(cmp < 0) q2.offer(s2);
            else q1.offer(s1);

            union++;
        }

        union += (q1.size() + q2.size());
        return (int)((inter/union)*65536);
    }

    public static PriorityQueue<String> setQueue(String str) {
        return IntStream.rangeClosed(0, str.length()-2)
                        .parallel()
                        .mapToObj((n) -> str.substring(n, n+2).toUpperCase())
                        .filter(s -> s.matches("[a-zA-Z]{2}"))
                        .collect(Collectors.toCollection(PriorityQueue::new));
    }
}

