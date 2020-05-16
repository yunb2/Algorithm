package boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 빵집 {

    static int R, C, cnt;
    static char[][] map;
    static int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        map = new char[R][C];
        cnt = 0;

        for (int i = 0; i < R; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; ++i) {
            for (int d = 0; d < 3; ++d) {
                if (go(i, 0, d)) break;
            }
        }

        System.out.println(cnt);
    }

    public static boolean go(int r, int c, int d) {

        if (c == C - 1 && map[r][c] == '.') {
            map[r][c] = 'x';
            cnt++;
            return true;
        }

        map[r][c] = 'x';

        int nr = r + dir[d][0];
        int nc = c + dir[d][1];

        if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == 'x') return false;

        for (int i = 0; i < 3; ++i) {
            if (go(nr, nc, i)) return true;
        }

        return false;
    }

}
