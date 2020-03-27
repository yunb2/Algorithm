package codility.lesson;

public class TapeEquilibrium {

    public int solution(int[] A) {

        int left = 0, right = 0;
        for(int a : A) right += a;

        int min = Integer.MAX_VALUE;
        for(int i=0; i<A.length-1; ++i) {
            left += A[i];
            right -= A[i];

            min = Math.min(min, Math.abs(left - right));
        }

        return min;
    }

}
