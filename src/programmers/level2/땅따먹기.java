package programmers.level2;

public class 땅따먹기 {

	public static void main(String[] args) {
		int[][] land = {{1,2,3,1003},{5,6,7,1507},{4,3,2,1004}};
		int answer = solution(land);
		System.out.println(answer);
		
		int[][] land1 = {{1,2,3,1003},{5,6,7,1507},{4,3,2,1004}};
		int answer1 = solution1(land1);
		System.out.println(answer1);
	}

	public static int solution(int[][] land) {
		int[][] dp = new int[land.length][land[0].length];
		
		for(int i=0; i<land[0].length; i++) {
			dp[0][i] = land[0][i];
		}
		
		for(int i=1; i<land.length; i++) {
			for(int j=0; j<land[i].length; j++) {
				for(int k=0; k<land[i].length; k++) {
					if(j==k) continue;
					
					dp[i][j] = Math.max(dp[i][j], land[i][j]+dp[i-1][k]);
				}
			}
		}
		
		int answer = 0;
		
		for(int i=0; i<land[0].length; i++) {
			answer = Math.max(answer, dp[land.length-1][i]);
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[][] land) {
		for(int i=1; i<land.length; i++) {
			land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));  
			land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
			land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
			land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
		}

		return Math.max(land[land.length-1][0], Math.max(land[land.length-1][1], Math.max(land[land.length-1][2], land[land.length-1][3])));
	}
}
