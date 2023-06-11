package programmers.level2;

import java.util.Arrays;
import java.util.stream.LongStream;

public class 숫자_블록 {
    public static void main(String[] args) {
        long begin = 1;
        long end = 10;
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

    static int max = 10000000;

    private static long divisor(long input){
        long start = input/2<max ? input/2 : max;

        for(long i=start; i<=input; i--){
            if(input%i==0) {
                return i;
            }
        }

        return 1;
    }
}
