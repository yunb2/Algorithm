package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 숫자고르기 {

    static int N;
    static int[] table;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        table = new int[N+1];

        for(int i=1; i<=N; ++i) {
            table[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; ++i) {
            if(check(i)) list.add(i);
        }

        System.out.println(list.size());
        for(int i : list) System.out.println(i);

    }

    public static boolean check(int start) {

        boolean[] visit = new boolean[N+1];

        int next = start;
        while(true) {
            if(table[next] == start) return true;
            if(visit[table[next]]) return false;
            next = table[next];
            visit[next] = true;
        }

    }

}
