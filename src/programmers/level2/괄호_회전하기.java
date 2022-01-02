package programmers.level2;

import java.util.Stack;

public class 괄호_회전하기 {
	public static void main(String args[]) {
		String s = "[](){}";
		int answer = solution(s);
		System.out.println(answer);
	}

	public static int solution(String s) {
		rotate(s, 0);
		
		return answer;
	}
	
	static int answer =0;
	
	private static void rotate(String s, int i) {
		if(i==s.length()-1) {
			return;
		}
		
		int index=0;
		
		Stack<Character> stack = new Stack<Character>();
		
		while(index<s.length())  {
			stack.add(s.charAt(index));
			
			if(stack.peek() == ')') {
				stack.pop();
				if(stack.isEmpty() || stack.pop() != '(') {
					break;
				}
			}else if(stack.peek() == '}') {
				stack.pop();
				if(stack.isEmpty() || stack.pop() != '{') {
					break;
				}
			}else if(stack.peek() == ']') {
				stack.pop();
				if(stack.isEmpty() || stack.pop() != '[') {
					break;
				}
			}
			
			index++;
		}
		
		if(index==s.length() && stack.isEmpty()) {
			answer++;
		}
		
		rotate(s.substring(1) + s.substring(0,1), i+1);
	}
	
}
