package boj;

import java.util.Scanner;

public class 좋은수열 {

    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(0, "");

    }

    public static boolean dfs(int n, String sequence) {

        if(!check(sequence)) return false;

        if(n == N) {
            System.out.println(sequence);
            return true;
        }

        if(dfs(n+1, sequence + "1")) return true;

        if(dfs(n+1, sequence + "2")) return true;

        return dfs(n+1, sequence + "3");
    }

    public static boolean check(String sequence) {

        int len = sequence.length();
        for(int l=1; l<=len/2; ++l) {

            String sub1 = sequence.substring(len-l, len);
            String sub2 = sequence.substring(len-2*l, len-l);

            if(sub1.equals(sub2)) return false;
        }

        return true;
    }
}
