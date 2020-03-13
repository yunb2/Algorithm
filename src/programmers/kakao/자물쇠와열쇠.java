package programmers.kakao;

public class 자물쇠와열쇠 {

    public static void main(String[] args) {
        int[][] key = {
                {0,0,0},
                {1,0,0},
                {0,1,1}
        };

        int[][] lock = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        System.out.println(solution(key, lock));
    }

    public static void print(int[][] arr) {
        for(int i=0; i<arr.length; ++i) {
            for(int j=0; j<arr.length; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int N, M;

    public static boolean solution(int[][] key, int[][] lock) {

        M = key.length;
        N = lock.length;

        for(int d=0; d<4; ++d) {
            if(isFit(key, lock)) return true;
            key = turn(key);
        }

        return false;
    }

    public static boolean isFit(int[][] key, int[][] lock) {

        for(int sr=0; sr<N+M-1; ++sr) {
            for(int sc=0; sc<N+M-1; ++sc) {
                if(match(key, lock, sr, sc)) return true;
            }
        }

        return false;
    }

    public static boolean match(int[][] key, int[][] lock, int sr, int sc) {

        int[][] temp = new int[N+2*(M-1)][N+2*(M-1)];

        for(int r=sr; r<sr+M; ++r) {
            for(int c=sc; c<sc+M; ++c) {
                temp[r][c] = key[r-sr][c-sc];
            }
        }

        for(int r=M-1; r<N+M-1; ++r) {
            for(int c=M-1; c<N+M-1; ++c) {
                temp[r][c] += lock[r-M+1][c-M+1];
                if(temp[r][c] != 1) return false;
            }
        }

        print(temp);

        return true;
    }

    public static int[][] turn(int[][] key) {

        int[][] temp = new int[M][M];

        for(int r=0; r<M; ++r) {
            for(int c=0; c<M; ++c) {
                temp[r][c] = key[c][M-r-1];
            }
        }

        return temp;
    }
}
