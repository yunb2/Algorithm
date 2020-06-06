package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 인구이동 {

    static int N, L, R;
    static int[][] map, visit;
    static HashMap<Integer, Integer> people;
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        L = Integer.parseInt(str[1]);
        R = Integer.parseInt(str[2]);
        map = new int[N][N];
        visit = new int[N][N];
        people = new HashMap<>();
        for(int i=0; i<N; ++i) {
            str = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        int cnt = 0;
        while(open()) {
            setMap();
            cnt++;
        }

        System.out.println(cnt);

    }

    public static boolean open() {

        boolean open = false;
        int index = 1;

        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {

                if(visit[i][j] > 0) continue;

                if(bfs(i, j, index++)) open = true;

            }
        }

        return open;
    }

    public static boolean bfs(int r, int c, int index) {

        int total = map[r][c], cnt = 1;
        visit[r][c] = index;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});

        while(!q.isEmpty()) {

            int[] cur = q.poll();
            int val = map[cur[0]][cur[1]];

            for(int d=0; d<4; ++d) {

                int nr = cur[0] + dir[d][0];
                int nc = cur[1] + dir[d][1];

                if(nr<0||nc<0||nr>=N||nc>=N||visit[nr][nc]>0) continue;

                int diff = Math.abs(map[nr][nc] - val);
                if(diff < L || diff > R) continue;

                q.add(new int[] {nr, nc});
                visit[nr][nc] = index;
                total += map[nr][nc];
                cnt++;

            }

        }

        people.put(index, total/cnt);

        return cnt>1;
    }

    public static void setMap() {
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                map[i][j] = people.get(visit[i][j]);
                visit[i][j] = 0;
            }
        }
        people.clear();
    }

}
