package codility.lesson;

public class CyclicRotation {

    public int[] solution(int[] A, int K) {

        int[] answer = new int[A.length];

        for(int i=0; i<A.length; ++i) {
            answer[(i+K)%A.length] = A[i];
        }

        return answer;
    }

}
