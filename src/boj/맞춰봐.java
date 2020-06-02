package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 맞춰봐 {

    static int N;
    static int[] A;
    static char[][] S;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        S = new char[N][N];

        String str = br.readLine();
        int idx = 0;
        for(int i=0; i<N; ++i) {
            for(int j=i; j<N; ++j) {
                S[i][j] = str.charAt(idx++);
            }
        }

        for(int i=-10; i<=10; ++i) {
            A[0] = i;
            if(go(0)) break;
        }

        for(int i=0; i<N; ++i) {
            System.out.print(A[i]+" ");
        }
    }

    public static boolean go(int idx) {

        for(int i=idx, sum = 0; i>=0; --i) {
            sum += A[i];
            if(!checkSign(i, idx, sum)) return false;
        }

        if(idx == N-1) return true;

        for(int i=-10; i<=10; ++i) {
            A[idx+1] = i;
            if(go(idx+1)) return true;
        }

        return false;
    }

    public static boolean checkSign(int i, int j, int sum) {
        char sign = S[i][j];
        return (sign != '+' || sum > 0) && (sign != '-' || sum < 0) && (sign != '0' || sum == 0);
    }

}
