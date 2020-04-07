package codingtest.line;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(solution("Hello, world!"));
        System.out.println(solution("line [plus]"));
        System.out.println(solution("if (Count of eggs is 4.) {Buy milk.}"));
        System.out.println(solution(">_<"));
        System.out.println(solution("(("));
        System.out.println(solution("))"));
    }

    public static int solution(String inputString) {

        int answer = 0;
        int[] cnt = new int[4];

        for(int i=0; i<inputString.length(); ++i) {

            char c = inputString.charAt(i);

            if(!isBracket(c)) continue;

            if(isOpenBracket(c)) {
                cnt[bracketIndex(c)]++;
                continue;
            }

            if(cnt[bracketIndex(c)] <= 0) return -1;

            cnt[bracketIndex(c)]--;
            answer++;
        }

        for(int i=0; i<4; ++i) {
            if(cnt[i] > 0) return -1;
        }

        return answer;
    }

    public static boolean isBracket(char c) {
        return c == ')' || c == '}' || c == ']' || c == '>' || isOpenBracket(c);
    }

    public static boolean isOpenBracket(char c) {
        return c == '(' || c == '{' || c == '[' || c == '<';
    }

    public static int bracketIndex(char c) {

        switch (c) {
            case '(': case ')': return 0;
            case '{': case '}': return 1;
            case '[': case ']': return 2;
            case '<': case '>': return 3;
        }

        return -1;
    }

}
