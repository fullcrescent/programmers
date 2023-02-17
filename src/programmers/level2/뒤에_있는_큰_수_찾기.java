package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
    public static void main(String[] args){
        int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] answer = solution(numbers);
        System.out.println(Arrays.toString(answer));

        int[] numbers1 = {9, 1, 5, 3, 6, 2};
        int[] answer1 = solution1(numbers1);
        System.out.println(Arrays.toString(answer1));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<numbers.length; i++){
            while(!stack.isEmpty() && stack.peek()[0]<numbers[i]){
                int[] temp = stack.pop();
                answer[temp[1]] = numbers[i];
            }

            stack.add(new int[] {numbers[i], i});
        }

        for(int[] temp : stack) answer[temp[1]] = -1;

        return answer;
    }

    /*다른 사람의 풀이 참고*/
    public static int[] solution1(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<numbers.length; i++){
            while(!stack.isEmpty() && stack.peek()[0]<numbers[i]){
                int[] temp = stack.pop();
                answer[temp[1]] = numbers[i];
            }

            stack.add(new int[] {numbers[i], i});
        }

        return answer;
    }
}