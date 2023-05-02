package programmers.level2;

import java.util.Arrays;

public class 숫자_카드_나누기 {
    public static void main(String[] args){
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};
        int answer = solution(arrayA, arrayB);
        System.out.println(answer);

        int[] arrayA1 = {14, 35, 119};
        int[] arrayB1 = {18, 30, 102};
        int answer1 = solution1(arrayA1, arrayB1);
        System.out.println(answer1);
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

    private static int gcd(int big, int small) {
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

    /*다른 사람의 풀이 참고*/
    public static int solution1(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int gcdA = gcdArray(arrayA);
        int gcdB = gcdArray(arrayB);

        boolean a = Arrays.stream(arrayB).filter(i -> i%gcdA==0).findFirst().isEmpty();
        boolean b = Arrays.stream(arrayA).filter(i -> i%gcdB==0).findFirst().isEmpty();

        return a && b ? Math.max(gcdA, gcdB) : a ? gcdA : b ? gcdB : 0;
    }

    private static int gcdArray(int[] array){
        int gcd = array[0];
        for(int value : array)  gcd = gcd1(gcd, value);

        return gcd;
    }

    private static int gcd1(int big, int small) {
        if(small==0) return big;
        return gcd1(small, big%small);
    }
}
