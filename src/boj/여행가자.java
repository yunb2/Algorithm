package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 여행가자 {

    static int N, M;
    static int[] root;
    static int[][] table;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        root = new int[N];
        for(int i=0; i<N; ++i) root[i] = i;

        table = new int[N][N];
        for(int i=0; i<N; ++i) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                table[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i=0; i<N; ++i) {
            for(int j=i+1; j<N; ++j) {
                if(table[i][j] == 1) union(i, j);
            }
        }

        String answer = "YES";
        String[] path = br.readLine().split(" ");
        int root = find(Integer.parseInt(path[0]) - 1);
        for(int i=1; i<M; ++i) {
            int next = Integer.parseInt(path[i]) - 1;
            if(find(next) != root) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);

    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        root[Math.max(rootA, rootB)] = Math.min(rootA, rootB);
    }

    public static int find(int a) {
        if(root[a] == a) return a;
        return root[a] = find(root[a]);
    }

}
