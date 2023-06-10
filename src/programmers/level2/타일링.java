package programmers.level2;

public class 타일링 {

	public static void main(String[] args) {
		int n = 1000;
		int answer = solution(n);
		System.out.println(answer);

		int n1 = 1000;
		int answer1 = solution1(n1);
		System.out.println(answer1);
	}
	
	public static int solution(int n) {
		long[] dp = new long[n+1];
		dp[2] = 3;
		dp[4] = 11;

		// 기존 경우의 수*3 + 기존 경우의 수에서 가로로 되어있는 건 제외
		for(int i=6; i<=n; i=i+2){
			dp[i] = dp[i-2]*3 + (dp[i-2]-dp[i-4]);
			dp[i] = (dp[i]+1000000007)%1000000007;
		}

		return (int) dp[n];
	}

	/*다른 사람의 풀이 참고 - 변경X*/
	public static int solution1(int n) {
		long[] dp = new long[n+1];
		dp[2] = 3;
		dp[4] = 11;

		// 기존 경우의 수*3 + 기존 경우의 수에서 가로로 되어있는 건 제외
		for(int i=6; i<=n; i=i+2){
			dp[i] = dp[i-2]*3 + (dp[i-2]-dp[i-4]);
			dp[i] = (dp[i]+1000000007)%1000000007;
		}

		return (int) dp[n];
	}
}
