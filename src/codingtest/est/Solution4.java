package codingtest.est;

import java.util.HashMap;

public class Solution4 {

    public static void main(String[] args) {
        System.out.println(solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker", "Example"));
    }

    public static String solution(String S, String C) {

        String[] names = S.split("; ");
        StringBuilder answer = new StringBuilder();

        HashMap<String, Integer> idCnt = new HashMap<>();

        for(String name : names) {
            answer.append(name)
                    .append(" <")
                    .append(makeId(name, idCnt))
                    .append("@")
                    .append(C.toLowerCase())
                    .append(".com>; ");
        }

        return answer.delete(answer.length()-2, answer.length()).toString();
    }

    public static String makeId(String name, HashMap<String, Integer> idCnt) {

        String[] part = name.split(" ");

        String first = part[0].toLowerCase();
        String last = part[part.length-1].replace("-", "").toLowerCase();

        String id = last + "_" + first;

        int num = idCnt.getOrDefault(id, 1);
        idCnt.put(id, num+1);

        return id + ((num > 1)? num : "");
    }

}
