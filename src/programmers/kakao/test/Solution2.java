package programmers.kakao.test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution2 {

    public static void main(String[] args) {
        int[] answer = solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"	);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(String s) {

        List<int[]> list = new LinkedList<>();

        Matcher matcher = Pattern.compile("\\{[\\w,]+}").matcher(s);
        while(matcher.find()) {

            String[] str = matcher.group().split("\\D");

            int[] set = new int[str.length - 1];
            for(int i=0; i<set.length; ++i) {
                set[i] = Integer.parseInt(str[i+1]);
            }

            list.add(set);
        }

        List<Integer> answer = new ArrayList<>();
        list.sort(Comparator.comparingInt(o -> o.length));

        for(int[] set : list) {
            for(int n : set) {
                if(answer.contains(n)) continue;
                answer.add(n);
                break;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

}
