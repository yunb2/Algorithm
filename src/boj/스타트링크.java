package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 스타트링크 {

    static int N, min;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        min = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; ++i) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        combination(0,0,0);

        System.out.println(min);

    }

    public static void combination(int cnt, int start, int bit) {

        if(cnt == N/2) {
            int teamStart = 0, teamLink = 0;
            for(int i=0; i<N; ++i) {
                for(int j=0; j<N; ++j) {
                    if((((bit>>i)&1) == 0) && (((bit>>j)&1) == 0)) teamStart += map[i][j];
                    if((((bit>>i)&1) == 1) && (((bit>>j)&1) == 1)) teamLink += map[i][j];
                }
            }

            min = Math.min(min, Math.abs(teamStart-teamLink));
            return;
        }

        for(int i=start; i<=(N/2 + cnt); ++i) {
            combination(cnt+1, i+1, bit | (1<<i));
        }

    }

}
