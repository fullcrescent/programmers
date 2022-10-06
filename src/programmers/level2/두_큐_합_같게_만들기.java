package programmers.level2;

import java.util.Arrays;

public class 두_큐_합_같게_만들기 {

	public static void main(String[] args) {
		int[] queue1 = {1, 2, 1, 2};
		int[] queue2 = {1, 10, 1, 2};
		int answer = solution(queue1, queue2);
		System.out.println(answer);
	}
	
	public static int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		long sum1 = Arrays.stream(queue1).sum();
		long sum2 = Arrays.stream(queue2).sum();
		
		int index1 = 0;
		int index2 = 0;
		
		if((sum1+sum2)%2==0) {
			
			while(answer<queue1.length+queue2.length) {
				answer++;
				long add = 0;
				if(sum1>sum2) {
					add = (index1/queue1.length)%2==0 ? queue1[index1] : queue2[index1%queue1.length];
					sum1 -= add;
					sum2 += add;
					index1++;
				}else {
					add = (index2/queue2.length)%2==0 ? queue2[index2] : queue1[index2%queue2.length];
					sum1 += add;
					sum2 -= add;
					index2++;
				}
				
				if(sum1==sum2) break;
			}
			
			return answer==queue1.length+queue2.length ? -1 : answer;
		}else {
			return -1;
		}
	}
}
