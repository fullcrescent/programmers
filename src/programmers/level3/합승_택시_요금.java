package programmers.level3;

import java.util.*;
import java.util.stream.IntStream;

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
		int[][] floydWarshall = new int[n][n];
		IntStream.range(0, n).forEach(i -> Arrays.fill(floydWarshall[i], Integer.MAX_VALUE));
		IntStream.range(0, n).forEach(i -> floydWarshall[i][i] = 0);

		Arrays.stream(fares).forEach(i -> {
			floydWarshall[i[0]-1][i[1]-1] = i[2];
			floydWarshall[i[1]-1][i[0]-1] = i[2];
		});

		for(int k=0; k<n; k++){
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(floydWarshall[i][k]==Integer.MAX_VALUE || floydWarshall[k][j]==Integer.MAX_VALUE) continue;

					if(floydWarshall[i][k] + floydWarshall[k][j] < floydWarshall[i][j]){
						floydWarshall[i][j] = floydWarshall[i][k] + floydWarshall[k][j];
					}
				}
			}
		}

		return Arrays.stream(floydWarshall).map(i -> i[s-1]+i[a-1]+i[b-1]).min(Integer::compare).orElseThrow();
	}
}
