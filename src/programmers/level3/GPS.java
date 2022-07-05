package programmers.level3;

import java.util.HashSet;
import java.util.Set;

public class GPS {

	public static void main(String[] args) {
		int n = 7;
		int m = 10;
		int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
		int k = 6;
		int[] gps_log = {1, 2, 3, 3, 6, 7};
		int answer = solution(n, m, edge_list, k, gps_log);
		System.out.println(answer);
	}
	
	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		int answer = -1;
		boolean[][] edge = new boolean[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			edge[i][i] = true;
		}
		
		for(int i=0; i<edge_list.length; i++) {
			edge[edge_list[i][0]][edge_list[i][1]] = edge[edge_list[i][1]][edge_list[i][0]] = true;
		}
		
		for(int i=0; i<k; i++) {
			int temp = 0;
			
			Set<Integer> set = null;
			
			for(int i1=i; i1>0; i1--) {
				
			}
			
			for(int i2=i; i2<k-1; i2++) {
				set = getSet(set, edge, gps_log[i2]);
				
				if(set.contains(gps_log[i2+1])) {
					set = null;
				}else {
					temp++;
				}
			}
			
			answer = Math.max(answer, temp);
		}
		
		return answer;
	}

	private static Set<Integer> getSet(Set<Integer> set, boolean[][] edge, int input) {
		Set<Integer> tempSet = new HashSet<>();
		int length = edge[input].length;
		
		if(set==null) {
			for(int i=0; i<length; i++) {
				if(edge[input][i]) {
					tempSet.add(i);
				}
			}
			
		}else {
			for(int temp : set) {
				for(int i=0; i<length; i++) {
					if(edge[temp][i]) {
						tempSet.add(i);
					}
				}
			}
		}
		
		return tempSet;
	}
}
