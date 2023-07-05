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
            StringBuilder sb = new StringBuilder(temp);
            StringBuilder add = new StringBuilder();

            while(sb.indexOf("110")!=-1){
                int index_110 = sb.indexOf("110");
                sb.delete(index_110, index_110+3);
                add.append("110");
            }

            sb.insert(sb.lastIndexOf("0")+1, add);

            list.add(sb.toString());
        }

        return list.toArray(String[]::new);
    }
}
