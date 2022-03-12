package programmers.level3;

import java.util.Arrays;

public class 입국심사 {

	public static void main(String[] args) {
		int n = 19;
		int[] times = {7, 10};
		long answer = solution(n, times);
		System.out.println(answer);
	}
	
	public static long solution(int n, int[] times) {
		Arrays.sort(times);
		
		int time = 0;
		int index = 0;
		int sum =0;
		
		while(sum!=n) {
			sum = 0;
			time += times[index]; 
			for(int i=0; i<times.length; i++) {
				sum += time/times[i];
			}
			
			if(sum>n) {
				time -= 2*times[index++];
			}
		}
		
		return time;
	}
}
