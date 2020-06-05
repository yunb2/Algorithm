package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 시험감독 {

    static int N, B, C;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        String[] str = br.readLine().split(" ");
        for(int i=0; i<N; ++i) A[i] = Integer.parseInt(str[i]);

        str = br.readLine().split(" ");
        B = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);

        long total = 0;
        for(int i=0; i<N; ++i) total += countViewer(A[i]);

        System.out.println(total);

    }

    public static int countViewer(int candidate) {

        int viewer = 1;

        if((candidate -= B) > 0) {
            viewer += candidate / C + ((candidate%C > 0)? 1 : 0);
        }

        return viewer;
    }

}
