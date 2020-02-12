import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17822 {

    static int N, M, T, x, d, k;
    static int[][] map;
    static boolean[][] check;
    static boolean existSame;
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        T = Integer.parseInt(str[2]);

        map = new int[N][M];
        check = new boolean[N][M];
        existSame = false;
        for(int i=0; i<N; ++i) {
            str = br.readLine().split(" ");
            for(int j=0; j<M; ++j) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int t=0; t<T; ++t) {

            str = br.readLine().split(" ");
            x = Integer.parseInt(str[0]);
            d = Integer.parseInt(str[1]);
            k = Integer.parseInt(str[2]);
            existSame = false;

            for(int i=1; i<=N; ++i) {
                if(i%x == 0) turn(i-1);
            }

            check();

            if(existSame) {
                remove();
                existSame = false;
            }else {
                double avg = calAverage();
                setMap(avg);
            }

        }

        System.out.println(calTotal());

    }

    static void turn(int idx) {

        int[] temp = new int[M];
        if(d == 0) {
            for(int i=0; i<M; ++i) {
                int ni = i+k;
                if(ni >= M) ni -= M;
                temp[ni] = map[idx][i];
            }
        } else {
            for(int i=0; i<M; ++i) {
                int ni = i-k;
                if(ni < 0) ni += M;
                temp[ni] = map[idx][i];
            }
        }

        for(int i=0; i<M; ++i) map[idx][i] = temp[i];
    }

    static void check() {

        for(int r=0; r<N; ++r) {
            for(int c=0; c<M; ++c) {

                if(check[r][c] || map[r][c] == 0) continue;

                for(int d=0; d<4; ++d) {

                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];

                    if(nr<0 || nr>=N) continue;

                    if(nc < 0) nc = M-1;
                    else if(nc >= M) nc = 0;

                    if(map[r][c] == map[nr][nc]) {
                        existSame = true;
                        check[r][c] = check[nr][nc] = true;
                        break;
                    }
                }
            }
        }

    }

    static void remove() {
        for(int r=0; r<N; ++r) {
            for(int c=0; c<M; ++c) {
                if(check[r][c]) {
                    map[r][c] = 0;
                    check[r][c] = false;
                }
            }
        }
    }

    static double calAverage() {
        double cnt = 0, sum = 0;

        for(int r=0; r<N; ++r) {
            for(int c=0; c<M; ++c) {
                if(map[r][c] > 0) {
                    cnt++;
                    sum += map[r][c];
                }
            }
        }

        return (cnt>0)? sum/cnt : 0;
    }

    static void setMap(double avg) {
        for(int r=0; r<N; ++r) {
            for(int c=0; c<M; ++c) {
                if(map[r][c] == 0) continue;
                if(map[r][c] > avg) map[r][c]--;
                else if(map[r][c] < avg) map[r][c]++;
            }
        }
    }

    static int calTotal() {
        int total = 0;
        for(int r=0; r<N; ++r) {
            for(int c=0; c<M; ++c) {
                total += map[r][c];
            }
        }
        return total;
    }
}
