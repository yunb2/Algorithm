package programmers;

public class 보행자천국 {

    public static void main(String[] args) {
        int[][] cityMap = {
                {0, 0, 0},
                {0, 2, 2},
                {0, 2, 0}
        };

        System.out.println(solution(3, 3, cityMap));

    }

    static int MOD = 20170805;

    public static int solution(int m, int n, int[][] cityMap) {

        Node[][] nodes = init(m, n, cityMap);

        for(int r=1; r<m; ++r) {
            for(int c=1; c<n; ++c) {

                if(cityMap[r][c] == 1) continue;

                nodes[r][c].top = nodes[r-1][c].getTop(cityMap[r-1][c]);
                nodes[r][c].left = nodes[r][c-1].getLeft(cityMap[r][c-1]);
            }
        }

        return (nodes[m-1][n-1].top + nodes[m-1][n-1].left) % MOD;
    }

    public static Node[][] init(int m, int n, int[][] cityMap) {

        Node[][] nodes = new Node[m][n];

        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                nodes[i][j] = new Node(0, 0);
            }
        }

        for(int i=0; i<m && cityMap[i][0] != 1; ++i) nodes[i][0].top = 1;
        for(int i=0; i<n && cityMap[0][i] != 1; ++i) nodes[0][i].left = 1;

        return nodes;
    }

    static class Node {
        int top, left;

        Node(int top, int left) {
            this.top = top;
            this.left = left;
        }

        int getTop(int map) {
            return (map == 2)? top : (top + left) % MOD;
        }

        int getLeft(int map) {
            return (map == 2)? left : (top + left) % MOD;
        }
    }

    public static void print(Node[][] cnt, int m, int n) {
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                System.out.print(cnt[i][j].top + "/" + cnt[i][j].left + " ");
            }
            System.out.println();
        }
    }

}
