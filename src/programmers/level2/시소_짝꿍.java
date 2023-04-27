package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 시소_짝꿍 {
    public static void main(String[] args){
        int[] weights = {100,180,360,100,270, 100};
        long answer = solution(weights);
        System.out.println(answer);
    }

    public static long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key)>1) answer++;
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort(null);

        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if(valid(list.get(i), list.get(j))) answer++;

                if(list.get(i)*4<list.get(j)) break;
            }
        }

        return answer;
    }

    private static boolean valid(int w1, int w2) {
        for(int i=2; i<=4; i++){
            if(w1*i%w2==0) return true;
        }

        return false;
    }
}
