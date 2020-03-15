package programmers.kakao;

import java.util.Arrays;
import java.util.Comparator;

public class 가사검색 {

    public static void main(String[] args) {

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "prime", "kakao", "test"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "??????"};

        System.out.println(Arrays.toString(solution(words, queries)));
    }

    public static int[] solution(String[] words, String[] queries) {

        String[] sortedByWord = Arrays.stream(words)
                                .sorted()
                                .toArray(String[]::new);

        String[] sortedByReversed = Arrays.stream(words)
                                .sorted(가사검색::reverseCompare)
                                .toArray(String[]::new);

        String[] sortedByLength = Arrays.stream(words)
                                    .sorted(Comparator.comparingInt(String::length))
                                    .toArray(String[]::new);

        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; ++i) {

            String query = queries[i];

            if(query.matches("\\?+")) {
                answer[i] = count(sortedByLength, "\\w{" + query.length() + "}");
            } else if(query.startsWith("?")) {
                answer[i] = count(sortedByReversed, query.replace("?", "\\w"));
            } else if(query.endsWith("?")) {
                answer[i] = count(sortedByWord, query.replace("?", "\\w"));
            }
        }

        return answer;
    }

    public static int reverseCompare(String o1, String o2) {
        StringBuilder sb1 = new StringBuilder(o1);
        StringBuilder sb2 = new StringBuilder(o2);

        o1 = sb1.reverse().toString();
        o2 = sb2.reverse().toString();

        return o1.compareTo(o2);
    }

    public static int count(String[] words, String reg) {

        int start = words.length;
        for(int j=0; j<words.length; ++j) {
            if(words[j].matches(reg)) {
                start = j;
                break;
            }
        }

        int end = words.length;
        for(int j=start; j<words.length; ++j) {
            if(!words[j].matches(reg)) {
                end = j;
                break;
            }
        }

        return (end - start);
    }

}
