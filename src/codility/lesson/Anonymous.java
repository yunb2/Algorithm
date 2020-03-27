package codility.lesson;

public class Anonymous {

    public int solution(int[] A) {
        long N = A.length;
        long total = ((N+1) * (N+2)) / 2;
        for(int a : A) total -= a;

        return (int) total;
    }

}
