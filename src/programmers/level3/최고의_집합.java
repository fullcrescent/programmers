package programmers.level3;

import java.util.Arrays;

public class 최고의_집합 {

	public static void main(String[] args) {
		int n = 3;
		int s = 10;
		int[] answer = solution(n, s);
		System.out.println(Arrays.toString(answer));
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

}
