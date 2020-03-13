package programmers.kakao;

public class 괄호변환 {

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {

        if(p.isEmpty() || isValid(p)) return p;

        String[] s = separate(p);
        String u = s[0];
        String v = s[1];

        if(isValid(u)) return u + solution(v);
        return "(" + solution(v) + ")" + reverse(u.substring(1, u.length()-1));
    }

    public static boolean isValid(String p) {

        int cnt = 0;
        for(char c : p.toCharArray()) {
            if(c == '(') {
                cnt++;
                continue;
            }
            if(cnt == 0) return false;
            cnt--;
        }
        return true;
    }

    public static String[] separate(String p) {

        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {

            char c = p.charAt(i);
            cnt = (c == '(') ? cnt + 1 : cnt - 1;

            if (cnt == 0) {
                String u = p.substring(0, i+1);
                String v = p.substring(i+1);

                return new String[] {u, v};
            }
        }

        return new String[] {p, ""};
    }

    public static String reverse(String p) {

        StringBuilder sb = new StringBuilder();

        for(char c : p.toCharArray()) {
            char tmp = (c == '(')? ')' : '(';
            sb.append(tmp);
        }

        return sb.toString();
    }

}
