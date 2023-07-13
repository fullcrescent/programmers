package programmers.level3;

import java.util.Arrays;

public class 거스름돈 {
    public static void main(String[] args) {
        int n = 6;
        int[] money = {1,2,5};
        int answer = solution(n, money);
        System.out.println(answer);
    }

    public static int solution(int n, int[] money) {
        int mod = 1000000007;

        int[] dp = new int[n+1];
        dp[0] = 1;

        Arrays.stream(money)
                .forEach(i -> {
                    for(int j=i; j<=n; j++){
                        dp[j] += dp[j-i]%mod;
                    }
                });

        return dp[n];
    }
}