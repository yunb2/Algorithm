package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 스도쿠 {

    static int[][] board;
    static List<int[]> blanks;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        blanks = new LinkedList<>();
        board = new int[9][9];
        for(int i=0; i<9; ++i) {
            String row = br.readLine();
            for(int j=0; j<9; ++j) {
                board[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
                if(board[i][j] == 0) blanks.add(new int[] {i, j});
            }
        }

        for(int i=1; i<=9; ++i) {
            if(go(0, i)) break;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<9; ++i) {
            for(int j=0; j<9; ++j) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    public static boolean go(int index, int num) {

        if(index == blanks.size()) return true;

        int r = blanks.get(index)[0];
        int c = blanks.get(index)[1];

        if(!check(r, c, num)) return false;

        board[r][c] = num;

        for(int i=1; i<=9; ++i) {
            if(go(index+1, i)) return true;
        }

        board[r][c] = 0;

        return false;
    }

    public static boolean check(int r, int c, int num) {

        for(int i=0; i<9; ++i) if(board[r][i] == num) return false;

        for(int i=0; i<9; ++i) if(board[i][c] == num) return false;

        int sr = 3*(r/3);
        int sc = 3*(c/3);
        for(int nr = sr; nr < sr+3; ++nr) {
            for(int nc = sc; nc < sc+3; ++nc) {
                if(board[nr][nc] == num) return false;
            }
        }

        return true;
    }

}
