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
	
	/* summit 정렬 필요 */
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
		
		for(int key : map.keySet()) {
			List<int[]> list = map.get(key);
			list.sort((i1, i2) -> Integer.compare(i1[1], i2[1]));
		}
		
		for(int summit : summits) {
			visit[summit] = true;
		}
		
		for(int summit : summits) {
			function(map, gates, visit, summit, 0, summit);
		}
		
		return new int[] {end, min};
	}

	static int min = Integer.MAX_VALUE;
	static int end = Integer.MAX_VALUE;
	
	private static void function(Map<Integer, List<int[]>> map, int[] gates, boolean[] visit, int current, int intensity, int summit) {
		if(min<=intensity) return;
		
		for(int gate : gates) {
			if(current==gate) {
				min = intensity;
				end = summit;
				return;
			}
		}
	
		for(int[] temp : map.get(current)) {
			if(visit[temp[0]]) continue;
			
			visit[temp[0]] = true;
			function(map, gates, visit, temp[0], Integer.max(intensity, temp[1]), summit);
			visit[temp[0]] = false;
		}
	}
	
}
