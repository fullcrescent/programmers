package programmers.level3;

import java.util.*;

public class 표현_가능한_이진트리 {
    public static void main(String[] args){
        long[] numbers = {5};
        int[] answer = solution(numbers);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int index = 0;

        for(long number : numbers){
            String s = Long.toBinaryString(number);

            List<String> list = new ArrayList<>();
            StringBuilder zeroAdd = new StringBuilder();

            for(int i=0; i<s.length(); i++){
                list.add(zeroAdd + s);
                zeroAdd.append("0");
            }

            for(String temp : list){
                if(Math.log10(temp.length()+1)/Math.log10(2)%1!=0) continue;

                if(valid(temp, false)){
                    answer[index] = 1;
                    break;
                }
            }

            index++;
        }

        return answer;
    }

    private static boolean valid(String s, boolean zeroExists) {
        if(zeroExists){
            if(s.charAt(s.length()/2)=='1') return false;
        }

        if(s.length()==1)   return true;

        boolean value = zeroExists || s.charAt(s.length()/2)=='0';

        return valid(s.substring(0, s.length()/2), value)
                && valid(s.substring(s.length()/2+1), value);
    }
}
