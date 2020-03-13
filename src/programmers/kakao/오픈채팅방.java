package programmers.kakao;

import java.util.*;

public class 오픈채팅방 {

    public static void main(String[] args) {

    }

    public static String[] solution(String[] record) {

        List<String> tempList = new LinkedList<>();
        HashMap<String, String> nickname = new HashMap<>();
        for(String r : record) {
            String[] str = r.split(" ");
            switch (str[0]) {
                case "Enter":
                    nickname.put(str[1], str[2]);
                    tempList.add(str[1]+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    tempList.add(str[1]+"님이 나갔습니다.");
                    break;
                case "Change":
                    nickname.put(str[1], str[2]);
                    break;
            }
        }

        return tempList.stream().parallel()
                .map(temp -> {
                    String uid = temp.split("님")[0];
                    return temp.replace(uid, nickname.get(uid));
                })
                .toArray(String[]::new);
    }

}
