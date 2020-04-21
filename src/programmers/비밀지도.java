package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 비밀지도 {

    public static void main(String[] args) {

        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};
        String[] answer = solution(n, arr1, arr2);

        System.out.println(Arrays.toString(answer));
        System.out.println(Arrays.toString(new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "}));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        return IntStream.range(0, n)
                    .map(i -> arr1[i]|arr2[i])
                    .mapToObj(num -> Integer.toBinaryString(num)
                                            .replaceAll("0", " ")
                                            .replaceAll("1", "#")
                    )
                    .map(str -> String.format("%"+n+"s", str))
                    .toArray(String[]::new);
    }

}
