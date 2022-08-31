package programmers.level3;

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
	
	/* 다익스트라로 풀어야함. 시간초과 */
	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		int[] max = new int[] {n, 10000000};
		int[][] distance = new int[n+1][2];
		boolean[] visit = new boolean[n+1];
		
		Arrays.sort(summits);
		Arrays.fill(distance, max);
		
		return null;
	}
	
}
