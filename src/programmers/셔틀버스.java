package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 셔틀버스 {

    public static void main(String[] args) {

        int n = 1;
        int t = 1;
        int m = 5;
        String[] timetable = {
                "08:00", "08:01", "08:02", "08:03"
        };

        System.out.println(solution(n, t, m, timetable));
    }

    public static String solution(int n, int t, int m, String[] timetable) {

        List<String> busTimeTable = makeBusTimeTable(n, t);
        String lastBusTime = busTimeTable.get(n-1);
        PriorityQueue<String> crew = Arrays.stream(timetable)
                                        .collect(Collectors.toCollection(PriorityQueue::new));

        for(int i=0; i<n; ++i) {
            String busTime = busTimeTable.get(i);
            for(int j=0; j<((i < n-1)? m : (m-1)); ++j) {
                if(crew.isEmpty()) return lastBusTime;
                if(crew.peek().compareTo(busTime)>0) break;
                crew.poll();
            }
        }

        if(crew.isEmpty()) return lastBusTime;

        String time = minusOneMin(crew.poll());
        return (lastBusTime.compareTo(time)<0)? lastBusTime : time;
    }

    public static List<String> makeBusTimeTable(int n, int t) {

        List<String> busTimeTable = new LinkedList<>();
        int h = 9, m = 0;

        for(int i=0; i<n; ++i) {
            busTimeTable.add(String.format("%02d:%02d", h, m));
            if((m += t) >= 60) {
                h++;
                m -= 60;
            }
        }

        return busTimeTable;
    }

    public static String minusOneMin(String time) {

        String[] tmp = time.split(":");
        int h = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        if(m > 0) {
            m -= 1;
        } else {
            h -= 1;
            m = 59;
        }

        return String.format("%02d:%02d", h, m);
    }

}
