package programmers.kakao;

import java.util.Arrays;

public class 다트게임 {

    public static void main(String[] args) {

        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));

    }

    public static int solution(String dartResult) {
        int[] score = Arrays.stream(dartResult.split("\\D+")).mapToInt(Integer::parseInt).toArray();
        String[] ops = dartResult.split("\\d+");

        for(int i=0; i<3; ++i) {
            int tmp = score[i];
            String str = ops[i+1];
            for(int j=0; j<str.length(); ++j) {
                if(Character.isDigit(str.charAt(j))) continue;

                switch(str.charAt(j)) {
                    case 'S': break;
                    case 'D': tmp = (int)Math.pow(tmp, 2); break;
                    case 'T': tmp = (int)Math.pow(tmp, 3); break;
                    case '#': tmp *= -1; break;
                    case '*':
                        if (i > 0) score[i-1] *= 2;
                        tmp *= 2;
                        break;
                }
            }
            score[i] = tmp;
        }

        return score[0]+score[1]+score[2];
    }

}
