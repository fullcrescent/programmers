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
		
		int[][] arr1_1 = {{1,4}, {3,2}, {4,1}};
		int[][] arr2_1 = {{3, 3}, {3, 3}};
		int[][] answer1 = solution1(arr1_1, arr2_1);
		for(int[] temp : answer1) {
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
	
	// 다른 사람의 풀이 참고
	public static int[][] solution1(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2[0].length; j++) {
				for(int k=0; k<arr1[i].length; k++) {
					answer[i][j] += arr1[i][k]*arr2[k][j];
				}
			}
		}
			
		return answer;
	}
}
