package programmers.level2;

import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args){
        int[] order = {1,2,4,3,5};
        int answer = solution(order);
        System.out.println(answer);

        int[] order1 = {1,2,4,3,5};
        int answer1 = solution1(order1);
        System.out.println(answer1);
    }

    public static int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();

        int index = 1, orderIndex = 0;

        while(index<=order.length){
            if(index==order[orderIndex]){
                orderIndex++;
                index++;
            }else if(!stack.isEmpty() && stack.peek()==order[orderIndex]){
                orderIndex++;
                stack.pop();
            }else{
                stack.add(index++);
            }
        }

        while(!stack.isEmpty()){
            if(stack.peek()!=order[orderIndex]) break;

            stack.pop();
            orderIndex++;
        }

        return orderIndex;
    }

    /*다른 사람의 풀이 참고*/
    public static int solution1(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=1; i<=order.length; i++){
            stack.add(i);

            while(!stack.isEmpty()){
                if(stack.peek()!=order[answer])  break;

                stack.pop();
                answer++;
            }
        }

        return answer;
    }
}
