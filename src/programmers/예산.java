package programmers;

import java.util.Arrays;

public class 예산 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,3,4,5,6,7,8,9,10}, 56));
    }

    static int max;

    public static int solution(int[] budgets, int M) {

        int right = Arrays.stream(budgets).max().getAsInt();
        int left = M / budgets.length;
        max = Math.min(left, right);

        binarySearch(budgets, M, left, right);

        return max;
    }

    public static void binarySearch(int[] budgets, int M, int left, int right) {

        if(left > right) return;

        int mid = (left + right) / 2;

        int res = M;
        for(int b : budgets) res -= Math.min(b, mid);

        if(res < 0) {
            binarySearch(budgets, M, left, mid-1);
        } else {
            max = Math.max(max, mid);
            binarySearch(budgets, M, mid+1, right);
        }

    }

}
