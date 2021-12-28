package programmers.level2;

import java.util.PriorityQueue;

public class 더_맵게 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		int answer = solution(scoville, K);
		System.out.println(answer);
	}
	
	public static int solution(int[] scoville, int K) {
		int answer = 0;
		
		PriorityQueue<Integer> heap =new PriorityQueue<Integer>();
		
		for(int data:scoville){
			heap.add(data);
		}
		
		while(heap.peek()<K){
			if(heap.size() ==1) return -1;
			int data = heap.poll() + (heap.poll() * 2);
			heap.add(data);
			answer++;
		}
		
		return answer;
	}
}
