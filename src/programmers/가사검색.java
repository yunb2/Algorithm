package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 가사검색 {

    public static void main(String[] args) {

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(Arrays.toString(solution(words, queries)));
    }

    public static int[] solution(String[] words, String[] queries) {

        String[][] sortedWords = new String[2][words.length];
        sortedWords[0] = Arrays.stream(words).sorted(가사검색::compare).toArray(String[]::new);
        sortedWords[1] = Arrays.stream(words).sorted(가사검색::reverse).toArray(String[]::new);

        return Arrays.stream(queries)
                    .mapToInt(query -> {
                        int i = (query.endsWith("?"))? 0 : 1;

                        Comparator<String> comparator = (i == 0)? 가사검색::compare : 가사검색::reverse;

                        int start = Arrays.binarySearch(sortedWords[i], query.replace('?', (char)('a'-1)), comparator) * -1;
                        int end = Arrays.binarySearch(sortedWords[i], query.replace('?', (char)('z'+1)), comparator) * -1;

                        return end - start;
                    })
                    .toArray();

    }

    public static int compare(String o1, String o2) {
        if(o1.length() == o2.length()) return o1.compareTo(o2);
        return o1.length() - o2.length();
    }

    public static int reverse(String o1, String o2) {
        StringBuilder sb1 = new StringBuilder(o1);
        StringBuilder sb2 = new StringBuilder(o2);

        o1 = sb1.reverse().toString();
        o2 = sb2.reverse().toString();

        return compare(o1, o2);
    }

}
