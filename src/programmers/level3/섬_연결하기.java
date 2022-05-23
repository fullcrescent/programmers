package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class 섬_연결하기 {

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1}, {2,3,1}, {0,2,1},{1,3,1},{1,2,1}};
		int answer = solution(n, costs); 
		System.out.println(answer);
		
		int n1 = 4;
		int[][] costs1 = {{0,1,1}, {2,3,1}, {0,2,1},{1,3,1},{1,2,1}};
		int answer1 = solution1(n1, costs1); 
		System.out.println(answer1);
	}
	
	public static int solution(int n, int[][] costs) {
		int answer = 0;

		Arrays.sort(costs, new Comparator<int[]>(){
			public int compare(int[] i1, int[] i2) {
				return Integer.compare(i1[2], i2[2]);
			}
		});
		
		Set<Integer> set = new HashSet<>();
		set.add(costs[0][0]);
		set.add(costs[0][1]);
		answer += costs[0][2];
		
		while(set.size()<n) {
			for(int i=1; i<costs.length; i++) {
				if(set.contains(costs[i][0])^set.contains(costs[i][1])) {
					answer += costs[i][2];
					
					set.add(costs[i][0]);
					set.add(costs[i][1]);
					
					break;
				}
			}
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int n, int[][] costs) {
		int answer = 0;
		
		Arrays.sort(costs, (i1, i2) -> Integer.compare(i1[2], i2[2]));
		
		Set<Integer> set = new HashSet<>();
		set.add(costs[0][0]);
		set.add(costs[0][1]);
		
		answer += costs[0][2];
		
		while(set.size()<n) {
			for(int i=1; i<costs.length; i++) {
				if(set.contains(costs[i][0])^set.contains(costs[i][1])) {		// XOR
					answer += costs[i][2];
					
					set.add(costs[i][0]);
					set.add(costs[i][1]);
					
					break;
				}
			}
		}
		
		return answer;
	}
}
