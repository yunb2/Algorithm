package codingtest.line;

import java.util.*;
import java.util.stream.Collectors;

public class Solution4 {

    public static void main(String[] args) {
    }

    public static String[][] solution(String[][] snapshots, String[][] transactions) {

        HashMap<String, Long> account = new HashMap<>();

        for(int i=0; i<snapshots.length; ++i) {
            account.put(snapshots[i][0], Long.parseLong(snapshots[i][1]));
        }

        List<String[]> list = Arrays.stream(transactions)
                                    .sorted(Comparator.comparing(o -> o[0]))
                                    .collect(Collectors.toList());

        int before = 0;
        for(String[] t : list) {

            int id = Integer.parseInt(t[0]);
            if(id == before) continue;
            before = id;

            if(!account.containsKey(t[2])) account.put(t[2], 0L);

            if(t[1].equals("SAVE")) {
                account.put(t[2], account.get(t[2]) + Long.parseLong(t[3]));
            } else {
                account.put(t[2], account.get(t[2]) - Long.parseLong(t[3]));
            }

        }

        String[][] answer = new String[account.size()][2];
        int i = 0;
        for (String key : account.keySet()) {
            answer[i][0] = key;
            answer[i][1] = String.valueOf(account.get(key));
            i++;
        }

        return Arrays.stream(answer)
                    .sorted(Comparator.comparing(o -> o[0]))
                    .toArray(a -> answer);
    }

}
