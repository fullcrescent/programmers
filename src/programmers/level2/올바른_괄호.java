package programmers.level2;

import java.util.Stack;

public class 올바른_괄호 {

	public static void main(String[] args) {
		String s= "()(()";
		boolean answer = solution(s);
		System.out.println(answer);
		
		String s1= "()(()";
		boolean answer1 = solution1(s1);
		System.out.println(answer1);
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
	
	// 다른 사람의 풀이 참고
	public static boolean solution1(String s) {
		int count = 0;
		
		for(char temp : s.toCharArray()) {
			if(temp=='(') {
				count++;
			}else {
				count--;
			}
			if(count<0) {
				return false;
			}
		}
		
		return count==0;
	}
}
