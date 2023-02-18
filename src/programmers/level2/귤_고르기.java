package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

public class 귤_고르기 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int answer = solution(k, tangerine);
        System.out.println(answer);

        int k1 = 6;
        int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};
        int answer1 = solution1(k1, tangerine1);
        System.out.println(answer1);
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

    /*다른 사람의 풀이 참고*/
    public static int solution1(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int temp : tangerine){
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        List<Integer> list = map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        int count = 0;

        while(k>0)  k -= list.get(count++);

        return count;
    }
}