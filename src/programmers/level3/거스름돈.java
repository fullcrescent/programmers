package programmers.level3;

public class 거스름돈 {
    public static void main(String[] args) {
        int n = 5;
        int[] money = {1,2,5};
        int answer = solution(n, money);
        System.out.println(answer);
    }

    public static int solution(int n, int[] money) {
        int[] dp = new int[n+1];

        for(int temp : money){
            dp[temp] = 1;
        }

        for(int i=1; i<=n; i++){
            if(dp[i]==0)    continue;

            for(int j=2*i; j<=n; j+=i){
                dp[j] += dp[i];
            }
        }

        return dp[n];
    }
}