package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 이차원배열과연산 {

    static int[][] A;
    static int r, c, k, lenR, lenC, max;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        r = Integer.parseInt(str[0])-1;
        c = Integer.parseInt(str[1])-1;
        k = Integer.parseInt(str[2]);
        lenR = lenC = 3;
        max = 0;

        A = new int[100][100];
        for(int i=0; i<3; ++i) {
            str = br.readLine().split(" ");
            for(int j=0; j<3; ++j) {
                A[i][j] = Integer.parseInt(str[j]);
            }
        }

        int t = -1;
        while(t++ <= 100) {

            if(A[r][c] == k) {
                System.out.println(t);
                return;
            }

            if(lenR >= lenC) {
                for(int i=0; i<lenR; ++i) A[i] = sortArr(A[i]);
                lenC = max;
            } else {
                int[] temp = new int[100];
                for(int i=0; i<lenC; ++i) {
                    for(int j=0; j<100; ++j) temp[j] = A[j][i];
                    temp = sortArr(temp);
                    for(int j=0; j<100; ++j) A[j][i] = temp[j];
                }
                lenR = max;
            }

            max = 0;
        }

        System.out.println(-1);
    }

    public static int[] sortArr(int[] arr) {

        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : arr) {
            if(num == 0) continue;
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> (o1[1] == o2[1])? (o1[0] - o2[0]) : (o1[1] - o2[1]));
        for(int num : cnt.keySet()) q.add(new int[] {num, cnt.get(num)});

        int[] sorted = new int[100];
        int i = 0;

        while(i<100 && !q.isEmpty()) {
            int[] temp = q.poll();
            sorted[i++] = temp[0];
            sorted[i++] = temp[1];
        }

        max = Math.max(max, i);

        return sorted;
    }

}
