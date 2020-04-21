package programmers;

import java.util.HashSet;

public class 소수찾기 {

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    static HashSet<Integer> prime, answer;
    static int[] num;

    public static int solution(String numbers) {

        init(numbers);

        go(0, 0, "");

        return answer.size();
    }

    public static void go(int index, int bit, String number) {

        if(index > 0) {
            int n = Integer.parseInt(number);
            if(prime.contains(n)) answer.add(n);
        }

        if(index == num.length) return;

        for(int i=0; i<num.length; ++i) {
            if(((bit >> i) & 1) == 1) continue;
            go(index + 1, bit | (1 << i), number+num[i]);
        }

    }

    public static void init(String numbers) {

        prime = new HashSet<>();
        answer = new HashSet<>();
        num = new int[numbers.length()];

        final int MAX = 9999999;
        boolean[] check = new boolean[MAX+1];

        for(int i=2; i<=MAX; ++i) {
            if(check[i]) continue;
            prime.add(i);
            for(int j=i; j<=MAX; j+=i) check[j] = true;
        }

        for(int i=0; i<num.length; ++i) {
            num[i] = numbers.charAt(i) - '0';
        }
    }

}
