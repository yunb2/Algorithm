package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 치킨배달 {

    static int N, M, min;
    static int[][] map, dist;
    static List<int[]> home, chicken;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        min = Integer.MAX_VALUE;
        map = new int[N][N];
        home = new LinkedList<>();
        chicken = new LinkedList<>();
        for(int i=0; i<N; ++i) {
            str = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 1) home.add(new int[] {i, j});
                else if(map[i][j] == 2) chicken.add(new int[] {i, j});
            }
        }

        dist = new int[home.size()][chicken.size()];
        for(int i=0; i<home.size(); ++i) {
            for(int j=0; j<chicken.size(); ++j) {
                int[] h = home.get(i);
                int[] c = chicken.get(j);
                dist[i][j] = Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]);
            }
        }

        for(int i=0; i<chicken.size(); ++i) {
            combination(1, i, 1<<i);
        }

        System.out.println(min);

    }

    public static void combination(int index, int start, int check) {

        if (index == M) {
            min = Math.min(min, calChickenDist(check));
            return;
        }

        for(int i=start+1; i<chicken.size(); ++i) {
            combination(index+1, i, check | (1<<i));
        }

    }

    public static int calChickenDist(int check) {

        int chickenDist = 0;

        for(int i=0; i<home.size(); ++i) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<chicken.size(); ++j) {
                if(((check>>j)&1) == 0) continue;
                min = Math.min(min, dist[i][j]);
            }
            chickenDist += min;
        }

        return chickenDist;
    }

}
