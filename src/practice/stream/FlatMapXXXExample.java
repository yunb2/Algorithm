package practice.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapXXXExample {

    public static void main(String[] args) {

        String str = "12 10 13 18 14 16 17";

        int[] list = Stream.of(str).flatMapToInt(s -> Arrays.stream(s.split(" "))
                                    .mapToInt(Integer::parseInt)).toArray();

        System.out.println(Arrays.toString(list));

    }

}
