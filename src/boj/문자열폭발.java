package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i=str.length()-1; i>=0; --i) {

            char c = str.charAt(i);

            if(c != bomb.charAt(0) || stack.size() < bomb.length()-1) {
                stack.push(c);
                continue;
            }

            StringBuilder sb = new StringBuilder(c+"");
            for(int j=0; j<bomb.length()-1; ++j) sb.append(stack.pop());

            if(sb.toString().equals(bomb)) continue;

            for(int j=sb.length()-1; j>=0; --j) stack.push(sb.charAt(j));
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());

        String answer = sb.toString();
        System.out.println(answer.isEmpty()? "FRULA" : answer);
    }

}
