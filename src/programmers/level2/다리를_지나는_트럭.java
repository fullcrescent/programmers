package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 다리를_지나는_트럭 {
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		int answer = solution(bridge_length, weight, truck_weights);
		System.out.println(answer);
		
		int bridge_length1 = 100;
		int weight1 = 100;
		int[] truck_weights1 = {10,10,10,10,10,10,10,10,10,10};
		int answer1 = solution1(bridge_length1, weight1, truck_weights1);
		System.out.println(answer1);
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
	
	// 다른 사람의 풀이 참고
	public static int solution1(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> queue = new LinkedList<>();
		// 현재 지나가고 있는 트럭을 나타냄
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int temp : truck_weights) {
			queue.add(temp);
		}
		
		int answer = 0;
		int max = 0;
		
		while(!queue.isEmpty()) {
			answer++;
			
			if(map.containsKey(answer)) {
				map.remove(answer);
			}
			
			if(!queue.isEmpty()) {
				if(map.values().stream().mapToInt(Number::intValue).sum() + queue.peek() <= weight) {
					// 마지막으로 map에 추가 되는 값이 최대값
					max = answer+bridge_length;
					map.put(max, queue.poll());
				}
			}
		}
		
		return max;
	}
	
}
