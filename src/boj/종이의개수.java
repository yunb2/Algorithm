package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

        Queue<int[]> papers = new LinkedList<>();
        papers.add(new int[] {0, 0, N});

        while(!papers.isEmpty()) {
            int[] info = papers.poll();
            if(check(info[0], info[1], info[2])) continue;
            papers.addAll(Arrays.asList(cut(info[0], info[1], info[2])));
        }

        for(int a : answer) System.out.println(a);

    }

    public static boolean check(int r, int c, int n) {

        int value = paper[r][c];

        for(int i=r; i<r+n; ++i) {
            for(int j=c; j<c+n; ++j) {
                if(paper[i][j] != value) return false;
            }
        }

        answer[value+1]++;
        return true;
    }

    public static int[][] cut(int r, int c, int n) {

        int[][] papers = new int[9][3];
        int index = 0;

        for(int i=r; i<r+n; i+=n/3) {
            for(int j=c; j<c+n; j+=n/3) {
                papers[index][0] = i;
                papers[index][1] = j;
                papers[index++][2] = n/3;
            }
        }

        return papers;
    }

}
