package codingtest.line;

public class Solution3 {

    public static void main(String[] args) {
        String s = "1010101010";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<30000; ++i) sb.append(s);
        System.out.println(solution(sb.toString(), 1));
        System.out.println(solution("111011110011111011111100011111", 3));
        System.out.println(solution("001100", 5));
    }

    public static int solution(String road, int n) {

        int answer = -1, start = 0, end = road.length();

        while(start <= end) {

            int mid = (start + end) / 2;

            if(check(road, n, mid)) {
                start = mid+1;
                answer = mid;
            } else {
                end = mid - 1;
            }

        }

        return answer;
    }

    private static boolean check(String road, int n, int mid) {

        int cnt = 0;
        for(int i=0; i<mid; ++i) {
            if(road.charAt(i) == '0') cnt++;
        }

        if(cnt <= n) return true;

        for(int i=1; i<road.length()-mid+1; ++i) {
            if(road.charAt(i-1) == '0') cnt--;
            if(road.charAt(i+mid-1) == '0') cnt++;
            if(cnt <= n) return true;
        }

        return false;
    }

}
