package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 종이의개수 {

    static int[][] paper;
    static int[] answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        answer = new int[3];

        for(int i=0; i<N; ++i) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<N; ++j) paper[i][j] = Integer.parseInt(str[j]);
        }

        go(0, 0, N);

        for(int a : answer) System.out.println(a);
    }

    public static void go(int sr, int sc, int n) {

        int value = paper[sr][sc];

        for(int r=sr; r<sr+n; ++r) {
            for(int c=sc; c<sc+n; ++c) {

                if(paper[r][c] == value) continue;

                for(int nr=sr; nr<sr+n; nr+=n/3) {
                    for(int nc=sc; nc<sc+n; nc+=n/3) {
                        go(nr, nc, n/3);
                    }
                }

                return;
            }
        }

        answer[value+1]++;
    }

}
