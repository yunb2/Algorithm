package programmers;

public class 타겟넘버 {

    public int solution(int[] numbers, int target) {
        return go(0, numbers, target);
    }

    public int go(int index, int[] numbers, int sum) {

        if(index == numbers.length) {
            return (sum == 0)? 1 : 0;
        }

        int cnt = 0;

        cnt += go(index+1, numbers, sum + numbers[index]);
        cnt += go(index+1, numbers, sum - numbers[index]);

        return cnt;
    }

}
