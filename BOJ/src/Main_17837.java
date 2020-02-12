import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_17837 {

    static final int RED = 1, BLUE = 2;
    static int N, K;
    static int[][] map, cnt;
    static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
    static Marker[][] top;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        top  = new Marker[N][N];
        map = new int[N][N];
        cnt = new int[N][N];

        for(int i=0; i<N; ++i) {
            str = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        Queue<Marker> q = new LinkedList<>();

        for(int i=0; i<K; ++i) {
            str = br.readLine().split(" ");

            int r = Integer.parseInt(str[0])-1;
            int c = Integer.parseInt(str[1])-1;
            int d = Integer.parseInt(str[2])-1;

            Marker marker = new Marker(r, c, d);
            q.offer(marker);
            top[r][c] = marker;
            cnt[r][c]++;
        }

        int answer = -1;

        out:
        for(int t=1; t<=1000; ++t) {
            for(int k=0; k<K; ++k) {
                System.out.println("===========================");
                System.out.println(t + " " + k);
                Marker marker = q.poll();
                if(marker.move() >= 4) {
                    answer = t;
                    break out;
                }
                q.offer(marker);
                print(cnt);
            }
        }

        System.out.println(answer);
    }

    static class Marker {
        int r, c, d;
        Marker up, down;

        Marker(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.up = null;
            this.down = null;
        }

        int move() {

            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if(nr<0||nr>=N||nc<0||nc>=N||map[nr][nc] == BLUE) {
                d = (d%2==0)? d+1 : d-1;
                nr = r + dir[d][0];
                nc = c + dir[d][1];
                if(nr<0||nr>=N||nc<0||nc>=N||map[nr][nc] == BLUE) return cnt[r][c];
            }

            if(down != null) {
                top[r][c] = down;
                down.up = null;
                down = null;
            }
            Marker bottom = this;

            if(map[nr][nc] == RED) {
                bottom = top[r][c];
                reverse();
            }

            if(top[nr][nc] != null) top[nr][nc].up = bottom;
            bottom.down = top[nr][nc];
            bottom.setPosition(nr, nc);

            return cnt[nr][nc];
        }

        void reverse() {
            Marker temp = this.up;
            this.up = this.down;
            this.down = temp;

            if(this.down == null) return;
            this.down.reverse();
        }

        void setPosition(int nr, int nc) {

            if(--cnt[r][c] == 0) top[r][c] = null;

            this.r = nr;
            this.c = nc;

            cnt[nr][nc]++;

            if(this.up == null) {
                top[nr][nc] = this;
                return;
            }

            this.up.setPosition(nr, nc);
        }
    }

    static void print(int[][] map) {
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
