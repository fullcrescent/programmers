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

            while(true){
                String prev = sb.toString();

                int index_110 = sb.indexOf("110");
                int lastIndex_110 = sb.lastIndexOf("110");
                int index_111 = sb.indexOf("111");

                if(index_110!=-1){
                    if(index_111==-1){
                        sb.delete(index_110, index_110+3);
                        sb.insert(sb.lastIndexOf("0")+1, "110");
                    }else if(lastIndex_110>index_111){
                        sb.delete(lastIndex_110, lastIndex_110+3);
                        sb.insert(index_111, "110");
                    }
                }

                if(prev.equals(sb.toString()))  break;
            }

            list.add(sb.toString());
        }

        return list.toArray(String[]::new);
    }
}
