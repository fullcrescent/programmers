package programmers.level2;

import java.util.Stack;

public class 짝지어_제거하기 {

	public static void main(String[] args) {
		String s = "baabaa";
		int answer = solution(s);
		System.out.println(answer);
		
		String s1 = "baabaa";
		int answer1 = solution1(s1);
		System.out.println(answer1);
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
	
	// 다른 사람의 풀이 참고 - 변경X
	public static int solution1(String s) {
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
