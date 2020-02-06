import java.util.HashMap;
import java.util.Stack;

public class Solution3 {

	public static void main(String[] args) {
		System.out.println(solution("3+[(5+1)-1]"));
		System.out.println(solution("3+([5+1])"));
		System.out.println(solution("3+{(5+1}"));
		System.out.println(solution("3+[{(5+1)-1}+3]"));
	}
	
	public static boolean solution(String input) {
		Stack<Character> brackets = new Stack<>(); 
		HashMap<Character, Character> map = new HashMap<>();
		
		map.put(']', '[');
		map.put('}', '{');
		map.put(')', '(');
		
		for(char c : input.toCharArray()) {
			switch(c) {
			case '[':
				if(!brackets.isEmpty()) return false;
				brackets.push('['); 
				break;
			case '{':
				if(!brackets.isEmpty() && brackets.peek()!='[') return false;
				brackets.push('{'); 
				break;
			case '(': 
				if(!brackets.isEmpty() && brackets.peek()=='(') return false;
				brackets.push('('); 
				break;
			case ']':
			case '}':
			case ')':
				if(brackets.isEmpty() || brackets.pop()!=map.get(c)) return false;
				break;
			}
		}
		
		return true;
	}
	
}
