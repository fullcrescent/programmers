package programmers.level2;

import java.util.Arrays;

public class 뒤에_있는_큰_수_찾기 {
    public static void main(String[] args){
        int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] answer = solution(numbers);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int max = numbers[numbers.length-1];

        for(int i=numbers.length-1; i>-1; i--){
            if(numbers[i]>=max){
                max = numbers[i];
                answer[i] = -1;
                continue;
            }

            int j = i;
            while(j++<numbers.length){
                if(numbers[i]<numbers[j])   break;
            }

            answer[i] = numbers[j];
        }

        return answer;
    }
}
