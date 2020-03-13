package programmers.kakao;

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
            String tmp = compress(s, i);
            min = Math.min(min, tmp.length());
        }
        return min;
    }

    public static String compress(String s, int unit) {

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(i <= s.length()-2*unit) {

            String str1 = s.substring(i, i+unit);
            int cnt = 1, j = i+unit;

            while(j <= s.length()-unit) {

                String str2 = s.substring(j, j+unit);

                if(!str1.equals(str2)) break;

                cnt++;
                j += unit;
            }

            if(cnt > 1) sb.append(cnt);
            sb.append(str1);
            i = j;
        }
        sb.append(s.substring(i));

        return sb.toString();
    }

}
