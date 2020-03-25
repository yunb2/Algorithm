package codility.lesson;

import java.util.stream.IntStream;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(solution(1041));
        System.out.println(solution(32));
        System.out.println(solution(15));
    }

    public static int solution(int N) {

        String[] zeros = Integer.toBinaryString(N).split("1");

        if(zeros.length == 0) return 0;

        return IntStream.range(0, zeros.length + (N%2 - 1))
                        .map(i -> zeros[i].length())
                        .max()
                        .getAsInt();
    }

}
