package programmers;

public class N진수게임 {

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }

    static char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String solution(int n, int t, int m, int p) {

        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;
        while (sb.length() < m*t) sb.append(convert(n, num++));
        for(int i=p-1; i<sb.length(); i+=m) answer.append(sb.charAt(i));

        return answer.toString().substring(0, t);
    }

    public static String convert(int n, int num) {

        StringBuilder sb = new StringBuilder();

        while(num >= n) {
            sb.append(chars[num%n]);
            num /= n;
        }
        sb.append(chars[num]);

        return sb.reverse().toString();
    }
}
