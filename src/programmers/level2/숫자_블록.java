package programmers.level2;

import java.math.BigInteger;
import java.util.Arrays;

public class 숫자_블록 {
    public static void main(String[] args) {
        long begin = 1;
        long end = 10;
        int[] answer = solution(begin, end);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(long begin, long end) {
        int length = (int) (end-begin+1);
        int[] array = new int[length];

        int index = 0;

        if(begin==1){
            array[index++] = 0;
            begin++;
        }

        int max = end/2<10000000 ? (int) end/2 : 10000000;

        for(long i=begin; i<=end; i++){
            if(isPrime(i)){
                array[index++] = 1;
            }else{
                for(int j=max; j>0; j--){
                    if(i%j==0 && j!=i){
                        array[index++] = j;
                        break;
                    }
                }
            }
        }

        return array;
    }

    private static boolean isPrime(long value) {
        for(long i=2; i<=Math.sqrt(value); i++) {
            if(value%i==0) {
                return false;
            }
        }

        return true;
    }
}
