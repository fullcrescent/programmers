package programmers.level3;

import java.util.*;

public class 표현_가능한_이진트리 {
    public static void main(String[] args){
        long[] numbers = {5};
        int[] answer = solution(numbers);
        System.out.println(Arrays.toString(answer));

        long[] numbers1 = {5};
        int[] answer1 = solution1(numbers1);
        System.out.println(Arrays.toString(answer1));
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

    /*다른 사람의 풀이 참고*/
    public static int[] solution1(long[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(i -> {
                    String s = Long.toBinaryString(i);
                    int zeroAdd = (1 <<(int) (Math.log10(s.length())/Math.log10(2)+1))-1 -s.length();

                    return "0".repeat(zeroAdd) + s;
                })
                .mapToInt(i -> {
                    if(valid1(i)) return 1;
                    else    return 0;
                })
                .toArray();
    }

    private static boolean valid1(String s) {
        if(s.replaceAll("0", "").length()==0 || s.length()==1)  return true;

        int mid = s.length()/2;

        if(s.charAt(mid)=='0'){
            return false;
        }else{
            return valid1(s.substring(0, mid)) && valid1(s.substring(mid+1));
        }
    }
}
