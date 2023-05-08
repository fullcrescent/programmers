package programmers.level3;

import java.util.*;

public class 표현_가능한_이진트리 {
    public static void main(String[] args){
        long[] numbers = {32};
        int[] answer = solution(numbers);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int index = 0;

        for(long number : numbers){
            String s = Long.toBinaryString(number);

            List<String> list = new ArrayList<>();
            String zeroAdd = "";

            for(int i=0; i<s.length(); i++){
                list.add(zeroAdd + s);
                zeroAdd += "0";
            }

            for(String temp : list){
                if(valid(temp)){
                    answer[index] = 1;
                    break;
                }
            }

            index++;
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
