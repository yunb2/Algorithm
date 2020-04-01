package programmers.kakao;

import java.util.Arrays;

public class 징검다리건너기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,4,5,3,2,1,4,2,5,1}, 3));
//        System.out.println(solution(new int[] {0,0,0,4}, 3));
    }

    public static int solution(int[] stones, int k) {

        int answer = 0;
        int start = Arrays.stream(stones).min().getAsInt();
        int end = Arrays.stream(stones).max().getAsInt();

        while(start <= end) {

            int mid = (start + end) / 2;

            if(cross(mid, stones.clone(), k)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return answer;
    }

    public static boolean cross(int num, int[] stones, int k) {

        Arrays.setAll(stones, i -> (stones[i] - num + 1));

        int max = 0, cnt = 0;

        for(int stone : stones) {
            if(cnt > 0 && stone > 0) {
                max = Math.max(max, cnt);
                cnt = 0;
            } else if(stone <= 0) {
                cnt++;
            }
        }

        return Math.max(max, cnt) < k;
    }

}
