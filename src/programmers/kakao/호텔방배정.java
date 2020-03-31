package programmers.kakao;

import java.util.Arrays;
import java.util.HashMap;

class 호텔방배정 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, new long[]{1, 3, 4, 1, 3, 1})));
    }

    static HashMap<Long, Long> rooms;

    public static long[] solution(long k, long[] room_number) {

        rooms = new HashMap<>();

        return Arrays.stream(room_number)
                        .map(호텔방배정::findRoom)
                        .toArray();
    }

    public static long findRoom(long num) {

        if(!rooms.containsKey(num)) {
            rooms.put(num, rooms.getOrDefault(num+1, num+1));
            return num;
        }

        long next = findRoom(rooms.get(num));

        rooms.put(num, next);
        return next;
    }

}