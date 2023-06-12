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

    static final int max = 10000000;

    private static long divisor(long input) {
        int value = 1;

        for(int i=2; i<=Math.sqrt(input); i++){
            if(input%i==0 && input/i<=max){
                return input/i;
            }else if(input%i==0 && input/i>max && i<max){
                value = i;
            }
        }

        return value;
    }
}
