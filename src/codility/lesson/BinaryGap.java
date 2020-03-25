package codility.lesson;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(solution(1041));
        System.out.println(solution(32));
    }

    public static int solution(int N) {

        String binary = Integer.toBinaryString(N);
        int max = 0, cnt = 0;

        for(int i=1; i<binary.length(); ++i) {

            if(binary.charAt(i) == '0') {
                cnt ++;
                continue;
            }

            max = Math.max(max, cnt);
            cnt = 0;
        }

        return max;
    }

}
