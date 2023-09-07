package programmers.etc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 외톨이_알파벳 {
    public static void main(String[] args) {
        String input_string = "edeaaabbccd";
        String answer = solution(input_string);
        System.out.println(answer);
    }

    public static String solution(String input_string) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<input_string.length(); i++){
            map.put(input_string.charAt(i), map.getOrDefault(input_string.charAt(i), 0)+1);
        }

        int index = 0;
        char temp = '-';
        int count = 0;

        while(index<input_string.length()){
            char c = input_string.charAt(index);
            if(temp==c){
                count++;
            }else{
                temp = c;
                count=1;
            }
            index++;

            if(map.get(c)==count){
                map.remove(c);
            }
        }

        Set<Character> list = map.keySet();
        StringBuilder answer = new StringBuilder();

        for(Character c : list){
            answer.append(c);
        }

        return map.size()==0 ? "N" : answer.toString();
    }
}
