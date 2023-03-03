package programmers.level3;

public class 연속_펄스_부분_수열의_합 {
    public static void main(String[] args){
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        long answer = solution(sequence);
        System.out.println(answer);
    }

    public static long solution(int[] sequence) {
        return Math.max(function(sequence, 1), function(sequence, -1));
    }

    private static long function(int[] sequence, int pulse) {
        long max = 0, sum = 0;

        for(long temp : sequence){
            sum += temp*pulse;
            pulse *= -1;

            if(sum<0){
                sum = 0;
                continue;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
