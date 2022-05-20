package programmers.level3;

public class 등굣길 {

	public static void main(String[] args) {
		int m = 99;
		int n = 99;
		int[][] puddles = {{2, 2}};
		int answer = solution(m, n, puddles);
		System.out.println(answer);
		
		int m1 = 99;
		int n1 = 99;
		int[][] puddles1 = {{2, 2}};
		int answer1 = solution1(m1, n1, puddles1);
		System.out.println(answer1);
	}
	
	public static int solution(int m, int n, int[][] puddles) {
		long dp[][] = new long[n][m];
		
		for(int i=0; i<puddles.length; i++) {
			dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
		}
		
		for(int i=m-1; i>-1; i--) {
			if(dp[n-1][i]==-1) break;
			dp[n-1][i] = 1;
		}
		
		for(int i=n-1; i>-1; i--) {
			if(dp[i][m-1]==-1) break;
			dp[i][m-1] = 1;
		}
		
		for(int i = n-2; i>-1; i--) {
			for(int j=m-2; j>-1; j--) {
				if(dp[i][j]==-1) continue;
				long bottom = dp[i+1][j]==-1?0:dp[i+1][j];
				long right = dp[i][j+1]==-1?0:dp[i][j+1];
				dp[i][j] = (bottom + right)%1000000007;
			}
		}
		
		return (int)dp[0][0];
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int m, int n, int[][] puddles) {
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0; i<puddles.length; i++) {
			dp[puddles[i][0]][puddles[i][1]] = -1;
		}

		dp[1][1] = 1;
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(dp[i][j]==-1){
					dp[i][j] = 0;
				}else {
					if(i!=1) dp[i][j] += dp[i-1][j]%1000000007;
					if(j!=1) dp[i][j] += dp[i][j-1]%1000000007;
				}
			}
		}
		
		return dp[m][n]%1000000007;
	}
}
