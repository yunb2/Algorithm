package programmers.kakao;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class 프렌즈4블록 {

    public static void main(String[] args) {

        String[] board = {
                "TTTANT",
                "RRFACC",
                "RRRFCC",
                "TRRRAA",
                "TTMMMF",
                "TMMTTJ"
        };

        System.out.println(solution(6, 6, board));

    }

    static int[][] map, tmp;

    public static int solution(int m, int n, String[] board) {

        init(m, n, board);

        while(check(m, n)) {
            erase(m, n);
            set(m, n);
        }

        return count();
    }

    public static void init(int m, int n, String[] board) {
        map = new int[m][n];
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                map[i][j] = board[i].charAt(j);
            }
        }
        tmp = new int[m][n];
    }

    public static boolean check(int m, int n) {
        boolean existBlock = false;

        for(int i=0; i<m-1; ++i) {
            for(int j=0; j<n-1; ++j) {
                int block = map[i][j];

                if(block == 0) continue;
                if(block != map[i+1][j]) continue;
                if(block != map[i][j+1]) continue;
                if(block != map[i+1][j+1]) continue;

                tmp[i][j] = tmp[i+1][j] = tmp[i][j+1] = tmp[i+1][j+1] = 1;
                existBlock = true;
            }
        }

        return existBlock;
    }

    public static void erase(int m, int n) {
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(tmp[i][j] == 1) map[i][j] = tmp[i][j] = 0;
            }
        }
    }

    public static void set(int m, int n) {
        Stack<Integer> temp = new Stack<>();
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                if(map[j][i]==0) continue;
                temp.push(map[j][i]);
                map[j][i] = 0;
            }
            int j = m-1;
            while(!temp.isEmpty()) map[j--][i] = temp.pop();
        }
    }

    private static int count() {
        return (int) Arrays.stream(map)
                .flatMapToInt(Arrays::stream)
                .filter(block -> block==0)
                .count();
    }

}
