package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 등산코스_정하기 {

	public static void main(String[] args) {
		int n = 7;
		int[][] paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}};
		int[] gates = {3, 7};
		int[] summits = {1, 5};
		int[] answer = solution(n, paths, gates, summits);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		Map<Integer, List<int[]>> map = new HashMap<>();
		boolean[] visit = new boolean[n+1];
		
		for(int[] path : paths) {
			List<int[]> list;
			
			list = map.getOrDefault(path[0], new ArrayList<int[]>());
			list.add(new int[] {path[1], path[2]});
			map.put(path[0], list);
			
			list = map.getOrDefault(path[1], new ArrayList<int[]>());
			list.add(new int[] {path[0], path[2]});
			map.put(path[1], list);
		}
		
		
		for(int gate : gates) {
			visit[gate] = true;
		}
		
		for(int gate : gates) {
			function(map, summits, visit, gate, 0);
		}
		
		return new int[] {end, min};
	}

	static int min = Integer.MAX_VALUE;
	static int end = Integer.MAX_VALUE;
	
	private static void function(Map<Integer, List<int[]>> map, int[] summits, boolean[] visit, int current, int intensity) {
		if(min<intensity) return;
		
		for(int summit : summits) {
			if(current==summit) {
				if(min==intensity) {
					end = Integer.min(end, current);
				}else {
					min = intensity;
					end = current;
				}
				return;
			}
		}
	
		for(int[] temp : map.get(current)) {
			if(visit[temp[0]]) continue;
			
			visit[temp[0]] = true;
			function(map, summits, visit, temp[0], Integer.max(intensity, temp[1]));
			visit[temp[0]] = false;
		}
	}
	
}
