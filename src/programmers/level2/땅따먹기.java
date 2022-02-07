package programmers.level2;

import java.util.Arrays;

public class 땅따먹기 {

	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		int answer = solution(land);
		System.out.println(answer);
	}

	public static int solution(int[][] land) {
		int[][] tempArray = new int[land.length][4];
		
		for(int i=0; i<land.length; i++) {
			for(int j=0; j<4; j++) {
				tempArray[i][j] = land[i][j];
			}
		}
		
		for(int[] temp : tempArray) {
			Arrays.sort(temp);
		}
		
		int max = 0;
		int index = 0;
		int maxIndex = -1;
		int visit = -1;
		
		for(int[] temp : tempArray) {
			
		}
		
		return max;
	}
}
