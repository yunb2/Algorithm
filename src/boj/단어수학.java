package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 단어수학 {

    static int N, max;
    static String[] words;
    static HashMap<Character, Integer> map;
    static List<Character> list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = 0;
        words = new String[N];
        map = new HashMap<>();
        list = new LinkedList<>();
        for(int i=0; i<N; ++i) {
            words[i] = br.readLine();
            for(int j=0; j<words[i].length(); ++j) {
                char c = words[i].charAt(j);
                map.put(c, 0);
                if(!list.contains(c)) list.add(c);
            }
        }

        dfs(0, 0);

        System.out.println(max);

    }

    public static void dfs(int index, int bit) {

        if(index == list.size()) {
            max = Math.max(max, sum());
            return;
        }

        for(int i=9; i>9-list.size(); --i) {
            if(((bit>>i)&1) == 1) continue;
            map.put(list.get(index), i);
            dfs(index+1, bit | (1<<i));
        }

    }

    public static int sum() {
        int total = 0;
        for(String word : words) {
            int temp = 0;
            for(char c : word.toCharArray()) {
                temp = 10*temp + map.get(c);
            }
            total += temp;
        }
        return total;
    }

}
