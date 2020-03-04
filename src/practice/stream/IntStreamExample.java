package practice.stream;

import java.util.stream.IntStream;

public class IntStreamExample {

    public static void main(String[] args) {

        int[] score = {50, 10, 80, 70, 90, 60, 20};

        System.out.print("점수 목록 : ");
        IntStream.of(score).forEach((n) -> System.out.print(n + " "));
        System.out.println();

        int min = IntStream.of(score).min().getAsInt();
        System.out.println("최저 점수 : " + min);

        int max = IntStream.of(score).max().getAsInt();
        System.out.println("최고 점수 : " + max);

        System.out.print("점수 정렬 : ");
        IntStream.of(score).sorted().forEach((n) -> System.out.print(n + " "));
        System.out.println();

        System.out.print("낙제 점수 : ");
        IntStream.of(score).filter((n) -> n < 60).forEach((n) -> System.out.print(n + " "));
        System.out.println();

        int sum = IntStream.of(score).sum();
        System.out.println("점수 합계 : " + sum);

        System.out.print("5점 추가 : ");
        IntStream.of(score).map((n) -> n+5).forEach((n) -> System.out.print(n + " "));
        System.out.println();

        long cnt = IntStream.of(score).count();
        System.out.println("점수 개수 : " + cnt);

        System.out.println("점수 평균 : " + sum / cnt);

    }

}
