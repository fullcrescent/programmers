package programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 입국심사 {

	public static void main(String[] args) {
		int n = 35;
		int[] times = {7, 10};
		long answer = solution(n, times);
		System.out.println(answer);
	}
	
	public static long solution(int n, int[] times) {
		List<Long> list = new LinkedList<>();
		
		Arrays.sort(times);
		
		for(int time : times) {
			list.add((long) time);
		}
		
		int index=0;
		
		while(list.size()<n) {
			if(list.get(index)==1) {
				
			}
			
		
		}
		
		
		return 0;
	}
}
