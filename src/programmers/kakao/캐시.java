package programmers.kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {

    public static void main(String[] args) {

        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul","NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));

    }

    public static int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>();
        return Arrays.stream(cities)
                    .mapToInt(city -> calTime(cache, cacheSize, city.toUpperCase()))
                    .sum();
    }

    public static int calTime(Queue<String> cache, int cacheSize, String city) {
        int time = 5;

        if(cache.contains(city)) {
            cache.remove(city);
            time = 1;
        }

        cache.offer(city);
        if(cache.size() > cacheSize) cache.poll();

        return time;
    }
}
