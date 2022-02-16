package programmers.level2;

public class 피보나치_수 {

	public static void main(String[] args) {
		int n = 3;
		int answer = solution(n);
		System.out.println(answer);
		
		int n1 = 3;
		int answer1 = solution1(n1);
		System.out.println(answer1);
	}
	
	public static int solution(int n) {
		f = new int[n];
		return fibonacci(n);
	}
	
	static int[] f;
	
	public static int fibonacci(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}
		
		if(f[n-1]==0) {
			f[n-1] = fibonacci(n-1)%1234567;		// % 필요없음
		}
		
		if(f[n-2]==0) {
			f[n-2] = fibonacci(n-2)%1234567;		// % 필요없음
		}
		
		return (f[n-1] + f[n-2])%1234567;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%1234567;
		}
		
		return dp[n];
	}
}
