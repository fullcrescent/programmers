package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크_자르기 {
    public static void main(String[] args){
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int answer = solution(topping);
        System.out.println(answer);

        int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
        int answer1 = solution1(topping1);
        System.out.println(answer1);
    }

    public static int solution(int[] topping) {
        Map<Integer, Integer> map1 = new HashMap<>();

        for(int temp : topping){
            map1.put(temp, map1.getOrDefault(temp, 0)+1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        int count = 0;

        for(int temp : topping){
            map2.put(temp, map2.getOrDefault(temp, 0)+1);

            removeMap(map1, temp);

            if(map1.size()==map2.size()) count++;
        }

        return count;
    }

    private static void removeMap(Map<Integer, Integer> map, int remove) {
        if(map.get(remove)>1){
            map.put(remove, map.get(remove)-1);
        }else{
            map.remove(remove);
        }
    }

    /*다른 사람의 풀이 참고*/
    public static int solution1(int[] topping) {
        int count = 0;

        int[] left = new int[10001];
        int[] right = new int[10001];

        int leftCount = 0;
        int rightCount = 0;

        for(int temp : topping) right[temp]++;

        for(int temp : right)   rightCount += temp>0 ? 1 : 0;

        for(int temp : topping){
            right[temp]--;
            if(right[temp]==0)  rightCount--;

            if(left[temp]==0) leftCount++;
            left[temp]++;

            if(leftCount==rightCount) count++;
        }

        return count;
    }
}
