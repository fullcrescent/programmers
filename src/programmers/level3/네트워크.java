package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int answer = solution(n, computers);
		System.out.println(answer);
		
		int n1 = 3;
		int[][] computers1 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int answer1 = solution1(n1, computers1);
		System.out.println(answer1);
	}
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visit = new boolean[n];
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<computers.length; i++) {
			if(visit[i]) continue;
			
			queue.add(i);
			visit[i] = true;
			
			while(!queue.isEmpty()) {
				int currentPoint = queue.poll();
				
				for(int j=0; j<n; j++) {
					if(currentPoint==j || visit[j]) continue;
					
					if(computers[currentPoint][j]==1) {
						queue.add(j);
						visit[j] = true;
					}
				}			
			}
			
			answer++;
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int n, int[][] computers) {
		int answer = 0;
		boolean[] visit = new boolean[n];
		
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				dfs(computers, visit, i);
				answer++;
			}
		}
		
		return answer;
	}

	private static void dfs(int[][] computers, boolean[] visit, int index) {
		visit[index] = true;
		
		for(int i=0; i<computers.length; i++) {
			if(computers[index][i]==1 && !visit[i]) {
				dfs(computers, visit, i);
			}
		}
	}
}
