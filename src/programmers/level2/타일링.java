package programmers.level2;

public class 타일링 {

	public static void main(String[] args) {
		int n = 8;
		int answer = solution(n);
		System.out.println(answer);
	}
	
	public static int solution(int n) {
		int[] dp = new int[n+1];
		dp[2] = 3;
		dp[4] = 11;

		// 기존 경우의 수*3 + 기존 경우의 수에서 가로로 되어있는 건 제외
		for(int i=6; i<=n; i=i+2){
			dp[i] = dp[i-2]*3 + (dp[i-2]-dp[i-4])%1000000007;
		}

		return dp[n];
	}
}
