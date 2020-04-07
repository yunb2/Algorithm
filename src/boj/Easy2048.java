package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Easy2048 {

    static int N, max;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        max = 0;
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i=0; i<N; ++i) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                board[i][j] = Integer.parseInt(str[j]);
                max = Math.max(max, board[i][j]);
            }
        }

        go(0, board);

        System.out.println(max);
    }

    public static void go(int index, int[][] board) {

        if(index == 5) return;

        for(int i=0; i<4; ++i) {
            go(index+1, updateBoard(copyBoard(board)));
            board = turnBoard(board);
        }
    }

    public static int[][] copyBoard(int[][] board) {

        int[][] copyBoard = new int[N][N];

        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                copyBoard[i][j] = board[i][j];
            }
        }

        return copyBoard;
    }

    public static int[][] turnBoard(int[][] board) {

        int[][] turnBoard = new int[N][N];

        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                turnBoard[i][j] = board[j][N-i-1];
            }
        }

        return turnBoard;
    }

    public static int[][] updateBoard(int[][] board) {

        boolean[][] check = new boolean[N][N];

        for(int i=1; i<N; ++i) {
            for(int j=0; j<N; ++j) {

                if(board[i][j] == 0) continue;

                int k = i;
                while(k > 0 && board[k-1][j] == 0) {
                    board[k-1][j] = board[k][j];
                    board[k][j] = 0;
                    k--;
                }

                if(k > 0 && board[k-1][j] == board[k][j] && !check[k-1][j]) {
                    board[k-1][j] += board[k][j];
                    board[k][j] = 0;
                    check[k-1][j] = true;
                    max = Math.max(max, board[k-1][j]);
                }

            }
        }

        return board;
    }
}
