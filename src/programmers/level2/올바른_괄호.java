package programmers.level2;

import java.util.Stack;

public class 올바른_괄호 {

	public static void main(String[] args) {
		String s= "()(()";
		boolean answer = solution(s);
		System.out.println(answer);
	}
	
	public static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length();i++) {
			char temp = s.charAt(i); 
			if(stack.isEmpty() || temp=='(') {
				stack.add(temp);
			}else if(temp==')') {
				stack.pop();
			}else {
				return false;
			}
		}
		
		return stack.isEmpty();
	}
}
