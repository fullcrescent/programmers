package programmers.level2;

import java.util.Arrays;

public class 연속된_부분_수열의_합 {
    public static void main(String[] args){
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int[] answer = solution(sequence, k);
        System.out.println(Arrays.toString(answer));
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
}