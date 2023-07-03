package programmers.level3;

import java.util.Arrays;

public class 일일공_옮기기 {
    public static void main(String[] args) {
        String[] s = {"100111100","0111111010"};
        String[] answer = solution(s);
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[] s) {
        StringBuffer sb = new StringBuffer();

        for(String temp : s){
            sb.append(temp);

            while(sb.indexOf("111")>=0 && sb.indexOf("110")>=0){
                int insert = sb.indexOf("111");
                int delete = sb.indexOf("110");

                sb.delete(delete, delete+3);
                sb.insert(insert, "110");
            }

            sb.delete(0, sb.length());
        }


        return null;
    }
}
