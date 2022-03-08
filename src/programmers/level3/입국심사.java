package programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 입국심사 {

	public static void main(String[] args) {
		int n = 18;
		int[] times = {7, 10};
		long answer = solution(n, times);
		System.out.println(answer);
	}
	
	public static long solution(int n, int[] times) {
		List<Long> list = new LinkedList<>();
		
		Arrays.sort(times);
		
		int[] count = new int[times.length];
		
		Loop1:
		while(list.size()<n) {
			for(int i=0; i<times.length; i++) {
				if(list.size()>=n) {
					break Loop1;
				}
				
				long temp = times[i]*++count[i];
				list.add(temp);
				
				if(i==times.length-1) {
					continue;
				}
				
				if(temp+times[i]<times[i+1]*(count[i+1]+1)) {
					while(temp+times[i]<times[i+1]*(count[i+1]+1)) {
						temp = times[i]*++count[i];
						list.add(temp);
					}
				}
				
			}
		}
		
		return list.get(n-1);
	}
}
