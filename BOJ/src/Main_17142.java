import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_17142 {

    static int N, M, K, min;
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] map;
    static int[][][] cnt;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        K = 0;
        min = Integer.MAX_VALUE;
        map = new int[N][N];

        int check = 0;
        for(int i=0; i<N; ++i) {
            str = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 2) K++;
                if(map[i][j] == 0) check++;
            }
        }

        if(check>0) {
            cnt = new int[K][N][N];
            int m = 0;
            for(int i=0; i<N; ++i) {
                for(int j=0; j<N; ++j) {
                    if(map[i][j] == 2) set(m++, i, j);
                }
            }

            go(0,0,0);
        }else {
            min = 0;
        }

        System.out.println(min==Integer.MAX_VALUE? -1 : min);
    }

    static void set(int m, int r, int c) {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, 1));
        cnt[m][r][c] = 1;

        while(!q.isEmpty()) {

            Node cn = q.poll();

            for(int d=0; d<4; ++d) {
                int nr = cn.r + dir[d][0];
                int nc = cn.c + dir[d][1];

                if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
                if(map[nr][nc] == 1) continue;
                if(cnt[m][nr][nc] > 0) continue;

                cnt[m][nr][nc] = cn.k+1;
                q.offer(new Node(nr,nc,cn.k+1));
            }
        }

        print(cnt[m]);

    }

    static void go(int index, int select, int start) {

        if(index == M) {
            int time = time(select);
            if(time>0 && time<min) min = time;
            return;
        }

        for(int i=start; i<K; ++i) {
            if(((select>>i)&1) == 1) continue;
            go(index+1, select|(1<<i), i+1);
        }
    }

    static int time(int select) {

        int[][] tmp = new int[N][N];
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                if(map[i][j] == 1) continue;
                int m = Integer.MAX_VALUE;
                for(int k=0; k<K; ++k) {
                    if(((select>>k)&1)==0) continue;
                    if(cnt[k][i][j]<m) m = cnt[k][i][j];
                }
                tmp[i][j] = m;
            }
        }

        return check(tmp)-1;
    }

    static int[][] copy() {
        int[][] tmp = new int[N][N];
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
            }
        }
        return tmp;
    }

    static int check(int[][] tmp) {
        int max = 0;
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                if(map[i][j] > 0) continue;
                if(tmp[i][j] == 0) return -1;
                if(tmp[i][j] > max) max = tmp[i][j];
            }
        }
        return max;
    }

    static void print(int[][] map) {
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                System.out.format("%3d", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Node {
        int r, c, k;
        Node(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }

}
