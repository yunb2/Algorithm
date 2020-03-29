package programmers.kakao.test;

import java.util.HashSet;
import java.util.Set;

class Solution4 {

    public long[] solution(long k, long[] room_number) {

        long[] answer = new long[room_number.length];
        Set<Long> set = new HashSet<>();

        for(int i=0; i<room_number.length; ++i) {

            long num = room_number[i];

            if(!set.contains(num)) {
                set.add(num);
                answer[i] = num;
                continue;
            }

            for(long n=num+1; n<=k; ++n) {
                if(!set.contains(n)) {
                    set.add(n);
                    answer[i] = n;
                    break;
                }
            }

        }

        return answer;
    }

}