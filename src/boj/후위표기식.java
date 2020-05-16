package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<origin.length(); ++i) {

            char c = origin.charAt(i);

            if(c=='(') {
                stack.push('(');
            } else if(c==')') {
                while(stack.peek()!='(') answer.append(stack.pop());
                stack.pop();
            } else if(c>='A' && c<='Z') {
                answer.append(c);
            } else if(c=='+' || c=='-') {
                while(!stack.isEmpty() && stack.peek()!='(') answer.append(stack.pop());
                stack.push(c);
            } else if(c=='*' || c=='/') {
                while(!stack.isEmpty() && (stack.peek()=='*' || stack.peek()=='/')) answer.append(stack.pop());
                stack.push(c);
            }

        }

        while(!stack.isEmpty()) answer.append(stack.pop());

        System.out.println(answer.toString());
    }

}
