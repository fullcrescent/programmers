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
                    if(i%2==0)  return (int) (i/2);
                    return divisor(i);
                })
                .toArray();
    }

    private static int divisor(long input){
        int value = (int) (input/2);

        for(int i = value; i>0; i--){
            if(input%i==0) return i;
        }

        return 0;
    }
}
