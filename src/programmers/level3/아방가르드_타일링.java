package programmers.level3;

import java.util.stream.IntStream;

public class 아방가르드_타일링 {
    public static void main(String[] args){
        int n = 9;
        int answer = solution(n);
        System.out.println(answer);

        int n1 = 9;
        int answer1 = solution1(n1);
        System.out.println(answer1);
    }

    public static int solution(int n) {
        if(n==1) return 1;
        if(n==2) return 3;

        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;

        for(int i=3; i<=n; i++){
            // 1 > 1 : 1
            // 2 > 1+1>1 / 2>2 : 3
            // 3 > 1+1+1>1 / 1+2>2 / 2+1>2 / 3>5 : 10
            // 4 > 1+1+1+1>1 / 1+1+2>2 / 1+2+1>2 / 1+3>5 || 2+1+1>2 / 2+2>4 || 3+1>5 || 질문하기 테스트 케이스 참고:add>2 : 21 + 2
            dp[i] = (dp[i-1] + dp[i-2]*2 + dp[i-3]*5 + add(dp, i-4))%1000000007;
        }

        return (int) dp[n];
    }

    private static long add(long[] dp, int end) {
        int[] array = new int[] {2, 2, 4};

        return IntStream.range(0, end+1)
                .mapToLong(i -> dp[i]*array[(end-i)%3])
                .sum();
    }

    /*다른 사람의 풀이 참고*/
    public static int solution1(int n) {
        int mod = 1000000007;
        long[] dp = new long[100001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 10;
        dp[4] = 23;
        dp[5] = dp[4] + dp[3]*2 + dp[2]*5 + dp[1]*2 + dp[0]*2;

        for(int i=6; i<=n; i++){
          //dp[i] = (dp[i-1] + dp[i-2]*2 + dp[i-3]*5 + add(dp, i-4))        % mod;
            dp[i] = (dp[i-1] + dp[i-2]*2 + dp[i-3]*6 + dp[i-4]-dp[i-6]+mod) % mod;
        }

        return (int) dp[n];
    }
}
