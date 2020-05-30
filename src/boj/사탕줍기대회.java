package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 사탕줍기대회 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            String[] str = br.readLine().split(" ");

            int M = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);

            if(M == 0 && N == 0) break;

            int[][] candy = new int[M+2][N+2];
            for(int i=2; i<M+2; ++i) {
                str = br.readLine().split(" ");
                for(int j=2; j<N+2; ++j) {
                    candy[i][j] = Math.max(candy[i][j-1], candy[i][j-2] + Integer.parseInt(str[j-2]));
                }
            }

            for(int i=2; i<M+2; ++i) {
                candy[i][N+1] = Math.max(candy[i-1][N+1], candy[i-2][N+1] + candy[i][N+1]);
            }

            System.out.println(candy[M+1][N+1]);

        }



    }

}
