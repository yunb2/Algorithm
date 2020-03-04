package practice.stream;

import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static void main(String[] args) {

        IntStream is = IntStream.rangeClosed(1, 10000000);
        long start = System.currentTimeMillis();
        int total = is.sum();
        long end = System.currentTimeMillis();
        System.out.println("순차 처리 : " + (end - start));

        IntStream is2 = IntStream.rangeClosed(1, 10000000);
        long start2 = System.currentTimeMillis();
        int total2 = is2.sum();
        long end2 = System.currentTimeMillis();
        System.out.println("병렬 처리 : " + (end2 - start2));


    }

}
