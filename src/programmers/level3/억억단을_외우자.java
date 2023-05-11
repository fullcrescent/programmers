package programmers.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class 억억단을_외우자 {
    public static void main(String[] args) {
        int e = 8;
        int[] starts = {1, 3, 7};
        int[] answer = solution(e, starts);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int start : starts){
            int max = 0;
            int value = 0;

            for(int i=start; i<=e; i++){
                if(map.get(i)==null)    map.put(i, divisorCount(i));

                if(max<map.get(i)){
                    max = map.get(i);
                    value=i;
                }
            }

            answer[index++] = value;
        }

        return answer;
    }

    private static int divisorCount(int value){
        int count = 0;

        for (int i = 1; i * i <= value; i++) {
            if (i * i == value){
                count++;
            }else if (value % i == 0){
                count += 2;
            }
        }

        return count;
    }
}
