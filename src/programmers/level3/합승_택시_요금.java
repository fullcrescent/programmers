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

		return dijkstra.algorithm(a, b) + dijkstra.pathList.stream().map(end -> dijkstra.algorithm(s, end)).min(Integer::compare).orElseThrow();
	}
}

class Dijkstra{
	int vertexCount;
	int[][] fares;
	List<Integer> pathList = new ArrayList<>();

	public Dijkstra(int vertexCount, int[][] fares) {
		this.vertexCount = vertexCount;
		this.fares = fares;
	}

	public int algorithm(int start, int end){
		Queue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i.distance));
		Arrays.stream(fares).filter(i -> i[0]==start || i[1]==start).forEach(i -> queue.add(new Info(i[0], i[1], i[2], new ArrayList<>())));

		boolean[] visit = new boolean[vertexCount+1];
		visit[start] = true;

		while(!queue.isEmpty()){
			Info info = queue.poll();
			int next = visit[info.vertex1] ? info.vertex2 : info.vertex1;
			int distance = info.distance;

			if(next==end){
				this.pathList = info.pathList;
				this.pathList.add(start);
				this.pathList.add(end);
				return distance;
			}

			if(visit[next]) continue;
			visit[next] = true;

			Arrays.stream(fares).filter(i -> i[0]==next || i[1]==next).forEach(i -> {
				if(!visit[i[0]==next ? i[1] : i[0]]){
					List<Integer> tempList = new ArrayList<>(info.pathList);
					tempList.add(next);
					queue.add(new Info(i[0], i[1], i[2]+distance, tempList));
				}
			});
		}

		return 0;
	}
}

class Info{
	int vertex1;
	int vertex2;
	int distance;
	List<Integer> pathList;

	public Info(int vertex1, int vertex2, int distance, List<Integer> pathList) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.distance = distance;
		this.pathList = pathList;
	}
}