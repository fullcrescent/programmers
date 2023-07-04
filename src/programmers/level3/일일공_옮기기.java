package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 일일공_옮기기 {
    public static void main(String[] args) {
        String[] s = {"100111100","0111111010"};
        String[] answer = solution(s);
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[] s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(String temp : s){
            sb.append(temp);

            while(sb.indexOf("111")>=0 && sb.lastIndexOf("110")>=0 && sb.indexOf("111")<sb.lastIndexOf("110")){
                int insert = sb.indexOf("111");
                int delete = sb.lastIndexOf("110");

                sb.delete(delete, delete+3);
                sb.insert(insert, "110");
            }

            list.add(sb.toString());
            sb.delete(0, sb.length());
        }

        return list.toArray(String[]::new);
    }
}
