package programmers.level2;

import java.util.Arrays;

public class 숫자_카드_나누기 {
    public static void main(String[] args){
        int[] arrayA = {10, 20};
        int[] arrayB = {5, 17};
        int answer = solution(arrayA, arrayB);
        System.out.println(answer);
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for(int array : arrayA) gcdA = gcd(gcdA, array);
        for(int array : arrayB) gcdB = gcd(gcdB, array);

        Loop :
        while(gcdA>1 || gcdB>1){
            int value = Math.max(gcdA, gcdB);

            for(int array : gcdA<gcdB ? arrayA : arrayB){
                if(array%value==0){
                    if(gcdA==value){
                        gcdA = maxDivisor(value);
                    }else{
                        gcdB = maxDivisor(value);
                    }

                    continue Loop;
                }
            }

            return value;
        }

        return 0;
    }

    public static int gcd(int big, int small) {
        if(small==0) return big;
        return gcd(small, big%small);
    }

    private static int maxDivisor(int value){
        int start = value/2;

        while(true){
            if(value%start==0)  return start;
            start--;
        }
    }
}
