package codility.lesson;

import java.util.Arrays;

public class OddOccurrencesInArray {

    public int solution(int[] A) {

        int[] sorted = Arrays.stream(A).sorted().toArray();

        int answer = -1, cnt = 0;
        for(int a : sorted) {

            if(a == answer) { cnt++; continue; }

            if(cnt%2 == 1) return answer;

            answer = a;
            cnt = 1;
        }

        return answer;
    }

}
