package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class 등산코스_정하기 {

	public static void main(String[] args) {
		int n = 7;
		int[][] paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}};
		int[] gates = {3, 7};
		int[] summits = {1, 5};
		int[] answer = solution(n, paths, gates, summits);
		System.out.println(Arrays.toString(answer));
	}
	
	/* 다익스트라로 풀어야함. 시간초과 */
	/* 큐에 추가시 방향성 필요 */
	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		int[] max = new int[] {n, 10000000};
		int[][] distance = new int[n+1][2];
		boolean[] visit = new boolean[n+1];
		
		Arrays.sort(summits);
		Arrays.fill(distance, max);
		
		for(int summit : summits) {
			visit[summit] = true;
			distance[summit] = new int[] {summit, 0}; 
		}
		
		List<int[]> list = new ArrayList<>(Arrays.asList(paths));
		Queue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[2], i2[2]));
		
		Iterator<int[]> iterator = list.iterator();
		while(iterator.hasNext()) {
			int[] temp = iterator.next();
			for(int i=0; i<summits.length; i++) {
				if(temp[0]==summits[i] || temp[1]==summits[i]) {
					queue.add(temp);
					iterator.remove();
				}
			}
		}
		
		int start, next, value;
		
		while(!queue.isEmpty()) {
			int[] pathValue = queue.poll();
			
			start = visit[pathValue[0]] ? pathValue[0] : pathValue[1]; 
			next = (pathValue[0]!=start) ? pathValue[0] : pathValue[1];
			value = pathValue[2];
			
			if(distance[next][1]>value || (distance[next][1]==value && distance[next][0]>distance[start][0]) ) {
				distance[next] = new int[] {distance[start][0], value};
			}
			
			iterator = list.iterator();
			while(iterator.hasNext()) {
				int[] temp = iterator.next();
				if(temp[0]==next || temp[1]==next) {
					iterator.remove();
					queue.add(temp);
				}
			}
		}
		
		return null;
	}
	
}
