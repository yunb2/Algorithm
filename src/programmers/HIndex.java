package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HIndex {

    public static void main(String[] args) {

        System.out.println(solution(new int[] {3,0,6,1,5})); // 6 5 3 1 0
        System.out.println(solution(new int[] {22, 25}));
    }

    public static int solution(int[] citations) {

        List<Integer> list = Arrays.stream(citations).boxed()
                                    .sorted(Comparator.reverseOrder())
                                    .collect(Collectors.toList());

        return IntStream.range(0, list.size())
                .filter(i -> list.get(i) <= i)
                .findFirst()
                .orElse(list.size());
    }

}
