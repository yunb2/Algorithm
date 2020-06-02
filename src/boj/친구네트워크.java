package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 친구네트워크 {

    static int T, F;
    static HashMap<String, String> leaderMap;
    static HashMap<String, Integer> cntMap;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        leaderMap = new HashMap<>();
        cntMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; ++t) {

            F = Integer.parseInt(br.readLine());

            for(int i=0; i<F; ++i) {
                String[] friends = br.readLine().split(" ");
                sb.append(union(friends[0], friends[1])).append('\n');
            }

            leaderMap.clear();
            cntMap.clear();
        }

        System.out.println(sb.toString());
    }

    public static int union(String f1, String f2) {

        String l1 = find(f1);
        String l2 = find(f2);

        if (l1.equals(l2)) return cntMap.get(l1);

        int sum = cntMap.getOrDefault(l1, 1) + cntMap.getOrDefault(l2, 1);

        if(l1.compareTo(l2) < 0) {
            cntMap.put(l2, sum);
            leaderMap.put(l1, l2);
        } else {
            cntMap.put(l1, sum);
            leaderMap.put(l2, l1);
        }

        return sum;
    }

    public static String find(String name) {

        String leader = leaderMap.getOrDefault(name, name);
        if(leader.equals(name)) return name;

        leader = find(leader);
        leaderMap.put(name, leader);
        return leader;
    }

}
