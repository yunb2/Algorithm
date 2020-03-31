package codingtest.est;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,8,2,3,3,2}));
        System.out.println(solution(new int[] {7,1,2,8,2}));
        System.out.println(solution(new int[] {3,1,4,1,5}));
        System.out.println(solution(new int[] {5,5,5,5,5}));
    }

    public static int solution(int[] A) {

        List<Integer> sortedA = Arrays.stream(A).boxed()
                                .sorted(Comparator.reverseOrder())
                                .collect(Collectors.toList());

        int cnt = 0, before = sortedA.get(0);
        for(int cur : sortedA) {

            if(before == cur) {
                cnt++;
                continue;
            }

            if(cnt == before) return before;

            cnt = 1;
            before = cur;
        }

        int last = sortedA.get(A.length-1);
        return (last == cnt)? last : 0;
    }

}
