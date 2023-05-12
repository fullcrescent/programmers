package programmers.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Info> map = new HashMap<>();

        for(int start : starts){
            Info info = new Info();

            for(int i=start; i<=e; i++){
                Info tempInfo = map.get(i);

                if(tempInfo!=null){
                    if(info.divisorCount<tempInfo.divisorCount){
                        info.divisorCount = tempInfo.divisorCount;
                        info.value = tempInfo.value;
                    }
                    break;
                }

                if(info.divisorCount<divisorCount(i)){
                    info.divisorCount = divisorCount(i);
                    info.value=i;
                }
            }

            map.put(start, info);

            answer[index++] = info.value;
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

    static class Info{
        int value;
        int divisorCount;
    }
}
