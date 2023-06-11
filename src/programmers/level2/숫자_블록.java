package programmers.level2;

import java.util.Arrays;
import java.util.stream.LongStream;

public class 숫자_블록 {
    public static void main(String[] args) {
        long begin = 999999500;
        long end = 1000000000;
        int[] answer = solution(begin, end);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(long begin, long end) {
        return LongStream.range(begin, end+1)
                .mapToInt(i -> {
                    if(i==1) return 0;
                    return (int) divisor(i);
                })
                .toArray();
    }

    private static long divisor(long input){
        long start = input/10000000<2 ? 2 : input/10000000;

        for(long i=start; i<=Math.sqrt(input); i++){
            if(input%i==0) {
                return input/i;
            }
        }

        return 1;
    }
}
