package programmers.level2;

import java.util.Arrays;

public class 연속된_부분_수열의_합 {
    public static void main(String[] args){
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int[] answer = solution(sequence, k);
        System.out.println(Arrays.toString(answer));

        int[] sequence1 = {1, 2, 3, 4, 5};
        int k1 = 7;
        int[] answer1 = solution1(sequence1, k1);
        System.out.println(Arrays.toString(answer1));
    }

    public static int[] solution(int[] sequence, int k) {
        int leftIndex = sequence.length-1;
        int rightIndex = leftIndex;

        int sum = 0;

        while(true){
            if(sum==k){
                if(leftIndex>-1 && sequence[leftIndex]==sequence[rightIndex]){
                    leftIndex--;
                    rightIndex--;
                }else{
                    return new int[] {leftIndex+1, rightIndex};
                }
            }else if(sum<k){
                sum += sequence[leftIndex--];
            }else{
                sum -= sequence[rightIndex--];
            }
        }
    }

    /*다른 사람의 풀이 참고 - 변경X*/
    public static int[] solution1(int[] sequence, int k) {
        int leftIndex = sequence.length-1;
        int rightIndex = leftIndex;

        int sum = 0;

        while(true){
            if(sum==k){
                if(leftIndex>-1 && sequence[leftIndex]==sequence[rightIndex]){
                    leftIndex--;
                    rightIndex--;
                }else{
                    return new int[] {leftIndex+1, rightIndex};
                }
            }else if(sum<k){
                sum += sequence[leftIndex--];
            }else{
                sum -= sequence[rightIndex--];
            }
        }
    }
}