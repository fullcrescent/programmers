package programmers.level3;

/*2*n 타일링*/
public class 타일링 {

	public static void main(String[] args) {
		int n = 5;
		int answer = solution(n);
		System.out.println(answer);
		
		int n1 = 5;
		int answer1 = solution1(n1);
		System.out.println(answer1);
	}

	public static int solution(int n) {
		long vertical = 1;
		long horizontal = 1;
		
		long index = 2;
		
		while(index++<n) {
			long temp = vertical; 
			vertical = ((vertical+horizontal)%1000000007);
			horizontal = temp;
		}
		
		return (int) ((vertical+horizontal)%1000000007);
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int n) {
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-2] + dp[i-1])%1000000007;
		}
		
		return dp[n];
	}
}
