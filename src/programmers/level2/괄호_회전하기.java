package programmers.level2;

import java.util.Stack;

public class 괄호_회전하기 {
	public static void main(String args[]) {
		String s = "[](){}";
		int answer = solution(s);
		System.out.println(answer);
		
		String s1 = "[](){}";
		int answer1 = solution1(s1);
		System.out.println(answer1);
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
	
	// 다른 사람의 풀이 참고
	public static int solution1(String s) {
		rotate1(s, 0);
		
		return answer1;
	}
	
	static int answer1 =0;
	
	private static void rotate1(String s, int i) {
		if(i==s.length()-1) {
			return;
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		Character[] start = {'(', '{', '['};
		Character[] end = {')', '}', ']'};
		
		Loop1 :
		for(int index=0; index<s.length(); index++) {
			char temp = s.charAt(index);
			Loop2 :
			for(int j=0; j<start.length; j++) {
				if(temp==start[j]) {
					stack.add(temp);
					break Loop2;
				}
				if(temp==end[j]) {
					if(stack.isEmpty() || stack.peek()!=start[j]) {
						stack.add(temp);
						break Loop1;
					}else {
						stack.pop();
						break Loop2;
					}
				}
			}
		}
		
		if(stack.isEmpty()) {
			answer1++;
		}
		
		rotate1(s.substring(1) + s.substring(0,1), i+1);
	}
}
