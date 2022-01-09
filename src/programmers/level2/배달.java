package programmers.level2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 배달 {

	public static void main(String[] args) {
		int N = 6;
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int K = 4;
		int answer = solution(N, road, K);
		System.out.println(answer);
	}

	public static int solution(int N, int[][] road, int K) {
		// 배달 거리가 가장 가까운 순으로 정렬 -> 다익스트라 알고리즘
		
		// 시작점 및 최대값 세팅
		int start = 1;
		int max = 500001;
		int next;
		
		// 원본 배열을 저장할 리스트와 최소거리를 정렬해줄 큐 선언 
		List<int[]> list = new LinkedList<>(Arrays.asList(road));
		Queue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[2], i2[2]));
		
		// 정점의 방문 여부를 저장할 배열 및 시작점에서의 거리 배열  
		boolean[] visit = new boolean[N+1];
		int[] distance = new int[N+1];
		
		Arrays.fill(distance, max);
		distance[start] = 0;
		visit[start] = true;
		
		// 시작점과 연결된 간선 찾고 삭제 - list의 길이 변경이 일어나므로 Iterator를 통해서 작업 
		Iterator<int[]> iterator = list.iterator();
		while(iterator.hasNext()) {
			int[] temp = iterator.next();
			if(temp[0]==start || temp[1]==start) {
				queue.add(temp);
				iterator.remove();
			}
		}
		
		while(!queue.isEmpty()) {
			int[] roadValue = queue.poll();
			
			// 큐에서 가져온 값에서 시작점과 끝점을 찾음 
			start = visit[roadValue[0]] ? roadValue[0] : roadValue[1]; 
			next = (roadValue[0]!=start) ? roadValue[0] : roadValue[1];
			
			// 다음 정점이 방문한 정점일 경우 스킵
			if(visit[next]) continue;
			visit[next] = true;
			
			distance[next] = roadValue[2];
			
			iterator = list.iterator();
			while(iterator.hasNext()) {
				int[] temp = iterator.next();
				if(temp[0]==next || temp[1]==next) {
					iterator.remove();
					// 시작점에서의 거리를 더해서 큐에 추가
					temp[2] += distance[next];
					queue.add(temp);
				}
			}
		}
		
		return (int) Arrays.stream(distance).filter(i -> i<=K).count();
	}
	
}
