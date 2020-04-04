package programmers.kakao;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class 이중우선순위큐 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "D 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I 7", "I 5", "I -5", "D -1"})));
    }

    public static int[] solution(String[] operations) {

        int[] answer = new int[2];

        LinkedList<Integer> list = new LinkedList<>();

        for(String op : operations) {

            if(list.isEmpty() && op.charAt(0) == 'D') {
                continue;
            }

            if(op.equals("D 1")) {
                list.removeLast();
                continue;
            }

            if(op.equals("D -1")) {
                list.removeFirst();
                continue;
            }

            int num = Integer.parseInt(op.replace("I ", ""));
            int index = Collections.binarySearch(list, num);
            if(index < 0) index = -1 * (index + 1);
            list.add(index, num);
        }

        if(list.size() > 0) {
            answer[0] = list.getLast();
            answer[1] = list.getFirst();
        }

        return answer;
    }

}
