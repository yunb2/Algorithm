package practice.stream;

import java.util.ArrayList;

public class StreamInterfaceExample {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(50);
        myList.add(10);
        myList.add(80);
        myList.add(70);
        myList.add(90);
        myList.add(60);
        myList.add(20);

        System.out.print("점수 목록 : ");
        myList.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        System.out.print("최저 점수 : ");
        myList.stream().min(Integer::compare).ifPresent(System.out::println);

        System.out.print("최고 점수 : ");
        myList.stream().max(Integer::compare).ifPresent(System.out::println);

        System.out.print("점수 정렬 : ");
        myList.stream().sorted(Integer::compare).forEach((n) -> System.out.print(n + " "));
        System.out.println();

        System.out.print("낙제 점수 : ");
        myList.stream().filter((n) -> n < 60).forEach((n) -> System.out.print(n + " "));
        System.out.println();

        System.out.print("점수 합계 : ");
        myList.stream().reduce(Integer::sum).ifPresent(System.out::println);

        System.out.print("5점 추가 : ");
        myList.stream().map((n) -> n+5).forEach((n) -> System.out.print(n + " "));
        System.out.println();

        System.out.println("점수 개수 : " + myList.size());

    }

}
