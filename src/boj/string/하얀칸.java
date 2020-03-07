package boj.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class 하얀칸 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for(int i=0; i<8; ++i) {
            String str = br.readLine();
            final int REMINDER = i%2;
            sum += IntStream.range(0, 8)
                        .parallel()
                        .filter(n -> (n%2)==REMINDER)
                        .mapToObj(str::charAt)
                        .filter(c -> c.equals('F'))
                        .count();
        }

        System.out.println(sum);
    }

}
