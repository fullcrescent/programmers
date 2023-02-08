package programmers.level2;

import java.util.*;

public class 귤_고르기 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int answer = solution(k, tangerine);
        System.out.println(answer);
    }

    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int temp : tangerine){
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        for(Integer key : map.keySet()){
            list.add(map.get(key));
        }

        list.sort(Collections.reverseOrder());

        int count = 0;

        while(k>0){
            k -= list.get(count);
            count++;
        }

        return count;
    }
}
