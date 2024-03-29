package programmers.level3;

import java.util.*;
import java.util.stream.IntStream;

public class 모두_0으로_만들기 {
    public static void main(String[] args){
        int[] a = {-5,0,2,1,2};
        int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
        int answer = solution(a, edges);
        System.out.println(answer);
    }

    public static int solution(int[] a, int[][] edges) {
        if(Arrays.stream(a).sum()!=0)   return -1;

        int answer = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        boolean[] visit = new boolean[a.length];

        for(var temp : edges){
            List<Integer> list;

            list = listMap.getOrDefault(temp[0], new ArrayList<>());
            list.add(temp[1]);
            listMap.put(temp[0], list);

            list = listMap.getOrDefault(temp[1], new ArrayList<>());
            list.add(temp[0]);
            listMap.put(temp[1], list);
        }

        for(var key : listMap.keySet()){
            countMap.put(key, listMap.get(key).size());
        }

        while(true){
            for(var key : countMap.keySet()){
                if(!visit[key] && countMap.get(key)==1){
                    visit[key] = true;
                    answer += Math.abs(a[key]);

                    var link = listMap.get(key).get(0);
                    a[link] += a[key];
                    countMap.put(link, countMap.get(link)-1);

                    if(IntStream
                            .range(0, visit.length)
                            .filter(i -> visit[i])
                            .count()==visit.length-1) return answer;
                }
            }
        }
    }
}
