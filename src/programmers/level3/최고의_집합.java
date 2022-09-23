package programmers.level3;

import java.util.Arrays;

public class 최고의_집합 {

	public static void main(String[] args) {
		int n = 3;
		int s = 10;
		int[] answer = solution(n, s);
		System.out.println(Arrays.toString(answer));
		
		int n1 = 3;
		int s1 = 10;
		int[] answer1 = solution1(n1, s1);
		System.out.println(Arrays.toString(answer1));
	}
	
	public static int[] solution(int n, int s) {
		if(n>s) return new int[] {-1};
		
		int[] answer = new int[n];
		int diff = s%n;

		Arrays.fill(answer, s/n);
		
		for(int i=1; i<diff+1; i++) {
			answer[n-i]++;
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고 - 변경X
	public static int[] solution1(int n, int s) {
		if(n>s) return new int[] {-1};
		
		int[] answer = new int[n];
		int diff = s%n;

		Arrays.fill(answer, s/n);
		
		for(int i=1; i<diff+1; i++) {
			answer[n-i]++;
		}
		
		return answer;
	}
}
