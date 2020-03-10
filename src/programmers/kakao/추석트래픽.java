package programmers.kakao;

import java.util.Arrays;

public class 추석트래픽 {

    public static void main(String[] args) {
        System.out.println(solution(new String[] {
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
        }));
        System.out.println(solution(new String[] {
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 00:00:00.000 3s"
        }));
    }

    public static int solution(String[] lines) {
        int[] tps = new int[24*60*60*1000 + 4000];

        Arrays.stream(lines)
                .parallel()
                .forEach(log -> check(log, tps));

        return Arrays.stream(tps).max().getAsInt();
    }

    public static void check(String log, int[] tps) {
        String[] str = log.split("[s\\s]");

        double end = timeToSec(str[1]);
        double start = end - Double.parseDouble(str[2]) - 0.998;

        int s = (int) (1000 * (start + 4.000));
        int e = (int) (1000 * (end + 4.000));

        for(int i=(s<0? 0:s); i<=e; ++i) tps[i]++;
    }

    public static double timeToSec(String time) {
        String[] str = time.split(":");
        int h = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        double s = Double.parseDouble(str[2]);
        return 60*60*h + 60*m + s;
    }

}
