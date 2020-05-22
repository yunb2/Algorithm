package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
*
15 7
*.o.*..........
.........**....
.*.............
...............
...............
...............
x.......*....*.

*
* */

public class 로봇청소기 {

    static int W, H, min;
    static char[][] room;
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {

            String[] str = br.readLine().split(" ");
            W = Integer.parseInt(str[0]);
            H = Integer.parseInt(str[1]);
            if(W == 0 && H == 0) break;

            room = new char[H][W];
            min = Integer.MAX_VALUE;
            int dust = 0;
            Queue<Node> q = new LinkedList<>();

            for(int i=0; i<H; ++i) {
                String row = br.readLine();
                for(int j=0; j<W; ++j) {
                    room[i][j] = row.charAt(j);
                    if(room[i][j] == '*') dust++;
                    else if(room[i][j] == 'o') {
                        q.add(new Node(i, j));
                    }
                }
            }

            bfs(0, dust, q);

            System.out.println(min==Integer.MAX_VALUE? -1 : min);
        }

    }

    public static void bfs(int move, int dust, Queue<Node> q) {

        if(move >= min) return;

        if(dust == 0) {
            min = move;
            return;
        }

        boolean[][] visit = new boolean[H][W];
        Node cur = q.peek();
        visit[cur.r][cur.c] = true;

        while(!q.isEmpty()) {

            move++;
            int size = q.size();

            for(int i=0; i<size; ++i) {

                cur = q.poll();

                for(int d=0; d<4; ++d) {

                    int nr = cur.r + dir[d][0];
                    int nc = cur.c + dir[d][1];

                    if(nr<0||nc<0||nr>=H||nc>=W||room[nr][nc]=='x'||visit[nr][nc]) continue;

                    if(room[nr][nc] == '*') {
                        Queue<Node> q2 = new LinkedList<>();
                        q2.add(new Node(nr,nc));

                        room[nr][nc] = '.';
                        bfs(move, dust-1, q2);
                        room[nr][nc] = '*';

                    }

                    q.add(new Node(nr, nc));
                    visit[nr][nc] = true;

                }

            }
        }
    }

    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
