package programmers.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<String> q = new LinkedList<>();
        q.add(begin);

        out:
        while(!q.isEmpty()) {

            int len = q.size();

            for(int i=0; i<len; ++i) {

                begin = q.poll();
                if(begin.equals(target)) break out;

                for(int j=0; j<words.length; ++j) {
                    if(cntDiff(begin, words[j]) == 1) {
                        q.add(words[j]);
                        words[j] = "";
                    }
                }
            }

            answer++;
        }

        return begin.equals(target)? answer : 0;
    }

    public static int cntDiff(String s1, String s2) {

        int cnt = 0;
        for(int i=0; i<s2.length(); ++i) {
            if(s1.charAt(i) != s2.charAt(i)) cnt++;
        }

        return cnt;
    }

}
