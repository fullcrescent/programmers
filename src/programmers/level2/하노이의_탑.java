package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class 하노이의_탑 {
    public static void main(String[] args){
        int n = 4;
        int[][] answer = solution(n);
        Arrays.stream(answer).forEach(i -> Arrays.toString(i));
    }

    public static int[][] solution(int n) {
        List<Stack<Integer>> list = new ArrayList<>();
        /*stream.map으로 값 반환 stack 풀로 찬것을 기준으로 순서 매핑*/

        List<int[]> answer = new ArrayList<>();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        while(!stack1.isEmpty()){


            Stack<Integer> temp = stack2.peek() < stack3.peek() ? stack2 : stack3;

            int size = stack1.size();
            int value = stack1.pop();

            if(size%2==value%2){
                answer.add(new int[] {value, 2});
                stack2.add(value);
            }else{
                answer.add(new int[] {value, 3});
                stack3.add(value);
            }

        }

        return null;
    }
}
