package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class 하노이의_탑 {
    public static void main(String[] args){
        int n = 2;
        int[][] answer = solution(n);
        Arrays.stream(answer).forEach(i -> Arrays.toString(i));
    }

    public static int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        IntStream.range(1, n+1).forEach(i -> stack1.add(i));

        if(stack1.size()%2==0){

        }

        while(!stack1.isEmpty()){
            int size = stack1.size();
            int value = stack1.pop();

            if(stack2.isEmpty()){
                answer.add(new int[] {1, 2});
                stack2.add(value);
            }

            if(stack3.isEmpty()){
                answer.add(new int[] {1, 3});
                stack3.add(value);
            }

        }

        return null;
    }
}
