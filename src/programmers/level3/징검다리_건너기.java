package programmers.level3;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;

public class 징검다리_건너기 {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 2, 4, 2, 5, 2};
		int k = 3;
		int answer = solution(stones, k);
		System.out.println(answer);
	}
	
	public static int solution(int[] stones, int k) {
		Set<Integer> set = new TreeSet<>();
		
		for(int i=0; i<stones.length; i++) {
			set.add(stones[i]);
		}
		
		Iterator<Integer> iter = set.iterator();
		
		while(iter.hasNext()) {
			int min = iter.next();
			
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
