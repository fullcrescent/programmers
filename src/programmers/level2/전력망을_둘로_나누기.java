package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기 {

	public static void main(String[] args) {
		int n = 9;
		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		int answer = solution(n, wires);
		System.out.println(answer);
	}
	
	public static int solution(int n, int[][] wires) {
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i=0; i<n+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int[] temp : wires) {
			list.get(temp[0]).add(temp[1]);
			list.get(temp[1]).add(temp[0]);
		}
		
		int answer = n;
		
		for(int[] temp : wires) {
			answer = Math.min(answer, divide(list, temp, n));
		}
		
        return answer;
	}

	private static int divide(List<List<Integer>> list, int[] temp, int n) {
		return Math.abs(divideCount(list, temp[0], temp[1], new boolean[n+1]) - divideCount(list, temp[1], temp[0], new boolean[n+1]));
	}

	private static int divideCount(List<List<Integer>> list, int start, int cut, boolean[] visit) {
		Queue<Integer> queue = new LinkedList<>();
		
		int divideCount = 1;
		
		visit[cut] = true;
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			if(visit[temp]) continue;

			divideCount++;
			visit[temp] = true;
			
			for(int connect : list.get(temp)) {
				if(visit[connect]) continue;
				queue.add(connect);
			}
		}
		
		return divideCount;
	}

}
