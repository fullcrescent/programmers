package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] answer = solution(prices);
		System.out.println(Arrays.toString(answer));
		
		int[] prices1 = {1, 2, 3, 2, 3};
		int[] answer1 = solution1(prices1);
		System.out.println(Arrays.toString(answer1));
		
		int[] prices2 = {1, 2, 3, 2, 3};
		int[] answer2 = solution2(prices2);
		System.out.println(Arrays.toString(answer2));
	}
	
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for(int i=0; i<prices.length-1; i++) {
			int count = 0;
			for(int j=i+1; j<prices.length; j++) {
				if(prices[i]>prices[j]) {
					count++;
					break;
				}
				count++;
			}
			answer[i] = count;
		}
		
		return answer;
    }
	
	// 다른 사람의 풀이 참고 
	public static int[] solution1(int[] prices) {
		int[] answer = new int[prices.length];
		
		for(int i=0; i<prices.length-1; i++) {
			for(int j=i+1; j<prices.length; j++) {
				answer[i]++;
				if(prices[i]>prices[j]) {
					break;
				}
			}
		}
		
		return answer;
    }
	
	public static int[] solution2(int[] prices) {
		int[] answer = new int[prices.length];
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		
		for(int i=1; i<prices.length; i++) {
			while(!stack.isEmpty()&&prices[i]<prices[stack.peek()]) {
				int temp = stack.pop();
				answer[temp] = i - temp;
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			answer[temp] = prices.length-temp-1;
		}
		
		return answer;
    }
}
