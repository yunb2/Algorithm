package programmers;

import java.util.Arrays;

public class 자동완성 {

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"go", "gone", "guild"}));
        System.out.println(solution(new String[] {"abc", "def", "ghi", "jklm"}));
        System.out.println(solution(new String[] {"word", "war", "warrior", "world"}));
    }

    public static int solution(String[] words) {

        int sum = 0, before = 0;
        Arrays.sort(words);

        for(int i=0; i<words.length-1; ++i) {
            int matches = countMatches(words[i], words[i+1]);
            int cnt = Math.max(before, matches);
            sum += ((cnt == words[i].length())? cnt : cnt+1);
            before = matches;
        }
        sum += ((before == words[words.length-1].length())? before : before+1);

        return sum;
    }

    public static int countMatches(String word1, String word2) {

        int len = Math.min(word1.length(), word2.length());
        for(int i=0; i<len; ++i) {
            if(word1.charAt(i) == word2.charAt(i)) continue;
            return i;
        }

        return len;
    }

}
