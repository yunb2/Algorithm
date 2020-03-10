package programmers.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 압축 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution("KAKAO")));
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(solution("ABABABABABABABAB")));

    }

    public static int[] solution(String msg) {

        List<Integer> answer = new LinkedList<>();
        HashMap<String, Integer> map = initMap();

        StringBuilder sb = new StringBuilder(msg);
        while(sb.length() > 0) {
            int index = 0;
            for(int i=0; i<sb.length(); ++i) {
                String substr = sb.substring(0, i+1);
                if(map.containsKey(substr)) {
                    index = map.get(substr);
                    if(i == sb.length()-1) sb.delete(0, i+1);
                    continue;
                }

                map.put(substr, map.size()+1);
                sb.delete(0, i);
                break;
            }
            answer.add(index);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static HashMap<String, Integer> initMap() {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<26; ++i) map.put(String.valueOf((char)('A'+i)), i+1);
        return map;
    }


}
