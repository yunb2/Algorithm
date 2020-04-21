package programmers;

public class 문자열압축 {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {

        int min = s.length();

        for(int i = 1; i <= s.length()/2; ++i) {
            String result = compress(s, i, 1);
            min = Math.min(min, result.length());
        }

        return min;
    }

    public static String compress(String s, int unit, int cnt) {

        if(s.length() < unit) return s;

        String prefix = s.substring(0, unit);
        String post = s.substring(unit);
        StringBuilder sb = new StringBuilder();

        if(!post.startsWith(prefix)) {
            if(cnt > 1) sb.append(cnt);
            return sb.append(prefix).append(compress(post, unit, 1)).toString();
        }

        return sb.append(compress(post, unit, cnt+1)).toString();
    }

}
