package programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 표현_가능한_이진트리 {
    public static void main(String[] args){
        long[] numbers = {42};
        int[] answer = solution(numbers);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int i = 0;

        for(long number : numbers){
            String s = Long.toBinaryString(number);
            System.out.println(s);
            String[] sArray = {s, "0"+s};

            for(String temp : sArray){
                if(valid(temp)){
                    answer[i] = 1;
                    break;
                }
            }

            i++;
        }

        return answer;
    }

    private static boolean valid(String s) {
        if(Integer.toBinaryString(s.length()).contains("0")){
            return false;
        }

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[] {0, s.length()});

        while(!queue.isEmpty()){
            long[] temp = queue.poll();

            if(temp[0]+1==temp[1]){
                return true;
            }else if(s.charAt((int) ((temp[0]+temp[1])/2))=='0'){
                return false;
            }

            queue.add(new long[] {temp[0], (temp[0]+temp[1])/2});
            queue.add(new long[] {(temp[0]+temp[1])/2+1, temp[1]});
        }

        return true;
    }
}
