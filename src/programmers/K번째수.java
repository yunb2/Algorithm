package programmers;

import java.util.Arrays;

public class K번째수 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1,5,2,6,3,7,4}, new int[][] {{2,5,3},{4,4,1},{1,7,3}})));
    }

    public static int[] solution(int[] array, int[][] commands) {

        return Arrays.stream(commands)
                    .mapToInt(c -> Arrays.stream(array, c[0] - 1, c[1])
                                                .sorted()
                                                .skip(c[2]-1)
                                                .findFirst()
                                                .getAsInt()
                    )
                    .toArray();
    }

}
