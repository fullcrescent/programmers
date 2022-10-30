package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 등대 {

	public static void main(String[] args) {
		int n = 8;
		int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
		int answer = solution(n, lighthouse);
		System.out.println(answer);
	}
	
	public static int solution(int n, int[][] lighthouse) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i=1; i<=n; i++) {
			map.put(i, new ArrayList<>(Arrays.asList(i)));
		}
		
		for(int[] temp : lighthouse) {
			List<Integer> tempList;
			
			tempList = map.getOrDefault(temp[0], new ArrayList<>());
			tempList.add(temp[1]);
			map.put(temp[0], tempList);
			
			tempList = map.getOrDefault(temp[1], new ArrayList<>());
			tempList.add(temp[0]);
			map.put(temp[1], tempList);
		}
		
		for(int i=1; i<n; i++) {
			if(validate(map, new boolean[n+1], i, 0)) return i;
		}
		
		return n;
	}
	
	private static boolean validate(Map<Integer, List<Integer>> map, boolean[] visit, int limit, int count) {
		if(limit==count) {
			visit[0] = true;
			
			for(boolean temp : visit) {
				if(!temp) return false;
			}
			
			return true;
		}
		
		for(int i=1; i<visit.length; i++) {
			if(visit[i]) continue;
			
			List<Integer> addList = map.getOrDefault(i, new ArrayList<>()).stream().filter(start -> !visit[start]).collect(Collectors.toList());
			
			addList.stream().forEach(v -> visit[v]=true);
			
			if(validate(map, visit, limit, count+1)) return true;
			
			addList.stream().forEach(v -> visit[v]=false);
		}
		
		return false;
	}
}
