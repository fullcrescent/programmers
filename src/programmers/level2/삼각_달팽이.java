package programmers.level2;

import java.util.Arrays;

public class 삼각_달팽이 {

	public static void main(String[] args) {
		int n = 4;
		int[] answer = solution(n);
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(int n) {
		int start = 0;
		int length = fibonacci(n);
		int[] answer = new int[length];
		
		int index = 0;
		int count = 1;
		
		while(index<length) {
			for(int i=start; i<n; i++) {
				index += i;
				answer[index] = count++;
			}
			start += 2;
			
			for(int i=1; index<length-1;) {
				index += i;
				answer[index] = count++;
			}
			length = length-n-1;
			
			for(int i=n; i>start; i--) {
				index -= i;
				answer[index] = count++;
			}
			n--;
		}

		return answer;
	}
	
	private static int fibonacci(int n) {
		if(n==0) return 0;
		return n+fibonacci(n-1);
	}
	
}
