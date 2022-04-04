package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int answer = solution(n, computers);
		System.out.println(answer);
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
}
