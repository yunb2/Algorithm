package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 안전영역 {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int H = 0;
        for(int i=0; i<N; ++i) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                map[i][j] = Integer.parseInt(str[j]);
                H = Math.max(H, map[i][j]);
            }
        }

        int max = 1;
        for(int h=1; h<H; ++h) {
            max = Math.max(max, cntSafeArea(h));
        }

        System.out.println(max);

    }

    public static int cntSafeArea(int h) {

        int cnt = 0;
        boolean[][] visit = new boolean[N][N];
        int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {

                if(visit[i][j]) continue;

                if(map[i][j] <= h) {
                    visit[i][j] = true;
                    continue;
                }

                Queue<Node> q = new LinkedList<>();
                q.add(new Node(i, j));

                while(!q.isEmpty()) {

                    Node cur = q.poll();

                    for(int d=0; d<4; ++d) {

                        int nr = cur.r + dir[d][0];
                        int nc = cur.c + dir[d][1];

                        if(nr<0||nc<0||nr>=N||nc>=N||visit[nr][nc]) continue;

                        if(map[nr][nc] <= h) {
                            visit[nr][nc] = true;
                            continue;
                        }

                        q.add(new Node(nr, nc));
                        visit[nr][nc] = true;

                    }

                }

                cnt++;
            }
        }

        return cnt;
    }

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
