package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 일일공_옮기기 {
    public static void main(String[] args) {
        String[] s = {"1100111011101001"};
        String[] answer = solution(s);
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[] s) {
        List<String> list = new ArrayList<>();

        for(String temp : s){
            int length = temp.length();

            while(temp.contains("110")){
                temp = temp.replaceAll("110", "");
            }

            StringBuilder sb = new StringBuilder(temp);

            sb.append("110".repeat((length-sb.length())/3));

            while(sb.indexOf("111")>=0 && sb.indexOf("111")<sb.lastIndexOf("110")){
                int insert = sb.indexOf("111");
                int delete = sb.lastIndexOf("110");

                sb.delete(delete, delete+3);
                sb.insert(insert, "110");
            }

            list.add(sb.toString());
        }

        return list.toArray(String[]::new);
    }
}
