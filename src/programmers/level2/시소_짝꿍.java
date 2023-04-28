package programmers.level2;

import java.util.*;
import java.util.stream.LongStream;

public class 시소_짝꿍 {
    public static void main(String[] args){
        int[] weights = {111, 222, 333, 444, 555};
        long answer = solution(weights);
        System.out.println(answer);
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
            if(w1*i%w2==0)  return true;
        }
        return false;
    }
}
