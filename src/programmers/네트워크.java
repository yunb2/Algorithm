package programmers;

import java.util.Arrays;

public class 네트워크 {


    public static void main(String[] args) {
//        System.out.println(solution(3, new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(solution(3, new int[][] {{1,0,0},{0,1,0},{0,0,1}}));
//        System.out.println(solution(1, new int[][] {{1}}));
//        System.out.println(solution(4, new int[][] {{1,1,1,1}, {1,1,1,0}, {1,1,1,0}, {1,0,0,1}}));
    }

    public static int[] root;

    public static int solution(int n, int[][] computers) {

        root = new int[n];
        for(int i=0; i<n; ++i) root[i] = i;

        for(int i=0; i<n; ++i) {
            for(int j=0; j<n; ++j) {
                if(find(i) != find(j) && computers[i][j] == 1) union(i, j);
            }
        }

        return (int) Arrays.stream(root).distinct().count();
    }

    public static void union(int n1, int n2) {
        int r1 = find(n1);
        int r2 = find(n2);

        root[Math.max(r1, r2)] = Math.min(r1, r2);
    }

    public static int find(int n) {
        if(root[n] == n) return n;
        return root[n] = find(root[n]);
    }

}
