package programmers.level3;

import java.util.Arrays;

public class 거스름돈 {
    public static void main(String[] args) {
        int n = 6;
        int[] money = {1,2,5};
        int answer = solution(n, money);
        System.out.println(answer);

        int n1 = 6;
        int[] money1 = {1,2,5};
        int answer1 = solution1(n1, money1);
        System.out.println(answer1);
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

    /*다른 사람의 풀이 참고*/
    public static int solution1(int n, int[] money) {
        int[] dp = new int[n+1];

        for(int temp : money){
            dp[temp] += 1;

            for(int i=1; i<=n; i++){
                if(temp<=i){
                    dp[i] += dp[i-temp];
                }
            }
        }

        return dp[n];
    }
}