package programmers.level3;

public class 아방가르드_타일링 {
    public static void main(String[] args){
        int n = 9;
        int answer = solution(n);
        System.out.println(answer);
    }

    public static int solution(int n) {
        if(n==1) return 1;
        if(n==2) return 3;

        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]*2 + dp[i-3]*5 + add(dp, i-4))%1000000007;
        }

        return (int) dp[n];
    }

    private static long add(long[] dp, int i) {
        long sum = 0;
        int[] array = new int[] {2, 2, 4};
        int index = 0;

        while(i>-1){
            sum += dp[i--]*array[index++%3];
        }

        return sum;
    }
}
