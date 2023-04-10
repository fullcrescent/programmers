package programmers.level3;

import java.util.*;

public class 합승_택시_요금 {

	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		int answer = solution(n, s, a, b, fares);
		System.out.println(answer);
	}
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		Dijkstra dijkstra = new Dijkstra(n, fares);
		int min = dijkstra.algorithm(a, b);

		return 0;
	}
}

class Dijkstra{
	int vertexCount;
	int[][] fares;
	int[] path;

	public Dijkstra(int vertexCount, int[][] fares) {
		this.vertexCount = vertexCount;
		this.fares = fares;
	}

	public int algorithm(int start, int end){
		Queue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[2], i2[2]));
		Arrays.stream(fares).filter(i -> i[0]==start || i[1]==start).forEach(i -> queue.add(i));

		boolean[] visit = new boolean[vertexCount+1];
		visit[start] = true;

		while(!queue.isEmpty()){
			int[] link = queue.poll();
			int next = visit[link[0]] ? link[1] : link[0];
			if(next==end)	return link[2];

			if(visit[next]) continue;
			visit[next] = true;

			Arrays.stream(fares).filter(i -> i[0]==next || i[1]==next).forEach(i -> {
				if(!visit[i[0]==next ? i[1] : i[0]]){
					i[2] = i[2]+link[2];
					queue.add(i);
				}
			});
		}

		return -1;
	}
}