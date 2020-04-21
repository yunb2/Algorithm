package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 여행경로 {

    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static String[] solution(String[][] tickets) {
        List<String[]> ticketList = Arrays.stream(tickets).collect(Collectors.toList());
        return go("ICN", ticketList).toArray(new String[0]);
    }

    public static LinkedList<String> go(String dep, List<String[]> tickets) {

        String[][] des = tickets.stream()
                                .filter(ticket -> ticket[0].equals(dep))
                                .sorted(Comparator.comparing(t -> t[1]))
                                .toArray(String[][]::new);

        for(String[] d : des) {

            tickets.remove(d);
            LinkedList<String> list = go(d[1], tickets);
            tickets.add(d);

            if(list.size() == tickets.size()) {
                list.addFirst(dep);
                return list;
            }
        }

        return new LinkedList<>(Collections.singleton(dep));
    }

}
