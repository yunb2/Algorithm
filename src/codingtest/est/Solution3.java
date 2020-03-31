package codingtest.est;

import java.util.stream.IntStream;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,4,5,3,7}));
        System.out.println(solution(new int[] {1,2,3,4}));
        System.out.println(solution(new int[] {1,3,1,2}));
    }

    public static int solution(int[] A) {

        if(isAesthetic(A)) return 0;

        int cnt = 0;

        for(int i=0; i<A.length; ++i) {

            int cutTree = i;
            int[] newA = IntStream.range(0, A.length)
                                .filter(j -> j != cutTree)
                                .map(j -> A[j])
                                .toArray();

            if(isAesthetic(newA)) cnt++;
        }

        return (cnt > 0)? cnt : -1;
    }

    public static boolean isAesthetic(int[] A) {

        int before = A[1] - A[0];

        for(int i=1; i<A.length-1; ++i) {

            int cur = A[i+1] - A[i];

            if(before * cur >= 0) return false;
            before = cur;
        }

        return true;
    }

}
