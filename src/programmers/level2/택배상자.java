package programmers.level2;

import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args){
        int[] order = {5, 4, 3, 2, 1};
        int answer = solution(order);
        System.out.println(answer);
    }

    public static int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();

        int count = 0, index1 = 0, index2 = 0;

        while(index1<order.length){
            if(!stack.isEmpty() && stack.peek()==order[index2]){
                stack.pop();
                index2++;
                count++;
            }else if(index1+1==order[index2]){
                index2++;
                count++;
            }else{
                stack.add(index1+1);
            }

            index1++;
        }

        while(!stack.isEmpty()){
            if(stack.peek()==order[index2]){
                count++;
            }else{
                break;
            }
        }

        return count;
    }
}
