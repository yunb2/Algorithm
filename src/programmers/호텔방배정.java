package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class 호텔방배정 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, new long[]{1, 3, 4, 1, 3, 1})));
    }

    static Set<Long> rooms;
    static TreeSet<Long> nextRooms;

    public static long[] solution(long k, long[] room_number) {

        rooms = new HashSet<>();
        nextRooms = new TreeSet<>();

        return Arrays.stream(room_number)
                    .map(호텔방배정::findRoom)
                    .toArray();
    }

    public static long findRoom(long num) {

        if(rooms.contains(num)) return findRoom(nextRooms.higher(num));

        rooms.add(num);
        nextRooms.remove(num);

        if(!rooms.contains(num+1)) nextRooms.add(num+1);

        return num;
    }

}