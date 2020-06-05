package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 감시 {

    static int N, M, min;
    static List<int[]> cctv;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        min = Integer.MAX_VALUE;
        cctv = new LinkedList<>();

        int[][] room = new int[N][M];
        for(int i=0; i<N; ++i) {
            str = br.readLine().split(" ");
            for(int j=0; j<M; ++j) {
                room[i][j] = Integer.parseInt(str[j]);
                if(room[i][j] > 0 && room[i][j] < 6) cctv.add(new int[] {i, j});
            }
        }

        go(0, room);

        System.out.println(min);

    }

    public static void go(int index, int[][] room) {

        if(index == cctv.size()) {
            min = Math.min(min, count(room));
            return;
        }

        int[] pos = cctv.get(index);
        int[][][] dir = getDirections(room[pos[0]][pos[1]]);

        for(int i=0; i<dir.length; ++i) {
            go(index + 1, check(room, pos, dir[i]));
        }

    }

    public static int[][][] getDirections(int cctvType) {

        switch (cctvType) {
            case 1:
                return new int[][][] {
                        {{-1,0}},
                        {{0,1}},
                        {{1,0}},
                        {{0,-1}}
                };
            case 2:
                return new int[][][] {
                        {{-1,0}, {1,0}},
                        {{0,-1}, {0,1}}
                };
            case 3:
                return new int[][][] {
                        {{-1,0}, {0,1}},
                        {{0,1}, {1,0}},
                        {{1,0}, {0,-1}},
                        {{0,-1}, {-1,0}}
                };
            case 4:
                return new int[][][] {
                        {{0,-1}, {-1,0}, {0,1}},
                        {{-1,0}, {0,1}, {1,0}},
                        {{0,1}, {1,0}, {0,-1}},
                        {{1,0}, {0,-1}, {-1,0}}
                };
            case 5:
                return new int[][][] {
                        {{-1,0}, {0,1}, {1,0}, {0,-1}}
                };
        }

        return null;
    }

    public static int[][] check(int[][] origin, int[] pos, int[][] dir) {
        int[][] copy = new int[N][M];

        for(int i=0; i<N; ++i) {
            for(int j=0; j<M; ++j) {
                copy[i][j] = origin[i][j];
            }
        }

        for(int d=0; d<dir.length; ++d) {

            int nr = pos[0] + dir[d][0];
            int nc = pos[1] + dir[d][1];

            while(nr >= 0 && nc >= 0 && nr < N && nc < M && copy[nr][nc] != 6) {

                if (copy[nr][nc] == 0) copy[nr][nc] = 7;

                nr += dir[d][0];
                nc += dir[d][1];
            }

        }

        return copy;
    }

    public static int count(int[][] room) {
        int cnt = 0;
        for(int i=0; i<N; ++i) {
            for(int j=0; j<M; ++j) {
                if(room[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

}
