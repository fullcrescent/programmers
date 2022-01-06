package programmers.level2;

import java.util.PriorityQueue;

public class 더_맵게 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		int answer = solution(scoville, K);
		System.out.println(answer);
		
		int[] scoville1 = {1, 2, 3, 9, 10, 12};
		int K1 = 7;
		int answer1 = solution1(scoville1, K1);
		System.out.println(answer1);
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
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[] scoville, int K) {
		int answer = 0;
		
		PriorityQueue<Integer> heap =new PriorityQueue<Integer>();
		
		for(int data:scoville){
			heap.add(data);
		}
		
		while(heap.size()>1 && heap.peek()<K){
			int data = heap.poll() + (heap.poll() * 2);
			heap.add(data);
			answer++;
		}
		
		return heap.peek()>=K ? answer : -1;
	}
}
