package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 모의고사 {

    public int[] solution(int[] answers) {

        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};

        int[] score = new int[3];

        for(int i=0; i<answers.length; ++i) {
            if(answers[i] == s1[i % s1.length]) score[0]++;
            if(answers[i] == s2[i % s2.length]) score[1]++;
            if(answers[i] == s3[i % s3.length]) score[2]++;
        }

        int max = Arrays.stream(score).max().getAsInt();

        List<Integer> list = new LinkedList<>();

        for(int i=0; i<score.length; ++i) if(score[i] == max) list.add(i+1);

        return list.stream().mapToInt(i -> i).toArray();
    }

}
