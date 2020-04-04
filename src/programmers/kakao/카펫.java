package programmers.kakao;

public class 카펫 {

    public int[] solution(int brown, int red) {

        int[] answer = new int[2];

        for(int i=1; i<=Math.sqrt(red); ++i) {

            if(red % i > 0) continue;

            int w = red/i + 2, h = i + 2;

            if(brown == 2*(h+w)-4) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }

        return answer;
    }

}
