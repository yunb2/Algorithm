package programmers.kakao;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class 후보키 {

    public static void main(String[] args) {
        String[][] relation = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };

        System.out.println(solution(relation));
    }

    static List<Integer> candidateKeys;
    static int COL, ROW;

    public static int solution(String[][] relation) {
        candidateKeys = new LinkedList<>();
        COL = relation[0].length;
        ROW = relation.length;

        for(int i = 1; i < Math.pow(2, COL); ++i) {
            if(!checkMinimality(i)) continue;
            if(!checkUniqueness(i, relation)) continue;
            candidateKeys.add(i);
        }

        return candidateKeys.size();
    }

    public static boolean checkMinimality(int key) {
        for (int candidateKey : candidateKeys) {
            if((key & candidateKey) == candidateKey) return false;
        }
        return true;
    }

    public static boolean checkUniqueness(int key, String[][] relatation) {
        List<Integer> keys = new LinkedList<>();
        for(int i = 0; i < COL; ++i) {
            if(((key >> i) & 1) == 1) keys.add(i);
        }

        Set<String> set = new HashSet<>();
        for(String[] r : relatation) {
            StringBuilder sb = new StringBuilder();
            for(int k : keys) sb.append(r[k]).append("/");

            if(set.contains(sb.toString())) return false;
            set.add(sb.toString());
        }

        return true;
    }
}
