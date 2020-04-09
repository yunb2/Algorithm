package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 퇴사 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];

        for(int i=0; i<N; ++i) {
            String[] str = br.readLine().split(" ");
            dp[i][0] = Integer.parseInt(str[0]);
            dp[i][1] = Integer.parseInt(str[1]);
            dp[i][2] = ((i + dp[i][0]) <= N)? dp[i][1] : 0;
        }

        for(int i=N-2; i>=0; --i) {
            int next = i + dp[i][0];
            if(next < N) dp[i][2] = dp[i][1] + dp[next][2];
            dp[i][2] = Math.max(dp[i][2], dp[i+1][2]);
        }

        System.out.println(dp[0][2]);
    }

}
