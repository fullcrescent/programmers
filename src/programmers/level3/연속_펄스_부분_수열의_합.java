package programmers.level3;

public class 연속_펄스_부분_수열의_합 {
    public static void main(String[] args){
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        long answer = solution(sequence);
        System.out.println(answer);

        int[] sequence1 = {2, 3, -6, 1, 3, -1, 2, 4};
        long answer1 = solution1(sequence1);
        System.out.println(answer1);
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

    /*다른 사람의 풀이 참고 - 변경X*/
    public static long solution1(int[] sequence) {
        return Math.max(function1(sequence, 1), function1(sequence, -1));
    }

    private static long function1(int[] sequence, int pulse) {
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
