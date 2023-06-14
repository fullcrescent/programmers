package programmers.level2;

import java.util.Arrays;
import java.util.stream.LongStream;

public class 숫자_블록 {
    public static void main(String[] args) {
        long begin = 1;
        long end = 10;
        int[] answer = solution(begin, end);
        System.out.println(Arrays.toString(answer));

        long begin1 = 1;
        long end1 = 10;
        int[] answer1 = solution1(begin1, end1);
        System.out.println(Arrays.toString(answer1));
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

    /*다른 사람의 풀이 참고 - 변경X*/
    public static int[] solution1(long begin, long end) {
        return LongStream.range(begin, end+1)
                .mapToInt(i -> {
                    if(i==1) return 0;
                    return (int) divisor1(i);
                })
                .toArray();
    }

    static final int max1 = 10000000;

    private static long divisor1(long input) {
        int value = 1;

        for(int i=2; i<=Math.sqrt(input); i++){
            if(input%i==0 && input/i<=max1){
                return input/i;
            }else if(input%i==0 && input/i>max1 && i<max1){
                value = i;
            }
        }

        return value;
    }
}
