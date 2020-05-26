package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 소풍 {

    static int K, N, F;
    static boolean[][] map;
    static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        K = Integer.parseInt(str[0]); // 소풍 갈 학생 수
        N = Integer.parseInt(str[1]); // 총 학생 수
        F = Integer.parseInt(str[2]); // 친구 정보 수
        map = new boolean[N+1][N+1];
        stack = new Stack<>();

        for(int i=0; i<F; ++i) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            map[a][b] = map[b][a] = true;
        }

        for(int i=1; i<=N; ++i) {
            stack.push(i);
            if(dfs(i)) break;
            stack.pop();
        }

        if(stack.isEmpty()) System.out.println(-1);
        else for(int i : stack) System.out.println(i);

    }

    public static boolean dfs(int num) {

        if(stack.size() == K) {
            return true;
        }

        out:
        for(int i=num+1; i<=N; ++i) {

            if(!map[num][i]) continue;

            for(int s : stack) {
                if(!map[i][s]) continue out;
            }

            stack.push(i);
            if(dfs(i)) return true;
            stack.pop();
        }

        return false;
    }

}
