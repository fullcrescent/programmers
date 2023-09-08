package programmers.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 유전법칙 {
    public static void main(String[] args) {
        int[][] queries = {{4, 26}};
        String[] answer = solution(queries);
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        int index = 0;
        String[] array = {"RR", "Rr", "Rr", "rr"};

        for(int[] query : queries){
            int gen = query[0];
            int order = query[1]-1;

            List<Integer> list = new ArrayList<>();

            while(gen>0){
                gen--;
                list.add(order%4);
                order /= 4;
            }

            if(list.size()==1){
                answer[index] = "Rr";
                index++;
                continue;
            }

            for(int i=list.size()-2; i>-1; i--){
                answer[index] = array[list.get(i)];

                if(!array[list.get(i)].equals("Rr")){
                    break;
                }
            }

            index++;
        }

        return answer;
    }
}
