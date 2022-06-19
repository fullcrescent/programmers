package programmers.level3;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class 징검다리_건너기 {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 2, 4, 2, 5, 2};
		int k = 3;
		int answer = solution(stones, k);
		System.out.println(answer);
	}
	
	public static int solution(int[] stones, int k) {
		// List contain 해보기
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<stones.length; i++) {
			set.add(stones[i]);
		}
		
		Queue<Integer> queue = new PriorityQueue<>(set);
		
		while(!queue.isEmpty()) {
			int min =queue.poll();
		
			int temp = 0;
			
			for(int stone : stones) {
				if(stone>min) {
					temp=0;
				}else {
					temp++;
					if(temp==k) {
						return min;
					}
				}
			}
		}
		
		return 0;
	}
}
