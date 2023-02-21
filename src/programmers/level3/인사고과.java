package programmers.level3;

import java.util.*;
import java.util.stream.Collectors;

public class 인사고과 {
    public static void main(String[] args){
        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        int answer = solution(scores);
        System.out.println(answer);
    }

    public static int solution(int[][] scores) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] temp : scores) {
            List<Integer> tempList;

            tempList = map.getOrDefault(temp[0], new ArrayList<>());
            tempList.add(temp[1]);
            map.put(temp[0], tempList);
        }

        for(Integer key : map.keySet()){
            map.get(key).sort(null);
        }

        List<Integer> keyList = map.keySet().stream().sorted().collect(Collectors.toList());

        for(int[] score : scores){
            int length = 0;
            while(keyList.get(length)<score[0]) {length++;}

            for(int i=0; i<length; i++){
                map.get(keyList.get(i)).removeIf(value -> value<score[1]);
            }
        }


        return 0;
    }
}
