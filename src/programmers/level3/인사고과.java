package programmers.level3;

import java.util.*;
import java.util.stream.Collectors;

public class 인사고과 {
    public static void main(String[] args){
        int[][] scores = {{2,40},{10,40}, {10,41}, {10,39}};
        int answer = solution(scores);
        System.out.println(answer);
    }

    public static int solution(int[][] scores) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();

        for(int[] temp : scores) {
            List<Integer> tempList;

            tempList = map1.getOrDefault(temp[0], new LinkedList<>());
            tempList.add(temp[1]);
            map1.put(temp[0], tempList);

            tempList = map2.getOrDefault(temp[1], new LinkedList<>());
            tempList.add(temp[0]);
            map2.put(temp[1], tempList);
        }

        for(Integer key : map1.keySet()){
            map1.get(key).sort(Comparator.reverseOrder());
        }
        for(Integer key : map2.keySet()){
            map2.get(key).sort(Comparator.reverseOrder());
        }

        List<Integer> keyList1 = map1.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> keyList2 = map2.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        List<Integer> sumList;
        if(keyList1.size()<keyList2.size()){
            sumList = find(scores, map1, keyList1, 0, 1);
        }else{
            sumList = find(scores, map2, keyList2, 1, 0);
        }

        return sumList==null ? -1 : sumList.indexOf(scores[0][0]+scores[0][1])+1;
    }

    private static List<Integer> find(int[][] scores, Map<Integer, List<Integer>> map, List<Integer> keyList, int prev, int next) {
        List<Integer> list = new ArrayList<>();

        Loop :
        for(int i=0; i<scores.length; i++){
            for(int j=0; j<keyList.size() & scores[i][prev]<keyList.get(j); j++){
                if(map.get(keyList.get(j)).get(0)>scores[i][next]){
                    if(i==0)    return null;

                    continue Loop;
                }
            }

            list.add(scores[i][prev] + scores[i][next]);
        }

        list.sort(Comparator.reverseOrder());

        return list;
    }
}
