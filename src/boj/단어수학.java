package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 단어수학 {

    static int N;
    static String[] words;
    static Number[] numbers;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new Number[26];
        for(int i=0; i<26; ++i) {
            numbers[i] = new Number((char) ('A'+i));
        }

        words = new String[N];
        for(int i=0; i<N; ++i) {
            words[i] = br.readLine();
            int score = 1;
            for(int j=words[i].length()-1; j>=0; --j) {
                char c = words[i].charAt(j);
                numbers[c-'A'].score += score;
                score *= 10;
            }
        }

        PriorityQueue<Number> q = new PriorityQueue<>();
        for(int i=0; i<26; ++i) q.add(numbers[i]);

        int[] num = new int[26];
        for(int i=9; i>=0; --i) {
            num[q.poll().c - 'A'] = i;
        }

        int total = 0;
        for(int i=0; i<N; ++i) {
            int temp = 0;
            for(int j=0; j<words[i].length(); ++j) {
                temp = temp*10 + num[words[i].charAt(j) - 'A'];
            }
            total += temp;
        }

        System.out.println(total);

    }

    static class Number implements Comparable<Number> {
        char c;
        int score, n;

        public Number(char c) {
            this.c = c;
            score = n = 0;
        }

        @Override
        public int compareTo(Number o) {
            return o.score - this.score;
        }
    }

}
