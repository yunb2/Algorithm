package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치 {

    static int N, C;
    static int[] home;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        home = new int[N];
        for(int i=0; i<N; ++i) home[i] = Integer.parseInt(br.readLine());
        Arrays.sort(home);

        int start = 1, end = home[N-1] - home[0], answer = 0;
        while(start <= end) {

            int mid = (start + end) / 2;

            if(check(mid)) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }

        }

        System.out.println(answer);

    }

    public static boolean check(int dist) {

        int cnt = C-1, cur = home[0];

        for(int i=1; i<N; ++i) {

            int d = home[i] - cur;

            if(d < dist) continue;

            cur = home[i];
            if(--cnt == 0) break;
        }

        return cnt == 0;
    }

}
