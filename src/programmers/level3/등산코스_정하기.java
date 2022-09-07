package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class 등산코스_정하기 {

	public static void main(String[] args) {
		int n = 7;
		int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
		int[] gates = {1};
		int[] summits = {2, 3, 4};
		int[] answer = solution(n, paths, gates, summits);
		System.out.println(Arrays.toString(answer));
		
		int n1 = 7;
		int[][] paths1 = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
		int[] gates1 = {1};
		int[] summits1 = {2, 3, 4};
		int[] answer1 = solution(n1, paths1, gates1, summits1);
		System.out.println(Arrays.toString(answer1));
	}
	
	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		int[] max = new int[] {n, 10000000};
		int[][] distance = new int[n+1][2];
		boolean[] visit = new boolean[n+1];
		
		Arrays.fill(distance, max);
		
		for(int summit : summits) {
			distance[summit] = new int[] {summit, 0};
			visit[summit] = true;
		}
		
		Map<Integer, List<int[]>> map = new HashMap<>();
		
		for(int[] path : paths) {
			List<int[]> list;
			
			list = map.getOrDefault(path[0], new ArrayList<int[]>());
			list.add(new int[] {path[1], path[2]});
			map.put(path[0], list);
			
			list = map.getOrDefault(path[1], new ArrayList<int[]>());
			list.add(new int[] {path[0], path[2]});
			map.put(path[1], list);
		}
		
		Queue<int[]> queue = new PriorityQueue<>((i1, i2) -> {
			int value1 = Integer.max(i1[2], distance[i1[0]][1]);
			int value2 = Integer.max(i2[2], distance[i2[0]][1]);
			
			if(value1==value2) {
				return Integer.compare(distance[i1[0]][0], distance[i2[0]][0]);
			}
			return Integer.compare(value1, value2);
		});
		
		for(int summit : summits) {
			queueAdd(queue, map, summit, visit);
		}
		
		int start, next, value;
		
		while(!queue.isEmpty()) {
			int[] pathValue = queue.poll();
			
			start = pathValue[0];
			next = pathValue[1];
			value = Integer.max(pathValue[2], distance[start][1]);
			
			if(visit[next]) continue;
			visit[next] = true;
			
			distance[next] = new int[] {distance[start][0], value};
			
			for(int gate : gates) {
				if(next==gate) {
					return distance[next];
				}
			}
			
			queueAdd(queue, map, next, visit);
		}
		
		return null;
	}

	private static void queueAdd(Queue<int[]> queue, Map<Integer, List<int[]>> map, int value, boolean[] visit) {
		for(int[] temp : map.get(value)) {
			if(visit[temp[0]]) continue;
			
			queue.add(new int[] {value, temp[0], temp[1]});
		}
	}
	
	/* 다른 사람의 풀이 참고 */
	public static int[] solution1(int n, int[][] paths, int[] gates, int[] summits) {
		Set<Integer> gateSet = Arrays.stream(gates).boxed().collect(Collectors.toSet());
		Set<Integer> summitSet = Arrays.stream(summits).boxed().collect(Collectors.toSet());
		
		Map<Integer, List<int[]>> map = new HashMap<>();
		
		for(int[] path : paths) {
			List<int[]> list;
			
			list = map.getOrDefault(path[0], new ArrayList<int[]>());
			list.add(new int[] {path[1], path[2]});
			map.put(path[0], list);
			
			list = map.getOrDefault(path[1], new ArrayList<int[]>());
			list.add(new int[] {path[0], path[2]});
			map.put(path[1], list);
		}
		
		int minSummit=n, minCost = 10000000;
		for(int summit : summitSet) {
			int cost = bfs(map, gateSet, summitSet, summit);
			if(cost<minCost) {
				minCost = cost;
				minSummit = summit;
			}else if(cost==minCost) {
				minSummit = Math.min(minSummit, summit);
			}
		}
		
		return new int[] {minSummit, minCost};
	}

	private static int bfs(Map<Integer, List<int[]>> map, Set<Integer> gateSet, Set<Integer> summitSet, int summit) {
		Set<Integer> set = new HashSet<>();
		Queue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1], i2[1]));
		queue.add(new int[] {summit, 0});
		
		while(queue.isEmpty()) {
			int[] temp = queue.poll();
			int next = temp[0];
			int cost = temp[1];
			
			if(gateSet.contains(next)) return cost;
			
			if(summitSet.contains(next)) continue;
			if(set.contains(next)) continue;
			
			set.add(next);
			
			for(int[] queueAdd : map.get(next)) {
				if(set.contains(queueAdd[0])) continue;
				
				queue.add(new int[] {queueAdd[0], Math.max(queueAdd[0], cost)});
			}
		}
		
		return Integer.MAX_VALUE;
	}
}