package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 줄_서는_방법 {

	public static void main(String[] args) {
		int n = 3;
		int k = 5;
		int[] result = solution(n, k);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] solution(int n, long k) {
		int[] answer = new int[n];
		long[] factorial = new long[n];
		factorial[0] = 1;
		factorial[1] = 1;
		
		for(int i=2; i<n; i++) {
			factorial[i] = i * factorial[i-1];
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			list.add(i);
		}
		
		k--;
		int index = 0;
		while(n>0) {
			n--;
			int temp = (int) (k/factorial[n]);
			answer[index++] = list.get(temp);
			list.remove(temp);
			k %= factorial[n];
		}
		
		return answer;
	}
}
