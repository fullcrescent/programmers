package programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 표현_가능한_이진트리 {
    public static void main(String[] args){
        long[] numbers = {682, 7, 42, 5, 63, 111, 95};
        int[] answer = solution(numbers);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int i = 0;

        for(long number : numbers){
            String s = Long.toBinaryString(number);
            if(s.length()%2==0) s = "0" + s;
            System.out.println(s);

            if(Integer.toBinaryString(s.length()).contains("0")){
                i++;
                continue;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {0, s.length()});

            while(!queue.isEmpty()){
                int[] temp = queue.poll();

                if(temp[0]+1==temp[1]){
                    answer[i++] = 1;
                    break;
                }else if(s.charAt((temp[0]+temp[1])/2)=='0'){
                    i++;
                    break;
                }

                queue.add(new int[] {temp[0], (temp[0]+temp[1])/2});
                queue.add(new int[] {(temp[0]+temp[1])/2+1, temp[1]});
            }
        }

        return answer;
    }
}
