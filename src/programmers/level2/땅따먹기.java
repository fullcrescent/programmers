package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 땅따먹기 {

	public static void main(String[] args) {
		int[][] land = {{1,2,3,1003},{5,6,7,1507},{4,3,2,1004}};
		int answer = solution(land);
		System.out.println(answer);
	}

	public static int solution(int[][] land) {
		Map<Integer, Map<String, Integer>> map = new HashMap<>();
		
		int[][] tempArray = new int[land.length][4];
		
		for(int i=0; i<land.length; i++) {
			for(int j=0; j<4; j++) {
				tempArray[i][j] = land[i][j];
			}
		}
		
		for(int[] temp : tempArray) {
			Arrays.sort(temp);
		}
		
		int index=0;
		
		for(int[] temp : tempArray) {
			Map<String, Integer> tempMap = new HashMap<>();
			tempMap.put("sub", temp[3]-temp[2]);
			
			map.put(index++, tempMap);
		}
		return 0;
	}
	
//	public static int solution(int[][] land) {
//		int[][] tempArray = new int[land.length][4];
//		
//		for(int i=0; i<land.length; i++) {
//			for(int j=0; j<4; j++) {
//				tempArray[i][j] = land[i][j];
//			}
//		}
//		
//		for(int[] temp : tempArray) {
//			Arrays.sort(temp);
//		}
//		
//		for(int i=2; i<4; i++) {
//			dfs(land, tempArray, 1, i, tempArray[0][i]);
//		}
//		
//		return max;
//	}
//
//	static int max = 0;
//	
//	private static void dfs(int[][] land, int[][] tempArray, int index, int visit, int sum) {
//		if(index==land.length) {
//			max = Math.max(max, sum);
//			return;
//		}
//		
//		if(visit==-1) {
//			int count=0;
//			for(int i=0; i<4; i++) {
//				if(land[index][i]==tempArray[index][3]) {
//					visit=i;
//					count++;
//				}
//			}
//			if(count>1) {
//				visit = -1;
//			}
//			dfs(land, tempArray, index+1, visit, sum+tempArray[index][3]);
//		}
//		
//		if(land[index][visit]==tempArray[index][3]) {
//			int count=0;
//			for(int i=0; i<4; i++) {
//				if(land[index][i]==tempArray[index][2]) {
//					visit=i;
//					count++;
//				}
//			}
//			if(count>1) {
//				visit = -1;
//			}
//			dfs(land, tempArray, index+1, visit, sum+tempArray[index][2]);
//		}else {
//			int count=0;
//			for(int i=0; i<4; i++) {
//				if(land[index][i]==tempArray[index][3]) {
//					visit=i;
//				}
//			}
//			if(count>1) {
//				visit = -1;
//			}
//			dfs(land, tempArray, index+1, visit, sum+tempArray[index][3]);
//		}
//	}
	
	
}
