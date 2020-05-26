package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동하기 {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];

        for(int i=0; i<N; ++i) {
            String row = br.readLine();
            for(int j=0; j<M; ++j) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,0));
        int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        int[][] visit = new int[N][M];
        visit[0][0] = 2; // 0: 안방문 , 1: 한번 깬 상태에서 방문, 2: 안깬 상태에서 방문

        int cnt = 1, answer = -1;
        out:
        while(!q.isEmpty()) {

            int size = q.size();
            for(int i=0; i<size; ++i) {

                Node cur = q.poll();

                if(cur.r == N-1 && cur.c == M-1) {
                    answer = cnt;
                    break out;
                }

                for(int d=0; d<4; ++d) {

                    int nr = cur.r + dir[d][0];
                    int nc = cur.c + dir[d][1];

                    if(nr<0||nc<0||nr>=N||nc>=M||visit[nr][nc]==2) continue;

                    if(cur.v==1 && (map[nr][nc]==1 || visit[nr][nc]==1)) continue;

                    Node next;

                    if(cur.v==1) {
                        visit[nr][nc] = 1;
                        next = new Node(nr, nc, 1);
                    } else if(map[nr][nc] == 1) {
                        visit[nr][nc] = 2;
                        next = new Node(nr, nc, 1);
                    } else {
                        visit[nr][nc] = 2;
                        next = new Node(nr, nc, 0);
                    }

                    q.add(next);

                }
            }

            cnt++;
        }

        System.out.println(answer);

    }

    static class Node {
        int r, c, v;

        public Node(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }

}
