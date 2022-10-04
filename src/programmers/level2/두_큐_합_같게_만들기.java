package programmers.level2;

import java.util.Arrays;

public class 두_큐_합_같게_만들기 {

	public static void main(String[] args) {
		int[] queue1 = {3, 2, 7, 2};
		int[] queue2 = {4, 6, 5, 1};
		int answer = solution(queue1, queue2);
		System.out.println(answer);
	}
	
	public static int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		long sum1 = Arrays.stream(queue1).sum();
		long sum2 = Arrays.stream(queue2).sum();
		
		if((sum1+sum2)%2==0) {
			
			while(answer<queue1.length+queue2.length) {
				answer++;
				if(sum1>sum2) {
					
				}else {
					
				}
			}
			
			return answer==queue1.length+queue2.length ? -1 : answer;
		}else {
			return -1;
		}
	}
}
