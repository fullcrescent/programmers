package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 광물_캐기 {
    public static void main(String[] args){
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int answer = solution(picks, minerals);
        System.out.println(answer);
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int max = Math.min(Arrays.stream(picks).sum()*5, minerals.length);
        List<int[]> list = new ArrayList<>();
        int[] temp = new int[3];

        for(int i=0; i<max; i++){
            if(minerals[i].equals("diamond")){
                temp[0] += 1;
                temp[1] += 5;
                temp[2] += 25;
            }else if(minerals[i].equals("iron")){
                temp[0] += 1;
                temp[1] += 1;
                temp[2] += 5;
            }else {
                temp[0] += 1;
                temp[1] += 1;
                temp[2] += 1;
            }

            if((i+1)%5==0 || i==max-1){
                list.add(temp);
                temp = new int[3];
            }
        }

        list.sort((i1, i2) -> -Integer.compare(i1[2], i2[2]));

        for(int[] value : list){
            if(picks[0]!=0){
                answer += value[0];
                picks[0] -= 1;
            }else if(picks[1]!=0){
                answer += value[1];
                picks[1] -= 1;
            }else{
                answer += value[2];
            }
        }

        return answer;
    }
}
