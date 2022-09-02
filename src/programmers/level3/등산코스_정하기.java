package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 등산코스_정하기 {

	public static void main(String[] args) {
		int n = 7;
		int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
		int[] gates = {1};
		int[] summits = {2, 3, 4};
		int[] answer = solution(n, paths, gates, summits);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		int[] max = new int[] {n, 10000000};
		int[][] distance = new int[n+1][2];
		
		Arrays.fill(distance, max);
		
		for(int summit : summits) {
			distance[summit] = new int[] {summit, 0}; 
		}
		
		List<int[]> list = new ArrayList<>(Arrays.asList(paths));
		Queue<int[]> queue = new PriorityQueue<>((i1, i2) -> {
			if(i1[2]==i2[2]) {
				return Integer.compare(i1[0], i2[0]);
			}
			return Integer.compare(i1[2], i2[2]);
		});
		
		for(int summit : summits) {
			queueAdd(queue, list, summit);
		}
		
		int start, next, value;
		
		while(!queue.isEmpty()) {
			int[] pathValue = queue.poll();
			
			start = pathValue[0];
			next = pathValue[1];
			value = Integer.max(pathValue[2], distance[start][1]);
			
			if(distance[next][1]>value || (distance[next][1]==value && distance[next][0]>distance[start][0]) ) {
				distance[next] = new int[] {distance[start][0], value};
			}
			
			queueAdd(queue, list, next);
		}
		
		int[] answer = max;
		
		Arrays.sort(gates);
		
		for(int gate : gates) {
			int[] temp = distance[gate];
			
			if(answer[1]>temp[1]) {
				answer = temp;
			}
		}
		
		return answer;
	}

	private static void queueAdd(Queue<int[]> queue, List<int[]> list, int value) {
		Iterator<int[]> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			int[] temp = iterator.next();
			if(temp[0]==value) {
				queue.add(new int[] {temp[0], temp[1], temp[2]});
				iterator.remove();
			}else if(temp[1]==value) {
				queue.add(new int[] {temp[1], temp[0], temp[2]});
				iterator.remove();
			}
		}
	}
	
}
