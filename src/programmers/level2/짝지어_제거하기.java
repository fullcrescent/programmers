package programmers.level2;

import java.util.Stack;

public class 짝지어_제거하기 {

	public static void main(String[] args) {
		String s = "baabaa";
		int answer = solution(s);
		System.out.println(answer);
	}
	
	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		for(Character data : s.toCharArray()) {
			if(!stack.isEmpty() && stack.peek().equals(data)) {
				stack.pop();
			}else {
				stack.add(data);
			}
		}
		
		return stack.isEmpty() ? 1:0;
	}

}
