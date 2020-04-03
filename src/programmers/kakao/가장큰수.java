package programmers.kakao;

import java.util.Arrays;

public class 가장큰수 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {6,10,2}));
        System.out.println(solution(new int[] {3,30,34,5,9}));
        System.out.println(solution(new int[] {0,0}));
    }

    public static String solution(int[] numbers) {

        StringBuilder answer = new StringBuilder();

        Arrays.stream(numbers)
                .boxed()
                .sorted((o1, o2) -> {
                    String s1 = o1.toString() + o2.toString();
                    String s2 = o2.toString() + o1.toString();

                    return s2.compareTo(s1);
                })
                .forEach(answer::append);

        return (answer.charAt(0) == '0')? "0" : answer.toString();
    }

}
