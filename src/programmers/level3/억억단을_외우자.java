package programmers.level3;

import java.util.*;

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
        int max = Integer.MAX_VALUE;

        Map<Integer, Info> map = new HashMap<>();
        Arrays.sort(starts);

        for(int i=starts.length-1; i>-1; i--){
            int start = starts[i];
            Info info = new Info();

            for(int j=start; j<=e; j++){
                if(max<=j){
                    Info tempInfo = map.get(j);

                    if(info.divisorCount<tempInfo.divisorCount){
                        info.divisorCount = tempInfo.divisorCount;
                        info.value = tempInfo.value;
                    }

                    break;
                }

                if(info.divisorCount<divisorCount(j)){
                    info.divisorCount = divisorCount(j);
                    info.value=j;
                }
            }

            map.put(start, info);

            answer[index++] = info.value;
            max = start;
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
