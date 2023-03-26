package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        List<Integer> list = new ArrayList<>();
        int temp = 0;

        for(int i=0; i<max; i++){
            if(minerals[i].equals("diamond")){
                temp += 25;
            }else if(minerals[i].equals("iron")){
                temp += 5;
            }else {
                temp += 1;
            }

            if((i+1)%5==0 || i==max-1){
                list.add(temp);
                temp = 0;
            }
        }

        list.sort(Comparator.reverseOrder());

        for(int value : list){
            if(picks[0]!=0){
                while(25<value){
                    answer++;
                    value -= 25;
                }

                while(5<value){
                    answer++;
                    value -= 5;
                }

                answer += value;

                picks[0] -= 1;
            }else if(picks[1]!=0){
                while(25<value){
                    answer += 5;
                    value -= 25;
                }

                while(5<value){
                    answer += 1;
                    value -= 5;
                }

                answer += value;
                picks[1] -= 1;
            }else{
                answer += value;
            }
        }

        return answer;
    }
}
