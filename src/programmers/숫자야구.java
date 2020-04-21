package programmers;

public class 숫자야구 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{123,1,1},{356,1,0},{327,2,0},{489,0,1}}));
    }

    public static int solution(int[][] baseball) {

        int answer = 0;

        for(int i=1; i<10; ++i) {
            for(int j=1; j<10; ++j) {

                if(i == j) continue;

                for(int k=1; k<10; ++k) {

                    if(j == k) continue;

                    String num = "" + i + j + k;

                    if(isAnswer(num, baseball)) answer++;

                }
            }
        }

        return answer;
    }

    public static boolean isAnswer(String num, int[][] baseball) {

        for(int i=0; i<baseball.length; ++i) {

            String n = String.valueOf(baseball[i][0]);
            int s = 0, b = 0;

            for(int j=0; j<3; ++j) {
                for(int k=0; k<3; ++k) {
                    if(num.charAt(j) == n.charAt(k)) {
                        if(j == k) s++;
                        else b++;
                    }
                }
            }

            if(s != baseball[i][1] || b != baseball[i][2]) return false;
        }

        return true;
    }

}
