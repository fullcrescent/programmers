package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class 징검다리_건너기 {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 2, 4, 2, 5, 2};
		int k = 3;
		int answer = solution(stones, k);
		System.out.println(answer);
	}
	
	public static int solution(int[] stones, int k) {
		int answer = 200000000;
		
		List<Integer> list = new ArrayList<>();
		
		for(int stone : stones) {
			if(!list.contains(stone)) {
				list.add(stone);
				
				int min = stone;
				
				int temp = 0;
				
				for(int stone1 : stones) {
					if(stone1>min) {
						temp=0;
					}else {
						temp++;
						if(temp==k) {
							answer = Math.min(answer, min);
						}
					}
				}
			}
		}
		
		return answer;
	}
}
