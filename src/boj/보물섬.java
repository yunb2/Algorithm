package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 보물섬 {

    static int R, C;
    static char[][] map;
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        map = new char[R][C];
        for(int i=0; i<R; ++i) map[i] = br.readLine().toCharArray();

        int max = 0;
        for(int i=0; i<R; ++i) {
            for(int j=0; j<C; ++j) {
                if(map[i][j] == 'L') max = Math.max(max, bfs(i, j));
            }
        }

        System.out.println(max);
    }

    public static int bfs(int r, int c) {

        boolean[][] visit = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visit[r][c] = true;

        int distance = -1;
        while(!q.isEmpty()) {

            int size = q.size();
            for(int i=0; i<size; ++i) {

                int[] cur = q.poll();
                for(int d=0; d<4; ++d) {

                    int nr = cur[0] + dir[d][0];
                    int nc = cur[1] + dir[d][1];

                    if(nr<0||nc<0||nr>=R||nc>=C||map[nr][nc]=='W'||visit[nr][nc]) continue;

                    q.add(new int[] {nr, nc});
                    visit[nr][nc] = true;
                }
            }

            distance++;
        }

        return distance;
    }

}
