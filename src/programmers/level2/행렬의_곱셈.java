package programmers.level2;

import java.util.Arrays;

public class 행렬의_곱셈 {

	public static void main(String[] args) {
		int[][] arr1 = {{1,4}, {3,2}, {4,1}};
		int[][] arr2 = {{3, 3}, {3, 3}};
		int[][] answer = solution(arr1, arr2);
		for(int[] temp : answer) {
			System.out.println(Arrays.toString(temp));
		}
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		
		
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2[0].length; j++) {
				int tempSum = 0;
				for(int k=0; k<arr1[i].length; k++) {
					tempSum += arr1[i][k]*arr2[k][j];
				}
				answer[i][j] = tempSum;
			}
		}
			
		return answer;
	}
}
