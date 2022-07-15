package programmers.level3;

public class 보행자_천국 {

	public static void main(String[] args) {
		int m = 3;
		int n = 6;
		int[][] cityMap = {{0, 0, 0, 0, 0, 0}, {0, 2, 0, 2, 2, 2}, {1, 0, 0, 2, 2, 0}};
		int answer = solution(m, n, cityMap);
		System.out.println(answer);
	}
	
	static int MOD = 20170805;
	
	public static int solution(int m, int n, int[][] cityMap) {
		long dp[][] = new long[m+1][n+1];
		
		for(int i=0; i<m; i++) {
			if(cityMap[i][0]==1) break;
			if(cityMap[i][0]==2) continue;
			dp[i][0] = 1;
		}
		
		for(int i=0; i<n; i++) {
			if(cityMap[0][i]==1) break;
			if(cityMap[0][i]==2) continue;
			dp[0][i] = 1;
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(cityMap[i][j]==0) {
					long top  = cityMap[i-1][j]==1?0:dp[i-1][j];
					long left = cityMap[i][j-1]==1?0:dp[i][j-1];
					dp[i][j] += (long)(top+left)%MOD;
				}
				else if(cityMap[i][j]==2) {
					int tempI = i+1;
					int tempJ = j+1;
					
					if(cityMap[i-1][j]!=2) {
						while(tempI<m && cityMap[tempI][j]==2) {tempI++;}
						
						if(tempI<m && cityMap[tempI][j]!=1) {
							dp[tempI][j] = (dp[tempI][j]+dp[i-1][j])%MOD;
						}
					}
					
					if(cityMap[i][j-1]!=2) {
						while(tempJ<n && cityMap[i][tempJ]==2) {tempJ++;}
						
						if(tempJ<n && cityMap[i][tempJ]!=1) {
							dp[i][tempJ] = (dp[i][tempJ]+dp[i][j-1])%MOD;
						}
					}
				}
			}
		}
		
		return (int)dp[m-1][n-1];
	}
}
