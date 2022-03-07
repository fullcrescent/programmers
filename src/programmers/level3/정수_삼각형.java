package programmers.level3;

import java.util.Arrays;

public class 정수_삼각형 {

	public static void main(String[] args) {
		int[][] triangle = 	{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		int answer = solution(triangle);
		System.out.println(answer);
	}
	
	public static int solution(int[][] triangle) {
		int dp[][] = new int[triangle.length][];
		
		dp[0] = triangle[0];
		
		for(int i=1; i<triangle.length; i++) {
			int[] temp = new int[triangle[i].length]; 
			for(int j=0; j<triangle[i].length; j++) {
				if(j==0) {
					temp[j] = dp[i-1][j] + triangle[i][j];
				}else if(j==triangle[i].length-1) {
					temp[j] = dp[i-1][j-1] + triangle[i][j];
				}else {
					temp[j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
				}
			}
			dp[i] = temp;
		}
		
		return Arrays.stream(dp[triangle.length-1]).max().getAsInt();
	}
}
