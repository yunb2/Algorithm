package programmers.kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 기둥과보설치 {

    public static void main(String[] args) {
        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}, {5, 2, 0, 1}, {5, 3, 0, 1}, {5, 4, 0, 1}, {5, 5, 0, 1}};
        int n = 5;
        int[][] answer = solution(n, build_frame);
        System.out.println(Arrays.deepToString(answer));

        build_frame = new int[][] {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}, {1, 1, 0, 1}};
        answer = solution(n, build_frame);
        System.out.println(Arrays.deepToString(answer));
    }

    static int[][] wall;
    static int[][] dir = {{0,0}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};

    public static int[][] solution(int n, int[][] build_frame) {

        wall = new int[n+1][n+1];

        for(int[] order : build_frame) {

            int x = order[0], y = order[1], a = order[2], b = order[3];

            if(b == 0) {
                int temp = wall[x][y];
                wall[x][y] &= ((a == 0)? 2 : 1);

                for(int d=0; d<9; ++d) {

                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];

                    if(nx < 0 || nx > n || ny < 0 || ny > n) continue;

                    if(wall[nx][ny] == 0) continue;

                    if(check(nx, ny, wall[nx][ny]-1)) continue;

                    wall[x][y] = temp;
                    break;
                }
            } else if(check(x, y, a)) {
                wall[x][y] |= ((a == 0)? 1 : 2);
            }

        }

        return makeAnswer();
    }

    public static boolean check(int x, int y, int a) {
        if(a == 0) {
            return  (y < wall.length-1) &&
                    (y == 0
                    || ((x > 0 && isBeam(wall[x-1][y]))
                    || isBeam(wall[x][y])
                    || isPillar(wall[x][y-1])));
        }

        if(a == 1) {
            return (x < wall.length-1 && y > 0) &&
                    (isPillar(wall[x][y-1])
                    || isPillar(wall[x+1][y-1])
                    || (x > 0 && isBeam(wall[x-1][y]) && isBeam(wall[x+1][y])));
        }

        return check(x, y, 0) & check(x, y, 1);
    }

    public static boolean isPillar(int v) {
        return (v & 1) == 1;
    }

    public static boolean isBeam(int v) {
        return ((v >> 1) & 1) == 1;
    }

    public static int[][] makeAnswer() {
        List<int[]> list = new LinkedList<>();
        for(int x=0; x<wall.length; ++x) {
            for(int y=0; y<wall.length; ++y) {
                if(isPillar(wall[x][y])) list.add(new int[] {x, y, 0});
                if(isBeam(wall[x][y])) list.add(new int[] {x, y, 1});
            }
        }

        int[][] answer = new int[list.size()][3];
        for(int i=0; i<list.size(); ++i) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
