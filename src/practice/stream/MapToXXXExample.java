package practice.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class MapToXXXExample {

    public static void main(String[] args) {
        List<Double> list = new LinkedList<>();
        list.add(3.1);
        list.add(5.6);
        list.add(7.2);
        list.add(8.1);
        list.add(6.8);

        System.out.print("Cal 1 : ");
        long start = System.currentTimeMillis();
        Optional<Integer> sumVal = list.stream().map((n) -> (int)Math.ceil(n)).reduce(Integer::sum);
        long end = System.currentTimeMillis();
        System.out.println(sumVal.get()+"  "+ (end-start));

        System.out.print("Cal 2 : ");
        long start1 = System.currentTimeMillis();
        int sum1 = list.stream().parallel().mapToInt((n) -> (int)Math.ceil(n)).sum();
        long end1 = System.currentTimeMillis();
        System.out.println(sum1 + "  " + (end1-start1));

        System.out.print("Cal 3 : ");
        long start2 = System.currentTimeMillis();
        int sum2 = list.stream().mapToInt((n) -> (int)Math.ceil(n)).sum();
        long end2 = System.currentTimeMillis();
        System.out.println(sum2 + "  " + (end2-start2));

    }

}
