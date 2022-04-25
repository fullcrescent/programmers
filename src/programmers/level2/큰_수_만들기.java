package programmers.level2;

import java.util.Stack;

public class 큰_수_만들기 {

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		String answer = solution(number, k);
		System.out.println(answer);
		
		String number1 = "4177252841";
		int k1 = 4;
		String answer1 = solution1(number1, k1);
		System.out.println(answer1);
	}

	public static String solution(String number, int k) {
		int start = 0;
		int end = k;
		
		StringBuffer answer = new StringBuffer();
		
		while(++end!=number.length()+1) {
			int index = start;
			
			for(int i=start+1; i<end; i++) {
				index = number.charAt(index)>=number.charAt(i) ? index : i;
			}
			
			answer.append(number.charAt(index));
			start=index+1;
		}
		
		return answer.toString();
	}
	
	// 다른 사람의 풀이 참고
	public static String solution1(String number, int k) {
		char[] answer = new char[number.length() - k];
		Stack<Character> stack = new Stack<>();
		
		for(char temp : number.toCharArray()) {
			while(!stack.isEmpty() && stack.peek()<temp && k-- >0) {
				stack.pop();
			}
			stack.push(temp);
		}
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = stack.get(i);
		}
		
		return new String(answer);
	}
}
