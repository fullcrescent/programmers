package programmers.level3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 가장_먼_노드 {

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int answer = solution(n, edge);
		System.out.println(answer);
	}
	
	public static int solution(int n, int[][] edge) {
		boolean[] visit = new boolean[n+1];

		int start = 1;
		visit[start] = true;
		
		Map<Integer, Set<Integer>> map = new HashMap<>();
		
		for(int[] temp : edge) {
			Set<Integer> tempSet = map.getOrDefault(temp[0], new HashSet<>());
			tempSet.add(temp[1]);
			map.put(temp[0], tempSet);
			
			tempSet = map.getOrDefault(temp[1], new HashSet<>());
			tempSet.add(temp[0]);
			map.put(temp[1], tempSet);
		}
		
		Set<Integer> set = map.get(1);
		int answer = 0;
		
		while(!set.isEmpty()) {
			Set<Integer> tempSet = new HashSet<>();
			
			for(int temp : set) {
				if(visit[temp]) continue;
				
				visit[temp] = true;
			}
			
			for(int temp : set) {
				for(int addValue : map.get(temp)) {
					if(visit[addValue]) continue;
					
					tempSet.add(addValue);
				}
			}
			
			answer = set.size();
			set = tempSet;
		}
		
		return answer;
	}
}
