package programmers.level2;

import java.util.*;
import java.util.stream.LongStream;

public class 시소_짝꿍 {
    public static void main(String[] args){
        int[] weights = {111, 222, 333, 444, 555};
        long answer = solution(weights);
        System.out.println(answer);

        int[] weights1 = {111, 222, 333, 444, 555};
        long answer1 = solution1(weights1);
        System.out.println(answer1);
    }

    public static long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Long> map = new HashMap<>();

        Arrays.stream(weights).forEach(i -> map.put(i, map.getOrDefault(i, 0L)+1L));

        answer += map.keySet().stream().mapToLong(i -> LongStream.range(1, map.get(i)).sum()).sum();

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(null);

        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if(valid(list.get(i), list.get(j))) answer += map.get(list.get(i))*map.get(list.get(j));

                if(list.get(i)*4<list.get(j)) break;
            }
        }

        return answer;
    }

    private static boolean valid(int w1, int w2) {
        for(int i=2; i<=4; i++){
            if(w1*i==w2*2 || w1*i==w2*3 || w1*i==w2*4)  return true;
        }
        return false;
    }

    /*다른 사람의 풀이 참고*/
    public static long solution1(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);

        Map<Double, Integer> map = new HashMap<>();

        for(double w : weights){
            if(map.containsKey(w)) answer += map.get(w);

            map.put(w, map.getOrDefault(w, 0)+1);
            map.put(w*4/3, map.getOrDefault(w*4/3, 0)+1);
            map.put(w*1.5, map.getOrDefault(w*1.5, 0)+1);
            map.put(w*2, map.getOrDefault(w*2, 0)+1);
        }

        return answer;
    }
}