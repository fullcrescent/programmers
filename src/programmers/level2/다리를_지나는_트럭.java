package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		int answer = solution(bridge_length, weight, truck_weights);
		System.out.println(answer);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int[] site = new int[bridge_length];
		
		int hour=1;
		
		Queue<Integer> queue = new LinkedList<>();;
		
		for(int temp : truck_weights) {
			queue.add(temp);
		}
		
		
		while(!queue.isEmpty()) {
			if(Arrays.stream(site).sum()+queue.peek()<=weight) {
				site[0]=queue.poll();
			}else {
				site[0]=0;
			}
			
			hour++;
			
			for(int i=site.length-1; i>0; i--) {
				site[i] = site[i-1];
				site[i-1] = 0;
			}
		}
		
		return hour+(site.length-1);
	}
}
